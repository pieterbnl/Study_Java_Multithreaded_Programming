package com.pbe.messages;

import java.util.Random;

// Reads messages
public class Reader implements Runnable {

    private Message message;

    // Constructor - receiving a message object
    public Reader(Message message) {
        this.message = message;
    }

    // Run() wil be run with thread start
    @Override
    public void run() {
        Random random = new Random(); // create random object, used for sleeping
        for (String latestMessage = message.read();
            !latestMessage.equals("done"); // check for the last message, which is "done"
            latestMessage = message.read()) {
            System.out.println(latestMessage); // process each message and print it to the console
            try {
                Thread.sleep(random.nextInt(2000)); // waiting randomly up to 2 sec, after reading a message
            } catch (InterruptedException e) {
                //
            }
        }
    }
}