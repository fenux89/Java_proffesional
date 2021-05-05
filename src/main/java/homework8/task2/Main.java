package homework8.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.*;
import java.lang.reflect.Method;

/**
 * @author Aleksey
 * @version 1.0
 * @since 05.05.2021
 */

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите знак операции");

        try {
            Main m = new Main();
            Class<?> cl = m.getClass();
            Method met = cl.getDeclaredMethod("Calculator", int.class, int.class, String.class);
            Calc calc = met.getAnnotation(Calc.class);
            m.Calculator(calc.a(), calc.b(), in.readLine());


        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     * Calculator, performs arithmetic operations.
     *
     * @param a   number a
     * @param b   number b
     * @param str symbol (+ - * / )
     */
    @Calc(a = 9, b = 4)
    public void Calculator(int a, int b, String str) {

        switch (str) {
            case "+": {
                System.out.println("Сумма = " + (a + b));
                break;
            }
            case "-": {
                System.out.println("Разность = " + (a - b));
                break;
            }
            case "*": {
                System.out.println("Умножение = " + (a * b));
                break;
            }
            case "/": {
                try {

                    System.out.println("Деление = " + (a / b));
                } catch (ArithmeticException e) {
                    e.printStackTrace();
                    System.out.println("Деление на ноль не возможно");
                }
                break;

            }
            default: {
                System.out.println("Введен не правильный знак");
                break;
            }
        }

    }

}
