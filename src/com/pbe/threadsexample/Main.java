package com.pbe.threadsexample;

import static com.pbe.threadsexample.ThreadColor.*;

public class Main {

    // Note that output may vary run over run, scheduling of threads is impacted by the operating system.
    // Priorities can bet set, but even then it can't be guaranteed that they run in a particular order.
    public static void main(String[] args) {

        // Main().. is the main thread
        System.out.println(ANSI_PURPLE + "This is the main thread");

        // Creating and starting another thread
        Thread anotherThread = new AnotherThread();
        anotherThread.setName("//Another Thread//");
        anotherThread.start();

        // Creating and starting yet another thread, but as an anonymous class
        new Thread() {
            public void run() {
                System.out.println(ANSI_GREEN + "This is the anonymous class thread");
            }
        }.start();

        // Creating and starting another thread, using runnable (MyRunnable class implements Runnable)
        // Note: runnable is generally used most of the times, as it's more convenient/flexible
        Thread myRunnableThread = new Thread(new MyRunnable() {
            // With runnable, have to implement run() method, but don't call it directly.
            // The JVM will do that via start().
            @Override
            public void run() {
                System.out.println(ANSI_RED + "Hello from the anonymous class's implementation of run()");
                try {
                    // Calling join method of the thread instance that we want to join
                    // When invoking join() on a thread, the calling thread goes into a waiting state.
                    // It remains in a waiting state until the referenced thread terminates.
                    // Join can throw the InterruptedException, because it will terminate prematurely when it gets interrupted by another thread.
                    anotherThread.join(2000); // the 2000 is a 2 sec time-out, making join wait for max 2 sec

                    // The following will only show after the joined thread has terminated,
                    // which takes approx. 3 sec as it has been put to sleep upon initiation.
                    System.out.println(ANSI_RED + "Another Thread terminated, or timed out, so I'm running again");
                } catch (InterruptedException e) {
                    System.out.println(ANSI_RED + "Couldn't wait after all; was interrupted");
                }

            }
        });
        myRunnableThread.start();
        // anotherThread.interrupt();

        // When joining a thread with the thread that's fetching the data (a second thread):
        // the first thread will wait for the second thread to terminate, before it continues

        // Note that this might be printed out before the just created anonymous class thread
        System.out.println(ANSI_PURPLE + "This is the main thread, again");

        // Another way to created threads: implementing the runnable interface.
        // It will require a run() method to be added to the class, which is then used to start the thread.
    }
}