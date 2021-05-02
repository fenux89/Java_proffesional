package homework7.Doptask;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Cat {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        String s0 = (char) 27 + "[31m";
        String s = (char) 27 + "[33m";
        String s1 = (char) 27 + "[39m";
        String s2 = (char) 27 + "[34m";
        Class<?> c = Animal.class;
        Object animal = c.newInstance();
        Field[] fields = c.getDeclaredFields();


        System.out.println(s0 + "Fileds" + s1);
        for (Field field : fields) {
            Class<?> fieldType = field.getType();
            int mods = field.getModifiers();
            System.out.println(getModifierString(mods));

            System.out.println(s2 + "\tType: " + s1 + fieldType.getName());
            System.out.println(s2 + "\tName: " + s1 + field.getName());
            Field fiel = c.getDeclaredField(field.getName());
            fiel.setAccessible(true);

            System.out.println("\t" + field.getName() + " = " + fiel.get(animal));
            if (!(fieldType.getName().equals("java.lang.String") | fieldType.getName().equals("boolean") | fieldType.getName().equals("java.lang.Boolean") | fieldType.getName().equals("java.lang.Double"))) {
                fiel.set(animal, 200);
                System.out.println("\t" + field.getName() + " = " + fiel.get(animal));
            } else if (fieldType.getName().equals("java.lang.String")) {
                fiel.set(animal, "Max");
                System.out.println("\t" + field.getName() + " = " + fiel.get(animal));
            } else if (fieldType.getName().equals("boolean") | fieldType.getName().equals("java.lang.Boolean")) {
                fiel.set(animal, true);
                System.out.println("\t" + field.getName() + " = " + fiel.get(animal));
            } else if (fieldType.getName().equals("java.lang.Double")) {
                fiel.set(animal, 55.0);
                System.out.println("\t" + field.getName() + " = " + fiel.get(animal));
            }
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
