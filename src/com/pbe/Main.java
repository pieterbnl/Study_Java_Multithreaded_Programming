package com.pbe;

/** Study on Java Multithreaded Programming
 @author Pieter Beernink
 @version 1.0
 @since 1.0
 */

// *********************
// MULTITHREADED PROGRAMMING
// *********************
// A multithreaded program consists of two or more parts that run concurrently.
// Each part is called a thread. Each thread defines its own path of execution.
// I.e. it can be considered a form of multitasking. Two distinct types of multitasking:
// 1. Process-based: Having two or more programs run simultaneously.
// 2. Thread-based: Having two or more 'tasks' within a program run simultaneously.
// With process-based multitasking a program is the smallest unit of code and with thread-based, a thread.

// Multitasking threads requires less overhead them multitasking processes (which btw are out of control of Java), as threads share common resources.
// Multithreading make it possible for application to maximize use of processing power of the system.
// It does so by minimizing idle time, as multiple threads can run while others are still waiting for example on data or input.

// Thread model
// Java run-time uses threads to enable the entire environment to be asynchronous.
// Single-threaded systems: if a thread suspends execution because it's waiting for some resource, the entire program stops.
// Multi-threaded systems: have multiple threads running, of which some may be waiting, without holding up other threads and thus the program keeps running.
// With a single core CPU multithreading will result in having idle CPU time utilized. With multicore CPU's, threads actually run simultaneously.

// Note: besides Java traditional multithreading capabilities, there's also the Fork/Join Framework which is part of Java's support for parallel programming.
// Parallel programming consists of techniques that optimize some types of algorithms for parallel execution in systems with multiple CPU's.

// Thread states
// Threads exist in different states. A thread can be:
// 1. Ready to run, as soon as it gets CPU time
// 2. Running
// 3. Suspended; temporarily halted activity
// 4. Resumed; picking up a suspended thread where it left off
// 5. Blocked, when waiting for a resource
// And at any time, a thread can be terminated. Once terminated, the thread no longer exists.

// Thread priorities
// Threads are assigned a priority (integer value) that determines how each thread should be treated compared to others.
// Switching from one thread to another is called a context switch. A contact switch takes place by the following rules:
// 1. Voluntarily relinquish control by a thread: This occurs when explicitly yielding, sleeping or when blocked. CPU is given to the highest prio thread that's ready.
// 2. Preemptive multitasking: Lower prio thread that does not yield the CPU is preempted. Higher prio thread that wants to run, does so.
// How prioritization of multiple threads with equal priority that compete for CPU cycles is resolved, depends on the operating system.

// Synchronization
// Multithreading introduces asynchronous behavior to programs. There are ways to enforce synchronicity when needed.
// This is needed for example to prevent conflicts when two threads are required to communicate and share a complicated data structure.
// For example a linked list, where one thread shouldn't be writing, while the other is still reading.
// Java uses 'the monitor' for this purpose. This is a control system that can be used to protect a shared asset from being manipulated by more than one thread at the time.
// Each object has its own implicit monitor that's automatically entered when one of the objects synchronized methods is called.
// When a thread is inside a synchronized method, no other thread can call any other synchronized method on the same object.

// Messaging
// With a program divided in separate threads, it must be defined how they communicate with each other.
// Java's messaging system allows a thread to enter a synchronized method on an object, and then wait until some other thread explicitly notifies it to come out.

// Thread class & Runnable interface
// Java's multithreading system is build upon the Thread class, its methods and companion interface Runnable.
// Thread encapsulates a thread of execution. A thread can be dealt with through its proxy, the Thread instance that spawned it.
// To create a new thread, a program either extends Thread or implement Runnable.
// Several methods to help manage threads are: getName, getPriority, isAlive, join, run, sleep, start

// The main thread
// The main thread is the one thread that all Java programs have. It's the thread that's executed when starting the program.
// 'Child' threads are spawned from the main thread. And often it's the last thread to finish execution, to perform shutdown actions.
// The main thread can be controlled through a Thread object, by obtaining a reference to it with currentThread(), a public static member of Thread.
// The method returns a reference to the thread in which it is called. Once referenced, it can be controlled like any other thread.
// Threads are part of groups. A thread group is a data structure that controls the state of a collection of threads as a whole.

// Creating a thread
// A thread can be created by instantiating an object of type Thread:
// 1. By implementing the Runnable interface
// 2. By extending the Thread class

// What approach to choose?
// Using thread requires run() to be overridden. This is the same method required when implementing Runnable.
// As it's common use to only extend classes when they are being enhanced or adapted, implementing Runnable is favored.
// By implementing Runnable, the thread class does not need to inherit Thread, making it free to inherit a different class.

