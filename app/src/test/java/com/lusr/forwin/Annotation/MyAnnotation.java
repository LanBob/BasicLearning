package com.lusr.forwin.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解,设置作用时期和目标
 */
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.PARAMETER})
public @interface MyAnnotation {
    String[] value();
}
