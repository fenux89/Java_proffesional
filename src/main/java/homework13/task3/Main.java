package homework13.task3;

public class Main {
    public static void main(String[] args) {
        Thread myThread = new Thread();

        PriorityRunner priorityRunner = new PriorityRunner();
        PriorityThread priorityThread = new PriorityThread();

        myThread.setPriority(Thread.MIN_PRIORITY);
        priorityRunner.setPriority(Thread.NORM_PRIORITY);
        priorityThread.setPriority(Thread.MAX_PRIORITY);

        priorityRunner.start();
        priorityThread.start();

        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + "  i= " + i);

        }

    }
}
