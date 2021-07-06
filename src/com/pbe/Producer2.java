package com.pbe;

public class Producer2 implements Runnable {
    Queue2 q;
    Thread t;

    Producer2(Queue2 q) {
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