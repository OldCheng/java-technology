package main.java.com.introduction.annotation;

import java.lang.annotation.*;

/**
 * @Description
 * @Author 程杰
 * @Date 2020/11/16 11:09
 * @Version 1.0
 */

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodAnnotation {

    String name() default "MethodAnnotation";
    String url() default "https://www.cnblogs.com";

}
