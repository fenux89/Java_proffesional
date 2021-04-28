package homework5.task3;

public class Main {
    public static void main(String[] args) {
        String text = "Эссе представляет собой прозаическое сочинение, имеющее свободную композицию и небольшой объем. Оно способно выразить индивидуальное впечатление и мысли по какому-либо конкретному поводу, предмету, действу или вопросу.";

        String firstHalf = text.substring(0, text.length() / 2);
        String secondtHalf = text.substring(text.length() / 2);

        System.out.println(text);
        System.out.println(firstHalf);
        System.out.println(secondtHalf);
        System.out.println("lengs first " + firstHalf.length());
        System.out.println("lengs second " + secondtHalf.length());
    }

}
