package com.stepup.MmlnTask_04.loggers;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;

@Retention(RetentionPolicy.RUNTIME)
@Target(METHOD)
public @interface LogTransformation {
    String value()  default "";
}

