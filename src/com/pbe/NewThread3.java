package com.pbe;

public class NewThread3 implements Runnable {

    String threadname;
    Thread t;
    boolean suspendFlag;

    public NewThread3(String threadname) {
        this.threadname = threadname;
        t = new Thread(this, threadname);
        System.out.println("New thread: " + t);
        suspendFlag = false;
    }

    public void run() {
        try {
            for (int x = 5; x > 0; x--) {
                System.out.println(threadname + ": " + x);
                Thread.sleep(200);
                synchronized (this) {
                    while (suspendFlag) {
                        wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println(threadname + " interrupted");
        }
        System.out.println(threadname + " exiting");
    }

    synchronized void mysuspend() {
        suspendFlag = true;
    }

    synchronized void myresume() {
        suspendFlag = false;
        notify();
    }
}