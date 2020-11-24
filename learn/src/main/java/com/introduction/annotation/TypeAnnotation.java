package main.java.com.introduction.annotation;

import java.lang.annotation.*;



/**
 * @Description
 * @Author 程杰
 * @Date 2020/11/16 11:11
 * @Version 1.0
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TypeAnnotation {
    String value() default "Is-TypeAnnotation";
}
