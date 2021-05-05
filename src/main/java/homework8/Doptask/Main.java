package homework8.Doptask;


import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        try {
            Main m = new Main();
            Class<?> cl = m.getClass();
            Method met = cl.getDeclaredMethod("mathSum", int.class, int.class);
            MathAnno ma = met.getAnnotation(MathAnno.class);
            MathAnno2[] ma2 =ma.value();

            m.mathSum(ma2[0].num1(), ma2[1].num2() );
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @MathAnno2(num1 = 5)
    @MathAnno2(num2 = 6)
    public void mathSum(int num1, int num2) {
        System.out.println("Сумма = " + (num1 + num2));
    }
}
