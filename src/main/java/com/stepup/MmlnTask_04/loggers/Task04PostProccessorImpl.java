package com.stepup.MmlnTask_04.loggers;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Component
public class Task04PostProccessorImpl implements BeanPostProcessor {
    private static boolean firstPass = true;
    private <T> T getObjectByType(Object obj, Class <T> cl){
        return (T) obj;
    }
    @Override
    //это происходит до инит-метода бина
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {


        return bean;
    }

    @Override
    //это происходит после инит-метода бина
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //если нет аннотации Loggable
        if (!bean.getClass().isAnnotationPresent(LogTransformation.class))
            return bean;
//        System.out.println("bean.getClass()=" + bean.getClass().toString());
        //если есть аннотация Loggable
        //создаем экземпляр "улучшателя" - построителя новых классов(!)
        Enhancer enhancer = new Enhancer();
        //говорим, что порождаемые классы будут потомками класса нашего текущего бина
        enhancer.setSuperclass(bean.getClass());
        //добавляем обработчик, который будет перехватывать вызовы методов
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            //собственно, логика перехвата вызова метода
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                Object returnValue = method.invoke(bean, args);
                if(method.getName() == "process" && obj.getClass().isAnnotationPresent(LogTransformation.class)) {
                    List<String> outStr = new ArrayList<>();
                    Path textFile = Paths.get(obj.getClass().getAnnotation(LogTransformation.class).value());
//                    System.out.println("interceptor!!!! firstPass=" + firstPass);
//                    System.out.printf("Log: bean: %s, method: %s datetime: %s", beanName, method.getName(), Calendar.getInstance().getTime() + "\n\n");
                    outStr.add(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")) +
                           "{ " + obj.getClass().toString() + "." + method.getName() + " } data for database:");
                    outStr.add(getObjectByType(returnValue, method.getReturnType()).toString());
                    if (firstPass)
                        Files.write(textFile, outStr, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
                    else
                        Files.write(textFile, outStr, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                    firstPass = false;
                }
                return returnValue;
            }
        });
        //возвращаем экземпляр "улучшенного" бина, но он не знает, что передавать в конструктор
        //берм первый попавшийся конструктор
        Constructor cons= bean.getClass().getConstructors()[0];
        //новый массив формальных элементов  по количеству аргументов конструктора
        Object [] arr=new Object[cons.getParameterCount()];
        //возвращаем экземпляр "улучшенного" бина
        //так себе реализация
        return enhancer.create(cons.getParameterTypes(),arr);
    }
}
