package homework5.Doptask;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        boolean sorted = false;
        String str = "Что же можно понимать под открытостью текста. Очевидно, все названные оттенки значений в совокупности создают образ открытого текста. Открытость как неизменный признак любой живой системы представляет собой возможность взаимодействия с другими живыми системами (текстами) и формирование вследствие этого новых литературных традиций. Язык как некий отвлеченный, абстрактный конгломерат, не нуждается в том, чтобы быть построенным в некую систему. Он существует независимо от нашего желания и реализуется в тексте (речи)." +
                "Свободное «перетекание» компонентов языкового материала из абстрактного языка в речь (текст) и наоборот – это и есть признак открытости текста.";
        String[] sentence = str.split("\\. ");
        int[] count = new int[sentence.length];
        int temp;
        String tem;

        for (int i = 0; i < sentence.length - 1; i++) {
            sentence[i] = sentence[i] + ".";
        }

        for (int i = 0; i < sentence.length; i++) {

            for (int j = 0; j < sentence[i].length(); j++) {
                if (sentence[i].charAt(j) == ' ') {
                    count[i]++;
                }
            }

        }
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < count.length - 1; i++) {
                if (count[i] > count[i + 1]) {
                    temp = count[i];
                    tem = sentence[i];
                    count[i] = count[i + 1];
                    sentence[i] = sentence[i + 1];
                    count[i + 1] = temp;
                    sentence[i + 1] = tem;
                    sorted = false;
                }
            }
        }

        for (int i : count) {
            System.out.println(i);

        }

        for (String s : sentence) {
            System.out.println(s);
        }
    }
}
