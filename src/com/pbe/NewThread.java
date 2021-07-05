package com.pbe;

public class NewThread implements Runnable{

    Thread t;

    // Constructor, creating -in the context of this example- a (second) thread
    NewThread() {
        t = new Thread(this, "Second thread"); // passing 'this' indicates that the new thread needs to call the run()) method on this object
        System.out.println("Child thread: " + t);
    }

    // Second thread entry point
    public void run() { // inside main(), start() is called, which in turn starts the thread of execution beginning at run()
        System.out.println("run() is called");
        try {
            for (int x = 5; x > 0; x--) {
                System.out.println("Child thread: " + x);
                Thread.sleep(250);
            }
        } catch (InterruptedException e) {
            System.out.println("Child interrupted");
        }
        System.out.println("Exiting child thread");
    }
}