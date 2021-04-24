package homework4.task3;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\fenux\\IdeaProjects\\Java_proffesional\\src\\main\\java\\homework4\\task3\\task3.txt"), "Cp866"));) {
            for (int i = 0; i < 20; i++) {
                bw.write((int) (Math.random() * 100));
            }
            bw.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\fenux\\IdeaProjects\\Java_proffesional\\src\\main\\java\\homework4\\task3\\task3.txt"),
                "Cp866"));) {
            int i = 0, c;
            br.mark(21);

            while ((c = br.read()) != -1) {
                System.out.print(c + " ");
                i++;
            }
            System.out.println();

            int[] s = new int[i];
            br.reset();
            i = 0;
            while ((c = br.read()) != -1) {
                s[i] = c;
                i++;
            }
            Arrays.sort(s);
            System.out.println(Arrays.toString(s));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
