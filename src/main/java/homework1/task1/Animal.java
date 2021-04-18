package homework1.task1;

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

    // Сортируем по скорости/цене
    public int compareTo(Object obj) {              //    public int compareTo(Animal o) {
        int tmp = this.speed - ((Animal) obj).speed; //    int tmp = this.speed - o.speed;

        if (tmp == 0) {
            tmp = this.price - ((Animal) obj).price;
        } else return tmp;
        if (tmp == 0) {

            tmp = this.breed.compareTo(((Animal) obj).breed);
        } else return tmp;
        if (tmp == 0) {
            tmp = this.weight - ((Animal) obj).weight;
        }
        return tmp;
    }
}


// Сравнение 2-х строковых значений
// return this.breed.compareTo(((Animal)o).breed);
