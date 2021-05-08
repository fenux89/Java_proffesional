package homework10.task2;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) {
        Bird bird = new Bird("Max", "Black");
        System.out.println("Original cow = " + bird);

        Bird clonBird = reflectionCloning(bird);
        bird.setColor("Blue");

        System.out.println();
        System.out.println(bird);
        System.out.println(clonBird);

    }

    private static Bird reflectionCloning(Bird bird) {

        Bird clonBird = new Bird();

        try {
            Field[] fields = Bird.class.getDeclaredFields();
            for (Field f : fields) {
                Field field = Bird.class.getDeclaredField(f.getName());
                field.setAccessible(true);
                field.set(clonBird, field.get(bird));
            }
            return clonBird;

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return clonBird;
    }
}
