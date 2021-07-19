package com.pbe.messages;

import java.util.Random;

// Writes 4 messages
public class Writer implements Runnable {
    private Message message;

    // Constructor - receives a message object
    public Writer(Message message) {
        this.message = message;
    }

    // Run() wil be run with thread start
    @Override
    public void run() {
        String messages[] = { // set messages to be written
                "Humpty Dumpty sat on a wall",
                "Humpty Dumpty had a great fall",
                "All the king's horses and all the king's men",
                "Couldn't put Humpty together again"
        };

        // Create random object, used later for setting a random sleeping time on the thread
        Random random = new Random();

        // Loop through array of messages and write each message one by one
        for (int i=0; i<messages.length; i++) {
            message.write(messages[i]);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                //
            }
        }
        message.write("done");
    }
}