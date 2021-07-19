package com.pbe.multiplethreads;

public class CountdownThread extends Thread {

    // Create a countdown object
    private Countdown threadCountdown;

    // Constructor - accepts a countdown object
    public CountdownThread(Countdown countdown) {
        threadCountdown = countdown;
    }

    // Run method which will initiate the countdown
    public void run() {
        threadCountdown.doCountdown();
    }
}