package homework13.task2;

public class Potok extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(Thread.currentThread().getName() + "  i=" + i);
                sleep(1000);
               // wait(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Завершение " + Thread.currentThread().getName());


    }
}
