package com.stepup.MmlnTask_04.loggers;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Component
public class BeanPostProcessorLog implements BeanPostProcessor {
    private Map<String, Object> beans  = new HashMap<>();
    private static boolean firstPass = true;
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (Arrays.stream(bean.getClass().getDeclaredMethods()).anyMatch(m->m.isAnnotationPresent(LogTransformation.class)))
            beans.put(beanName, bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(beans.containsKey(beanName)){
            beans.remove(beanName);
           ProxyFactory proxyFactory = new ProxyFactory(bean);
           proxyFactory.setProxyTargetClass(true);
           proxyFactory.addAdvice(new LoggingInterceptor());
           return proxyFactory.getProxy();
        }
        return bean;
    }

    private  class LoggingInterceptor implements MethodInterceptor {
        private <T> T getObjectByType(Object obj, Class <T> cl){
            return (T) obj;
        }

        @Override
        public Object invoke(MethodInvocation methodInvocation) throws Throwable {
            Method meth = methodInvocation.getMethod();
            List<String> outStr = new ArrayList<>();
            Object returnValue = methodInvocation.proceed();
            if (meth.isAnnotationPresent(LogTransformation.class)){
                outStr.add(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")) +
                        " {Method " + meth.getName() + "} the next data ready to push in database:");
                outStr.add(getObjectByType(returnValue, meth.getReturnType()).toString());
                Path textFile = Paths.get(meth.getDeclaredAnnotation(LogTransformation.class).value());
                if(firstPass)
                    Files.write(textFile, outStr, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
                else
                    Files.write(textFile, outStr, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                firstPass = false;
            }
            return returnValue;
        }
    }
}
