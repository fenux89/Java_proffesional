package homework13.task2;

public class Main {
    public static void main(String[] args) {
        Potok potok = new Potok();
        Potok potok1 = new Potok();
        Potok potok2 = new Potok();

        Thread myThread = Thread.currentThread();


        potok.start();
        potok1.start();
        potok2.start();

        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(Thread.currentThread().getName() + "  i=" + i);
                Thread.sleep(1000);
              //  myThread.wait(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //System.out.println(potok.isAlive());
//        if (!potok.isAlive()){
//            System.out.println("Завершение Thread - 0");
//        }
//        if (!potok1.isAlive()){
//            System.out.println("Завершение Thread - 1");
//        }
//        if (!potok2.isAlive()){
//            System.out.println("Завершение Thread - 2");
//        }
//        if (!myThread.isAlive()){
//            System.out.println("Завершение Thread - main");
//        }
        System.out.println("Завершение " + Thread.currentThread().getName());
    }
}
