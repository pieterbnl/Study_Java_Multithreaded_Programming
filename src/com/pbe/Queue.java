package com.pbe;

public class Queue {
    int x;

    synchronized int get() {
        System.out.println("Got: " + x);
        return x;
    }

    synchronized void put(int x) {
        this.x = x;
        System.out.println("Put: " + x);
    }
}