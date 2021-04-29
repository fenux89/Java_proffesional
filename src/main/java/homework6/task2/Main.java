package homework6.task2;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        File f = new File("C:\\Users\\fenux\\IdeaProjects\\Java_proffesional\\src\\main\\java\\homework6\\task2\\task2.txt");
        PrintWriter pw = new PrintWriter(new FileWriter(f, false));
        PrintWriter pw1 = new PrintWriter(new FileWriter(f, false));
        BufferedReader br = new BufferedReader(new FileReader(f));
        BufferedReader br1 = new BufferedReader(new FileReader(f));

        Pattern pattern = Pattern.compile("(?<!\\S)(?:без|между|под|в|на|по|вокруг|о|про|до|об|с|для|около|из-за|за|от|из-под|к|перед)(?!\\S)", Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);

        pw.write("Не пытаясь дать им сколько-нибудь полную классификацию, различим в первую очередь высказывания, созданные автором произведения и приписанные им «вторичным» речевым субъектам (включая повествователя), с одной стороны, и высказывания, не включенные в кругозор персонажей и повествователя (полностью или частично), а иногда и не созданные автором – с другой. Первые – это прямая речь персонажей, внешняя и внутренняя; собственно повествование, описание, характеристика; вставные рассказы и письма, а также «произведения» героев (например, стихи). Вторые – эпиграфы, названия частей или глав, а также заголовок произведения в целом; вставные тексты, принадлежащие другим авторам, как, например, «Жил на свете рыцарь бедный…» в «Идиоте» или «Анчар» в тургеневском «Затишье». Различие между ними связано с границами кругозора персонажей (так, например, вставной евангельский текст в чеховском «Студенте» отчетливо выявляет границы вúдения героя). Формы первого типа объединяются в более сложные единства эпизода или сцены, которые соотнесены со структурой изображенного пространства-времени и сюжета. Наконец, в такие «образования» более высокого уровня, как «предыстория» или пролог, экспозиция, основная история, эпилог или послесловие, а также «отступление», могут входить не только любые композиционно-речевые формы, но и различные сцены и эпизоды.");
        pw.flush();
        pw.close();

        String temp = br.readLine();
        br.close();

        Matcher matcher = pattern.matcher(temp);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            System.out.println("Найдено совпадение " + temp.substring(start, end) + " с " + start + " по " + (end - 1) + " позицию");
        }

        pw1.write(matcher.replaceAll("Java"));
        pw1.flush();
        pw1.close();

        try {
            String temp1;
            while ((temp1 = br1.readLine()) != null) {
                System.out.println(temp1);
            }
            br1.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
