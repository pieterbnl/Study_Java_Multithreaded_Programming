package com.pbe;

public class Queue2 {
    int x;
    boolean valueSet = false;

    synchronized int get() {
        while (!valueSet)
            try {
                wait(); // this causes execution to suspend until Producer notifies some data is ready, after which execution in get() resumes
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
            System.out.println("Got: " + x);
            valueSet = false;
            notify(); // the data has been obtained by now, call notify() to tell producer it's okay to put more data in the queue
            return x;
    }

    synchronized void put(int x) {
        while(valueSet)
            try {
                wait(); // suspends execution until Consumer has removed the item from the queue.
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
            this.x = x; // Execution resumed, now putting the next item of data in the queue
            valueSet = true;
            System.out.println("Put: " + x);
            notify(); // calling notify() to tell Consumer the next item of data can be removed
    }
}