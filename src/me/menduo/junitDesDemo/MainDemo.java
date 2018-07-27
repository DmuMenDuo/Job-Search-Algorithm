package me.menduo.junitDesDemo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainDemo {


    public static void main(String[] args) {
        int total = 0;
        int pass = 0;
        try {
            Class test = Class.forName("me.menduo.junitDesDemo.Demo");
            for (Method m : test.getDeclaredMethods()) {
                if (m.isAnnotationPresent(Test.class)) {
                    total++;
                    try {
                        try {
                            m.invoke(test.newInstance(), null);
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        }
                        pass++;
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        ExceptionTest[] exp = m.getAnnotationsByType(ExceptionTest.class);
                        for (ExceptionTest ep : exp) {
                            if (ep.value().isInstance(e.getCause())) {
                                pass++;
                            } else {
                                System.out.println(".........." + e.getCause());
                                e.printStackTrace();
                            }
                        }
                    }

                }
            }
            System.out.printf("Pass:%d,Failed:%d%n", pass, total - pass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
