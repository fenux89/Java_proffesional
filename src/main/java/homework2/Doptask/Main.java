package homework2.Doptask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<String> list = new HashSet<>();
        String str = "";
        System.out.println("Введите строки");
        while (!str.equals("end")) {
            str = reader.readLine();
            if (!str.equals("end")) {
                list.add(str);
            }
        }
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("Размер " + list.size());

    }
}
