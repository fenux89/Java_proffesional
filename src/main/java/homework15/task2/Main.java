package homework15.task2;

import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> str = new MyLinkedList<>();
        MyLinkedList<String> str1 = new MyLinkedList<>();

        str.addFirst("01");
        int as = 3;
        str.add("1");
        str.add("2");
        str.add("3");

        str.add(1, "33");
        try {
            str1 = (MyLinkedList<String>) str.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        str1.addLast("99");

        System.out.println(str.contains("33"));
        System.out.println(str.get(2));
        System.out.println();
        System.out.println(str.getFirst());
        System.out.println(str.getLast());
        System.out.println();
        System.out.println(str.indexOf("38"));
        System.out.println();
        System.out.println();
        System.out.println(str.lastIndexOf("33"));
        System.out.println("4949465465464333333333333");

        MyLinkedList.MyIterator tt = str.returnIterator(0);
        while(tt.hasNext()){
            System.out.println(tt.next());
        }

   }
}
