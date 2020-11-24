package main.java.com.introduction.annotation;

import java.lang.annotation.*;

/**
 * @Description
 * @Author 程杰
 * @Date 2020/11/16 11:07
 * @Version 1.0
 */

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FiledAnnotation {
    String value() default "GetFiledAnnotation";
}
