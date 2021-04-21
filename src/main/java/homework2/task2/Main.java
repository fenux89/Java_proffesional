package homework2.task2;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> q = new PriorityQueue<>(10, new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i1 - i2;
            }
        });
        for (int i = 0; i < 10; i++) {
            q.offer((int)(Math.random()*100));
        }

        System.out.println(q);
        for (int i = 0; i < 10; i++) {
            System.out.printf(q.poll() + " \n");
            System.out.println(q);
        }
    }
}