// Detailing of both solutions ->>

// 1. Implementing Runnable
// A thread can be constructed on any object that implements Runnable.
// To implement Runnable, a class only needs to implement run(), declared by: public void run()
// Inside run(), code needs to be defined for the new thread.
// Run() can call other classes and declare variables, as the main thread can.
// The difference: run() establishes the entry point for another, concurrent thread of execution with the program.
// This thread ends when run() returns.
// After creating a class that implements Runnable, instantiate an object of type Thread from within the class.
// Thread defines several constructors. One of them: Thread(Runnable threadOb, String threadName)
// Here, threadOb is an instance of the class that implements Runnable and defines where execution of the thread starts.
// It will not start running until start() is called. I.e.: start() initiates a call to run().

// 2. Extending thread
// Another way to create a thread is to create an instance of a class that extends Thread.
// The extending class must override run(), which is the entry point for the thread.
// And start() is to be called to begin execution of the new thread.

// Ending a thread
// Two ways to determine if a thread has finished:
// 1. Call isAlive() on the thread: final boolean isAlive() - will return true if the thread is alive
// 2. More commonly used, call join(): final void join() throws InterruptedException
// Join() waits until the thread on which it is called terminates.
// It also allows to specify a maximum amount of time to wait for the specified thread to terminate.

// Thread priorities
// The thread scheduler uses priorities to decide when threads should be allowed to run.
// The amount of CPU time given to a thread often depends on factors besides priority, such how the OS implements multitasking.
// The safest way to obtain predictable, cross-platform behavior with Java is to use threads that voluntary yield control.
// A higher priority thread can preempt (=take action to prevent an anticipated event happening) a lower priority thread.
// For safety, threads that share the same priority should yield control once in a while.
// This to ensure all threads have a chance to run under a non-preemptive OS (= non interrupting a process running CPU in the middle of execution).
// Threads of CPU-intensive tasks dominate the CPU and for this reason control should be yielded occasionally so that other threads can run.
// Use setPriority() to set a thread's priority: final void setPriority(int level) - with level being the priority setting.
// The value of level must be in the range MIN_PRIORITY (=1) and MAX_PRIORITY (=10)
// NORM_PRIORITY is used to return a thread to default priority (=5).
// These variables are defined as static final variables within Thread.
// Obtain the current priority setting by calling getPriority(): final int getPriority()

// Synchronization
// Synchronization is the process to ensure that a resource is used only by a single thread at a time.
// Synchronization uses a 'monitor' to achieve this: an object that is used as a mutually exclusive lock.
// Each thread can 'own' a monitor at a given time and is said to have 'entered' the monitor when acquiring a lock.
// Other threads attempting to enter the locked monitor will be suspended until the initial thread 'exits' the monitor.
// The other threads are 'waiting'.
// A thread that owns a monitor can reenter it if it wants.

// Code can be synchronized in two ways, both involving the synchronized keyword:
// 1. Using synchronized methods
// 2. The synchronized statement
// ->>

// 1. Using synchronized methods
// All objects have their own implicit monitor associated with them.
// To enter an objects monitor, make a call to a method that has been modified with the synchronized keyword.
// Threads that call a synchronized method on the same instance while there's already a thread inside, must wait.
// The monitor is exited by returning from the synchronized method and can then relinquish control of the object to the next waiting thread.

// 2. The synchronized statement
// Creating synchronized methods within classes to achieve synchronization will not work in all cases.
// For example when using a third party class that does not use synchronized methods and does not offer access to its source code.
// The solution is to put calls to the methods defined by this class inside a synchronized block: synchronized(objRef) { // statements to be synchronized }
// The block ensures that a call to a synchronized method that is a member of objRef class occurs only after the current thread has entered objRef's monitor.


public class Main {

