package homework15.task3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> ss = new HashMap<String, Integer>();
        MyHashMap<String, Integer> str = new MyHashMap<>();
        Set<String> st;


        str.put("01",1);
        str.put("01",01);
        str.put("02",2);
        str.put("03",3);
        str.put("04",4);
        str.put("05",5);
        str.put("06",6);
        str.put("07",7);


        System.out.println(str.get("05"));
        System.out.println(str.get("01"));
        System.out.println(str.containsKey("01"));
        System.out.println(str.containsValue(1));
        st=str.keySet();
        System.out.println(st.toString());
    }
}
