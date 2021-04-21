package homework1.task1;

import java.util.Comparator;

public class Animal implements Comparable { // <Animal>{
    String breed;
    int weight;
    int speed;
    int price;

    Animal(String breed, int weight, int speed, int price) {
        this.breed = breed;
        this.weight = weight;
        this.speed = speed;
        this.price = price;
    }

    public String toString() {
        return this.breed + " " + this.weight + " " + this.speed + " " + this.price;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // Сортируем по скорости/цене
   @Override
    public int compareTo(Object obj) {              //    public int compareTo(Animal o) {
//        int tmp = this.speed - ((Animal) obj).speed; //    int tmp = this.speed - o.speed;
//
//        if (tmp == 0) {
//            tmp = this.price - ((Animal) obj).price;
//        } else return tmp;
//        if (tmp == 0) {
//
//            tmp = this.breed.compareTo(((Animal) obj).breed);
//        } else return tmp;
//        if (tmp == 0) {
//            tmp = this.weight - ((Animal) obj).weight;
//        }
//        return tmp;

        return Comparator.comparing(Animal::getSpeed).thenComparing(Animal::getPrice).thenComparing(Animal::getBreed).thenComparing(Animal::getWeight).compare(this, (Animal) obj);

    }
}


// Сравнение 2-х строковых значений
// return this.breed.compareTo(((Animal)o).breed);
