package com.pbe;

public class Consumer implements Runnable {
    Queue q;
    Thread t;

    Consumer(Queue q) {
        this.q = q;
        t = new Thread(this, "Consumer");
    }

    public void run() {
        while(true) {
            q.get();
        }
    }
}