    public static void main(String[] args) {

        // **********************
        // Example of controlling the main thread
        // **********************
        System.out.println("Controlling the main thread");
        Thread t = Thread.currentThread();
        System.out.println("Current thread: " + t); // will print: thread name, its priority, name of its group
        t.setName("My main thread");
        System.out.println("Current thread, after name change: " + t);
        System.out.println("Alternative way to just get the thread name: " + t.getName());
        try { // sleep() could throw an InterruptedException, if another thread wants to interrupt
            for (int x = 5; x > 0; x--) {
                System.out.println(x);
                Thread.sleep(500); // note using Thread instead of t for reference &
                // sleep can also be specified in nanoseconds, if the environment allows such timing periods
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted"); // just printing a message in this example
        }
        System.out.println();

        // **********************
        // Example of creating and starting a new thread, with NewThread class that implements Runnable
        // **********************
        System.out.println("Creating and starting a new thread, by implementing Runnable");
        NewThread nt = new NewThread(); // create a new thread
        nt.t.start(); // start the thread - note that this will initiate a call to run()
        try {
            for (int x = 5; x > 0; x--) { // with the now created NewThread, both NewThread and main thread will run, sharing the CPU
                System.out.println("Main thread: " + x);
                Thread.sleep(500); // by setting the main thread sleep time higher than the child thread, this causes the child thread to terminate earlier
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        System.out.println("Main thread exiting \n");

        // **********************
        // Example of creating and starting a new thread, by extending Thread
        // **********************
        System.out.println("Creating and starting a new thread, by extending Thread");
        NewThread2 nt2 = new NewThread2(); // create thread
        nt2.start(); // start thread
        try {
            for(int x = 5; x > 0; x--) {
                System.out.println("Main thread: " + x);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        System.out.println("Main thread exiting");

        // Creating three child threads
        System.out.println("Creating three child threads");
        MultipleThreads mp1 = new MultipleThreads("Child thread one");
        MultipleThreads mp2 = new MultipleThreads("Child thread two");
        MultipleThreads mp3 = new MultipleThreads("Child thread three");

        // Starting the threads
        mp1.t.start();
        mp2.t.start();
        mp3.t.start();

        try {
            Thread.sleep(10000); // making main thread sleep 10sec to ensure it finishes last
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        System.out.println("Main thread exiting \n");

        // **********************
        // Creating three child threads - improved version
        // **********************
        // Using join() (instead of Thread.sleep()) to ensure that the main thread is the last to stop
        System.out.println("Creating three child threads, improved version");

        // Creating three child threads
        mp1 = new MultipleThreads("Child thread one");
        mp2 = new MultipleThreads("Child thread two");
        mp3 = new MultipleThreads("Child thread three");

        // Starting the threads
        mp1.t.start();
        mp2.t.start();
        mp3.t.start();

        System.out.println("Thread 1 is alive: " + mp1.t.isAlive()); // using isAlive() to check the thread status
        System.out.println("Thread 2 is alive: " + mp2.t.isAlive());
        System.out.println("Thread 3 is alive: " + mp3.t.isAlive());

        try {
            System.out.println("Waiting for threads to finish");
            mp1.t.join(); // using join() instead of sleep()
            mp2.t.join();
            mp3.t.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        System.out.println("Thread 1 is alive: " + mp1.t.isAlive()); // after the calls to join() return, the threads have stopped executing
        System.out.println("Thread 2 is alive: " + mp2.t.isAlive());
        System.out.println("Thread 3 is alive: " + mp3.t.isAlive());
        System.out.println("Main thread exiting \n");

        // **********************
        // Demonstration of synchronization, under 'race condition'
        // **********************
        // Calling sleep() in Callme, has call() allowing execution to switch to another thread, resulting in mixed-up output of three messages.
        // In this example nothing exists to stop all three threads from the same method on the same object at the same time.
        // This is a race condition because the three threads race each other to complete the method.
        // Sleep() as used in callme() makes the effects more repeatable and obvious.
        // Restricting access to only one thread at a time -by serializing access to call()- fixes the mix-up of messages.
        // To do so: precede call()'s definition with the synchronized keyword: synchronized void call(String msg)
        System.out.println("Demonstration of synchronization, under race condition");
        Callme target = new Callme();

        // Create three child threads, all pointing to target

        Caller ob1 = new Caller(target, "Hello");
        Caller ob2 = new Caller(target, "Synchronized");
        Caller ob3 = new Caller(target, "World");

        // Start the threads
        ob1.t.start();
        ob2.t.start();
        ob3.t.start();

        // Wait for threads to end
        try {
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println();

        // **********************
        // Demonstration of synchronization, using a synchronized block (in CallerSynchronized class)
        // **********************
        // CallerSynchronized class is a copy of Caller class, now using a synchronized statement inside CallerSynchronized run() method
        // This makes each thread wait for the prior one to finish before proceeding, resulting in the same results as previous example.
        // Without having call() modified by synchronized.
        System.out.println("Demonstration of synchronization, using a synchronized block");
        Callme target_s = new Callme();

        // Create three child threads, all pointing to target
        CallerSynchronized obs1 = new CallerSynchronized(target_s, "Hello");
        CallerSynchronized obs2 = new CallerSynchronized(target_s, "Synchronized");
        CallerSynchronized obs3 = new CallerSynchronized(target_s, "World");

        // Start the threads
        obs1.t.start();
        obs2.t.start();
        obs3.t.start();

        // Wait for threads to end
        try {
            obs1.t.join();
            obs2.t.join();
            obs3.t.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println();


    }
}