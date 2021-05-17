package homework13.Doptask;

public class Main {
    public static void main(String[] args) {
        Class1 cl = new Class1();
        Class2 cl2 = new Class2(cl, 6);
        Class3 cl3 = new Class3(cl, 6);

        cl2.start();
        cl3.start();
    }
}
