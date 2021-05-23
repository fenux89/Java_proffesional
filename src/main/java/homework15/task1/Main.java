package homework15.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<Integer> ls = new ArrayList<>();
        Random random = new Random();
        int ss;
        ls = random
                .ints(10, 0, 10)
                .boxed()
                .collect(Collectors.toList());

        System.out.println(ls);

        ls = ls.stream()
                .map(x -> (int) Math.pow(x, 2))
                .collect(Collectors.toList());

        System.out.println(ls);

        ss=ls.stream()
                .reduce(Integer::sum)
                .get();

        System.out.println(ss);


    }
}
