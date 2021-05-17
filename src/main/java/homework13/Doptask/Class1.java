package homework13.Doptask;

public class Class1 {
    int var;
    boolean bool;

    synchronized void class2() {

        if (!bool) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println(Thread.currentThread().getName() + " " + ++var);
        bool = false;

        notify();
    }

    synchronized void class3() {

        if (bool) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println(Thread.currentThread().getName() + " " + ++var);
        bool = true;
        notify();
    }
}
