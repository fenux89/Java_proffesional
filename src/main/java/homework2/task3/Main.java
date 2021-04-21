package homework2.task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Integer> list = getIntegerList();
        System.out.println(getMinimum(list));
    }

    public static int getMinimum(List<Integer> list) {

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < min)
                min = list.get(i);
        }
        return min;

    }

    public static List<Integer> getIntegerList() throws IOException {

        List<Integer> list = new LinkedList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = 0;
        try {
            N = Integer.parseInt(reader.readLine());
        } catch (Exception e) {
            System.out.println("Вы ввели не число, попробуйте снова.");
            N = Integer.parseInt(reader.readLine());
        }
        for (int i = 0; i < N; i++) {
            try {
                list.add(Integer.parseInt(reader.readLine()));
            } catch (Exception e) {
                System.out.println("Вы ввели не число, попробуйте снова.");
                list.add(Integer.parseInt(reader.readLine()));
            }
        }
        return list;
    }
}
