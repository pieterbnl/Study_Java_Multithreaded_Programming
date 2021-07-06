package com.pbe;

public class NewThread2 extends Thread {

    // Constructor
    public NewThread2() {
        super("Second thread"); // this invokes the thread constructor: public Thread(String threadName)
        System.out.println("Constructor is called");
        System.out.println("Child thread: " + this); // printing the thread specifics: thread name, priority, thread group
    }

    // Entry point for second thread, will be initiated via start(), which is called when the class constructor is run
    public void run() {
        System.out.println("run is called");
        try {
            for(int x = 5; x > 0; x--) {
                System.out.println("Child thread: " + x);
                Thread.sleep(250);
            }
        } catch (InterruptedException e) {
            System.out.println("Child interrupted");
        }
        System.out.println("Exiting child thread \n");
    }
}