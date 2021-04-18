package homework1.task1;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Animal cat = new Animal("Oriental", 7, 25, 5000);
        Animal dog = new Animal("Labrador", 30, 17, 4000);
        Animal bird = new Animal("King Penguin", 15, 8, 50000);
        Animal bird1 = new Animal("King Penguin", 15, 8, 50000);

        Animal[] c = {cat, dog, bird, bird1};

        Arrays.sort(c);   // ClassCastException w/o Comparable

        for (Animal tmp : c) {
            System.out.println(tmp);
        }
    }
}
