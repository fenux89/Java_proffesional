package homework14.Doptask;

public class Main {
    public static void main(String[] args) {
        new WorkerThread().start();

        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {

        }

        System.out.println("Main закончил работу");
    }

}

class WorkerThread extends Thread {

    public WorkerThread() {

        setDaemon(true);
        setName("Deamon");
    }

    @Override
    public void run() {
        int count = 0;

        while (true) {
            System.out.println(Thread.currentThread().getName() + " " + count++);

            try {
                sleep(1000);
            } catch (InterruptedException e) {

            }
        }
    }
}