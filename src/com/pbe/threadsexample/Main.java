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
            }
        });
        myRunnableThread.start();

        // Note that this might be printed out before the just created anonymous class thread
        System.out.println(ANSI_PURPLE + "This is the main thread, again");

        // Another way to created threads: implementing the runnable interface.
        // It will require a run() method to be added to the class, which is then used to start the thread.
    }
}