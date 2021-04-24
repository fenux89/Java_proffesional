package homework4.task2;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        //File f1 = new File("C:\\Users\\fenux\\IdeaProjects\\Java_proffesional\\src\\main\\java\\homework4\\task2\\task2.txt");

        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\fenux\\IdeaProjects\\Java_proffesional\\src\\main\\java\\homework4\\task2\\task2.txt"), "Cp866"));) {

            bw.write("Проверка записи.");
            bw.flush();
            //  bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\fenux\\IdeaProjects\\Java_proffesional\\src\\main\\java\\homework4\\task2\\task2.txt"),
                "Cp866"));) {
            int c;
            while ((c = br.read()) != -1) {
                System.out.print((char) c);
            }
            // br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}