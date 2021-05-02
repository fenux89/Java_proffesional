package homework7.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.*;


public class Main {
    public static void main(String[] args) throws IOException {
        String s0 = (char) 27 + "[31m";
        String s = (char) 27 + "[33m";
        String s1 = (char) 27 + "[39m";
        String s2 = (char) 27 + "[34m";
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите путь и названине класса пример \"java.io.BufferedReader\" ");
        try {

            Class<?> c = Class.forName(in.readLine());
            System.out.println(c);
            Field[] fields = c.getDeclaredFields();
            Constructor[] constructors = c.getDeclaredConstructors();
            Method[] methods = c.getDeclaredMethods();

            System.out.println(s0 + "Fileds" + s1);
            for (Field field : fields) {
                Class<?> fieldType = field.getType();
                int mods = field.getModifiers();
                System.out.println(getModifierString(mods));

                System.out.println(s2 + "\tType: " + s1 + fieldType.getName());
                System.out.println(s2 + "\tName: " + s1 + field.getName());
            }

            System.out.println();
            System.out.println(s0 + "Constructors" + s1);
            int i = 0;

            for (Constructor<?> ctr : constructors) {

                System.out.print(s + "Constructor " + (++i) + ": ");
                Class<?>[] paramTypes = ctr.getParameterTypes();
                int mods = ctr.getModifiers();

                System.out.print(s2 + getModifierString(mods));
                System.out.print(s1 + " (");
                for (Class<?> paramType : paramTypes) {
                    System.out.print(s1 + paramType.getName() + " ");
                }
                System.out.println(")");
            }

            System.out.println();
            System.out.println(s0 + "Methods" + s1);

            for (Method method : methods) {
                System.out.println(s + "\tName: " + s2 + method.getName());
                Class<?>[] paramTypes = method.getParameterTypes();

                int mods = method.getModifiers();
                System.out.println(s + "\tReturn type: " + s1 + getModifierString(mods) + method.getReturnType().getName() + " ");
                System.out.print(s + "\tParam types:" + s1);

                for (Class<?> paramType : paramTypes) {
                    System.out.print(" " + paramType.getName());
                }
                System.out.println();
                System.out.println();
            }

        } catch (Exception e) {
            System.out.println("Неизвестный класс");
        }

    }


    static String getModifierString(int mods) {
        String str = "";
        if (Modifier.isPublic(mods)) {
            str += "public ";
        }
        if (Modifier.isPrivate(mods)) {
            str += "privat ";
        }
        if (Modifier.isProtected(mods)) {
            str += "protected ";
        }
        if (Modifier.isStatic(mods)) {
            str += "static ";
        }
        if (Modifier.isFinal(mods)) {
            str += "final ";
        }
        if (Modifier.isSynchronized(mods)) {
            str += "synchronized ";
        }
        if (Modifier.isVolatile(mods)) {
            str += "Volatile ";
        }
        if (Modifier.isAbstract(mods)) {
            str += "abstract ";
        }
        return str += " ";
    }

}
