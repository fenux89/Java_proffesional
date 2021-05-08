package homework10.task2;

public class Bird {
    static String name;
    final int age = 5;
    transient String color;

    public Bird() {
    }

    public Bird(String name, String color) {
        Bird.name = name;
        this.color = color;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Bird.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Bird{" + "name=" + name +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
