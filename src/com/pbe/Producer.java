package com.pbe;

public class Producer implements Runnable {
    Queue q;
    Thread t;

    Producer(Queue q) {
        this.q = q;
        t = new Thread(this, "Producer");
    }

    public void run() {
        int x = 0;

        while(true) {
            q.put(x++);
        }
    }
}