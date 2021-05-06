package homework9.task2;

import java.io.Serializable;

public class Animal implements Serializable {
    int age;
    private String name;
    int rost;

    Animal() {

    }

    Animal(int age, String name, int rost) {
        this.age = age;
        this.name = name;
        this.rost = rost;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRost() {
        return rost;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", rost=" + rost +
                '}';
    }

    public void setRost(int rost) {
        this.rost = rost;
    }
}
