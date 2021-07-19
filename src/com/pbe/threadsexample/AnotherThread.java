package com.pbe.threadsexample;

import static com.pbe.threadsexample.ThreadColor.ANSI_BLUE;

public class AnotherThread extends Thread {

    @Override
    public void run() {
        System.out.println(ANSI_BLUE + "This is " + currentThread().getName());

        try {
            Thread.sleep(3000);
        } catch(InterruptedException e) {
            System.out.println(ANSI_BLUE +  "Another thread triggered me");
        }

        System.out.println(ANSI_BLUE + "3 seconds passed; I'm still here");
    }
}