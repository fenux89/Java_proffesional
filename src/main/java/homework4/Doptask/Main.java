package homework4.Doptask;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File f = new File("C:\\Users\\fenux\\IdeaProjects\\Java_proffesional\\src\\main\\java\\homework4\\Doptask\\Doptask.txt");
        PrintWriter pw = new PrintWriter(new FileWriter(f, false));
        BufferedReader br = new BufferedReader(new FileReader(f));

        pw.write("Если кто-то с места сдвинется,\n" +
                "На него котенок кинется.\n" +
                "Если что-нибудь покатится,\n" +
                "За него котенок схватится.\n" +
                "Прыг-скок! Цап-царап!\n" +
                "Не уйдешь из наших лап!");
        pw.flush();
        pw.close();

        try {
            String temp;
            while ((temp = br.readLine()) != null) {
                System.out.println(temp);
            }
            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
