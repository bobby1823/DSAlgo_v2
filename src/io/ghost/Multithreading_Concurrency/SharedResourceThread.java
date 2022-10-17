package io.ghost.Multithreading_Concurrency;

public class SharedResourceThread {


    public static void main (String[] args) throws InterruptedException {
        Runnable myRunnable = new Runnable() {
            int count = 0;
            @Override
            public void run () {
                System.out.println("Inside " +Thread.currentThread().getName()+ " Thread");
                for (int i = 0; i < 5; i++) {
                    count++;
                    System.out.println("Running...");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Processing Completed for Thread: " +Thread.currentThread().getName());
            };
        };

        Thread thread1 = new Thread(myRunnable, "Thread 1");
        //Thread thread2 = new Thread(myRunnable, "Thread 2");
        thread1.setDaemon(true);
        System.out.println("Main Thread Running.");
        thread1.start();

        Thread.sleep(1000);
        thread1.join();
        System.out.println("Main Thread Ended.");

    }
}
