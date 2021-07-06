package com.pbe;

public class Deadlock implements Runnable {

    ClassA a = new ClassA();
    ClassB b = new ClassB();
    Thread t;

    Deadlock() {
        System.out.println("Inside Deadlock.Deadlock()");
        Thread.currentThread().setName("MainThread");
        t = new Thread(this, "RacingThread");
    }

    void deadLockStart() {
        System.out.println("Inside Deadlock.deadLockStart()");
        t.start();
        a.foo(b); // gets a lock on this thread
        System.out.println("Back in main thread");
    }

    public void run() {
        System.out.println("Inside Deadlock.run()");
        b.bar(a);
        System.out.println("Back in other thread"); // this line will never be reached
    }
}