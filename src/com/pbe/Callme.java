package com.pbe;

// Prints a passed message inside square brackets
public class Callme {
    // Not synchronized solution
    void call(String msg) {
        System.out.print("[" + msg);
        try {
            Thread.sleep(1000); // will make the call() method allowing execution to switch to another thread
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println("]");
    }

//    // Synchronized solution
//    // Any time that a method or group of methods is used that manipulate the internal state of an object in a multithreaded situation,
//    // synchronized should be used.
//    // Synchronized will guard the state from race conditions: once a thread enters a synchronized method on an instance,
//    // no other thread can enter any other synchronized method on the same instance.
//    // Non-synchronized methods on the instance will remain callable.
//    synchronized void call(String msg) { // prevents other threads from entering call() while another thread is using it
//        System.out.print("[" + msg);
//        try {
//            Thread.sleep(1000); // will make the call() method allowing execution to switch to another thread
//        } catch (InterruptedException e) {
//            System.out.println("Interrupted");
//        }
//        System.out.println("]");
//    }
}