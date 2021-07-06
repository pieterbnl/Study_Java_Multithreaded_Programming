package com.pbe;

public class Consumer2 implements Runnable {
    Queue2 q;
    Thread t;

    Consumer2(Queue2 q) {
        this.q = q;
        t = new Thread(this, "Consumer");
    }

    public void run() {
        while(true) {
            q.get();
        }
    }
}
