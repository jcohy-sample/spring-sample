package com.jcohy.sample.spring.framework.mvcframework.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by jiac on 2019/3/21. ClassName : com.jcohy.study.mvc.mvcframework.annotation
 * Description :
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface JcohyAutowired {

	String value() default "";

}
