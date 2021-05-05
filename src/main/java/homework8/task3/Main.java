package homework8.task3;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        try {

            First first = new First();
            Class<?> cl = first.getClass();
            Annotation[] annotations = cl.getAnnotations();

            System.out.println(cl.getName() + "\nAnnotations:");
            for (Annotation annotation : annotations) {
                System.out.println("\t" + annotation);
            }
            Method[] classMethods = cl.getMethods();
            System.out.println("Method annotations:");

            for (Method method : classMethods) {
                Annotation[] methodAnnotations = method.getAnnotations();
                if (methodAnnotations.length > 0) {
                    System.out.println("\t" + method.getName() + "():");
                }
                for (Annotation annotation : methodAnnotations) {
                    System.out.println("\t" + annotation);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
