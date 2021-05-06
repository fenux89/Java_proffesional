package homework9.task3;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Car implements Externalizable {
    public int age;
    private static String color;
    int size;

    public Car(int age, String color, int size) {
        this.age = age;
        Car.color = color;
        this.size = size;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(age);
        out.writeObject(color);
        out.writeInt(size);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        age = in.readInt();
        color = (String) in.readObject();
        size = in.readInt();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static String getColor() {
        return color;
    }

    public static void setColor(String color) {
        Car.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Car{" +
                "age=" + age + "color= " + color + ", size=" + size +
                '}';
    }
}
