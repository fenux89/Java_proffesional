package homework10.task3;

public class Eagle extends Animal {


    public Eagle() {
    }

    public Eagle(String name, int age, String color) {
        super(name, age, color);
    }

    public static Eagle cloneEagle(Eagle eagle) {
        return new Eagle(eagle.name, eagle.age, eagle.color);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
       return super.clone();
    }

    @Override
    public String toString() {
        return "Eagle{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
