package com.pbe.messages;

// Demonstrating the Producer Consumer principle:
// One Class produces messages
// Another consumes the messages
public class Main {

    public static void main(String[] args) {
        // Only one synchronized method can run at the same time
        // When running multiple synchronized methods, they will block each other,
        // one thread holding a lock on the shared resource, the other thread waiting for it to be released.
        // Therefore require to use wait() and notifyall() in the message class.
        Message message = new Message();
        (new Thread(new Writer(message))).start(); // calling Writer, passing empty message object
        (new Thread(new Reader(message))).start(); // calling Reader, passing empty message object
    }
}