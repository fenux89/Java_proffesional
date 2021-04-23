package homework3.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> mp = new HashMap<>();
        String str = "";
        int s = 0;
        mp.put("Москва", "Ивановы");
        mp.put("Киев", " Петровы");
        mp.put("Лондон", "Абрамовичи");

        while (!str.equals("end")) {
            System.out.println("Введите город, для выхода введите end");
            str = reader.readLine();
            for (Map.Entry<String, String> map : mp.entrySet()) {
                if (map.getKey().equals(str)) {
                    System.out.println(map.getKey() + " - " + map.getValue());
                    s++;
                }
            }
            if ((s == 0) && (!str.equals("end"))) {
                System.out.println("Нет семьи в таком городе.");
            }
        }
    }
}
