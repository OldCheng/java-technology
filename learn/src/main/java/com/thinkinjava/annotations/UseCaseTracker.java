package main.java.com.thinkinjava.annotations;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author 程杰
 * @Date 2021/1/19 20:03
 * @Version 1.0
 */
public class UseCaseTracker {
    public static void trackUseCases(List<Integer> UseCases, Class<?> cl){
        for (Method m : cl.getDeclaredMethods()) {
            UseCase uc = m.getAnnotation(UseCase.class);
            if(uc != null){
                System.out.println(" found use case :" + uc.id() + "      " + uc.description());
                UseCases.remove(new Integer(uc.id()));
            }
        }

        for (Integer i : UseCases) {
            System.out.println(" warning : missing use case-  "+ i);
        }
    }

    public static void main(String[] args) {
        List<Integer> useCases = new ArrayList<>();
        Collections.addAll(useCases, 47,48,49,50);
        trackUseCases(useCases, PasswordUtils.class);
    }
}
