package homework14.task2;

public class Main {

    public static void main(String args[]) {
        ThreadDemo1 t1 = new ThreadDemo1();
        ThreadDemo2 t2 = new ThreadDemo2();
        t1.start();
        t2.start();
    }

    private static class ThreadDemo1 extends Thread {
        public void run() {

            synchronized (ThreadDemo1.class) {
                System.out.println("Поток 1: Удерживает блокировку 1...");

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Поток 1: Ожидает блокировку 2...");

                synchronized (ThreadDemo2.class) {
                    System.out.println("Поток 1: Удерживает блокировку 1 и 2...");
                }
            }

        }
    }

    private static class ThreadDemo2 extends Thread {

        public void run() {
            synchronized (ThreadDemo2.class) {
                System.out.println("Поток 2: Удерживает блокировку 2...");

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Поток 2: Ожидает блокировку 1...");

                synchronized (ThreadDemo1.class) {
                    System.out.println("Поток 2: Удерживает блокировку 1 и 2...");
                }
            }
        }
    }
}
