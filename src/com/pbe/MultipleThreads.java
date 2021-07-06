package com.pbe;

public class MultipleThreads implements Runnable {

    Thread t; // declaration of thread

    MultipleThreads(String threadname) {
        t = new Thread(this, threadname); // instantiation and initialization of thread
        System.out.println("New thread: " + t);
    }

    // Entry point for thread
    public void run() {
        try {
            for (int x = 5; x > 0; x--) {
                System.out.println(t.getName() + ": " + x);
                Thread.sleep(250);
            }
        } catch (InterruptedException e) {
            System.out.println(t.getName() + "Interrupted");
        }
        System.out.println(t.getName() + " exiting");
    }
}