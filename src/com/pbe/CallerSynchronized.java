package com.pbe;

public class CallerSynchronized implements Runnable {

    String msg;
    Callme target;
    Thread t;

    // Constructor - takes a reference to an instance of the Callme class and a String
    // Then starts a new thread, that will call this objects run() method
    public CallerSynchronized(Callme targ, String s) {
        //System.out.println("Constructor called: " + s);
        target = targ;
        msg = s;
        t = new Thread(this);
    }

    // Calls the call() method on the target instance of Callme, passing msg String
    public void run() {
        synchronized (target) { // synchronized block
            target.call(msg);
        }
    }
}