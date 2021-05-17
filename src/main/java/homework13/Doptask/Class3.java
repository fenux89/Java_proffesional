package homework13.Doptask;

public class Class3 extends Thread {
    Class1 cl;
    int count;

    Class3(Class1 cl, int count) {
        this.cl = cl;
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 1; i < count + 1; i++) {
            cl.class3();
        }
    }
}
