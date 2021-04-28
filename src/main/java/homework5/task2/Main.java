package homework5.task2;

public class Main {
    public static void main(String[] args) {
        String str = "Эссе представляет собой прозаическое сочинение, имеющее свободную композицию и небольшой объем. Оно способно выразить индивидуальное впечатление и мысли по какому-либо конкретному поводу, предмету, действу или вопросу. Эссе — это литературный текст, который может быть «окрашен» в различные «цвета», он не ставит целью показать однозначную, определенную трактовку предмета или событий.";
        System.out.println(str);
        System.out.println();
        String[] sentence = str.split("\\. ");
        String word;
        String[] words;
        String first;
        str = "";
        sentence[sentence.length - 1] = sentence[sentence.length - 1].replace(".", "");
        for (int i = 0; i < sentence.length; i++) {
            word = sentence[i];
            words = word.split(" ");
            first = words[words.length - 1];
            words[words.length - 1] = words[0];
            words[0] = first;
            for (int j = 0; j < words.length; j++) {
                str += words[j] + " ";
            }
            str += "\n";
        }

        for (String s : sentence) {
            System.out.println(s);
        }
        System.out.println();
        str = str.replace(" \n", ".\n");
        System.out.println(str);


    }
}
