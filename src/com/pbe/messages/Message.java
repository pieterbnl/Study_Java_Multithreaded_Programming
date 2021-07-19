package com.pbe.messages;

public class Message {

    private String message;
    private boolean empty = true; // instance variable, influenced by all active threads on the object

    // Read a message
    public synchronized String read() {
        while(empty) {
            try {
                wait();
            } catch(InterruptedException e) {
                //
            }
        }
        empty = true; // indicates a message is read
        notifyAll();  // indicates other thread may take over
        return message; // return the message
    }

    // Write a message
    public synchronized void write(String message) {
        while(!empty) {
            try {
                wait();
            } catch(InterruptedException e) {
                //
            }
        }
        empty = false; // indicates a message is still to be read
        this.message = message; // save the message
        notifyAll(); // indicates other thread may take over
    }
}