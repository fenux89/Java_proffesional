package homework6.Doptask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        boolean start = true;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Pattern pat1 = Pattern.compile("[a-z]+", Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        Pattern pat2 = Pattern.compile("(\\d*?\\W*?\\d*?\\W*?\\d*?\\W*?)");
        String login, pass;
        Matcher m2;

        while (start) {
            System.out.println("Введите логин");
            login = in.readLine();
            Matcher m1 = pat1.matcher(login);

            if (m1.matches()) {
                System.out.println("Введите пароль");
                pass = in.readLine();
                m2 = pat2.matcher(pass);
                if (m2.matches()) {
                    System.out.println("Логин " + login + " пароль " + pass);
                    start = false;
                } else {
                    System.out.println("Введен не правильный пароль");
                }
            } else {
                System.out.println("Ввели не верный логин");
            }
        }
    }
}
