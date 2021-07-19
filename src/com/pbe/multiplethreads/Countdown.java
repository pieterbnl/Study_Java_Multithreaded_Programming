package com.pbe.multiplethreads;

import com.pbe.threadsexample.ThreadColor;

public class Countdown {

    private int i; // instance variable - which is stored in the thread's heap.. which is shared between threads

    //public synchronized void doCountdown() { // possible to synchronize the whole method, but that would be overkill as actually only the for loop needs to be synchronized
    public void doCountdown() {
        String color;

        // Set a color, depending on the passed thread name
        switch (Thread.currentThread().getName()) {
            case "Thread 1":
                color = ThreadColor.ANSI_CYAN;
                break;
            case "Thread 2":
                color = ThreadColor.ANSI_PURPLE;
                break;
            default:
                color = ThreadColor.ANSI_GREEN;
        }

        synchronized (this) {
            // Loop and print the threads name in its color
            // 'Solution 1': using an instance variable, shared between multiple threads
            // This will result in both threads interleaving, interfering with each other, accessing the same resources..
            // .. resulting in the skipping of numbers in this example == thread interference / race condition
            // This can be resolved by running the method as a 'synchronized' method or to put this for loop in a synchronized block.
            for (i = 10; i > 0; i--) {

                // Solution 2:
                // Using a local variable, only visible for the current thread
                // This way each thread is guaranteed to count down correctly in full
                //for (int i=10; i > 0; i--) {
                System.out.println(color + Thread.currentThread().getName() + ": i=" + i);
            }
        }
    }
}