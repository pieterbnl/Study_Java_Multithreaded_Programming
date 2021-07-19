package com.pbe.threadsexample;

import static com.pbe.threadsexample.ThreadColor.ANSI_BLUE;
import static com.pbe.threadsexample.ThreadColor.ANSI_RED;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(ANSI_RED + "MyRunnable's implementation of run()");
    }
}