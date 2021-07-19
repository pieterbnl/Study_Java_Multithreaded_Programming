package com.pbe;

/** Study on Java Multithreaded Programming
 @author Pieter Beernink
 @version 1.0
 @since 1.0
 */

// *********************
// MULTITHREADED PROGRAMMING
// *********************
// Introduction to concurrency/threads
// - Concurrency: refers to an application doing more than one thing at a time.
//   It allows one task to run/continue, while another one runs as well.
// - Every Java application runs as a single process, and each process can have multiple threads:
//   - A process (or 'application') is a unit of execution, with it 's own memory space (the 'heap').
//   - A thread is a unit of execution, within a process.
// - Every application has at least one thread: the main thread.
//   Each instance of a JVM runs as a process (not true for all JVM implementations, but most of them).
// - Each application/process has its own memory space of heap, which all threads share (but that is not shared with other applications).
// - Each thread has a tread stack, memory that only that thread can access.
// - Local variables are stored in the thread stack. I.e.: each thread has its own copy of a local variable.
// - Memory required to store an objects instance value is allocated on the heap.
// - Creating a thread doesn't require as many resources as creating a process, which shares memory and files.
// - I.e. multiple threads working on the same object, share the same object, sharing changes in objects instance variables.
// - Multiple threads are useful when a complicated/long running task needs to be performed, potentially freezing the main tread.
// - Another reason is because an API requires a thread (or code to be run) to be provided.
// - JVM and the operating system control when threads are scheduled to run, resulting in varying output between runs.

// A multithreaded program consists of two or more parts that run concurrently.
// Each part is called a thread. Each thread defines its own path of execution.
// A thread is an executable, lightweight unit that accesses shared resources as well as its own call stack.

// Threads can be considered a form of multitasking. Two distinct types of multitasking:
// 1. Process-based: Having two or more programs run simultaneously.
// 2. Thread-based: Having two or more threads (read: tasks) within a program run simultaneously.
// With process-based multitasking a program is the smallest unit of code and with thread-based, a thread.

// Multitasking threads requires less overhead them multitasking processes (which btw are out of control of Java), as threads share common resources.
// Multithreading make it possible for application to maximize use of processing power of the system.
// It does so by minimizing idle time, as multiple threads can run while others are still waiting for example on data or input.

// Other terms used in relation with multithreading:
// Multiprocessing: more than one process is executed simultaneously. Similar to multitasking, but here more than one CPU is involved.
// Parallel processing: a technique where multiple CPUs work simultaneously in a computer system (see Fork/Join framework in Java for more on this).

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

// Note: threads that are mainly used in the background are sometimes also referred to as 'daemon threads'.

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

// Interrupting a thread
// Two ways for a thread to be interrupted:
// 1. Catch the interrupted exception
// 2. If the run() method doesnt call any methods that throw an exception,
// it should call the interrupted method periodically to check whether it has been interrupted
// That method will return true if the thread has been interrupted.
//
// One thread interrupts another by calling the interrupt method on th other instance it wants to interrupt
// For that it uses a reference to that thread instance.
//
// To interrupt: just call interrupt() on a thread: somethread.interrupt();


// Thread priorities
// The Thread class provides a setPriority() method to set the priority for a thread.
// Threads are assigned a priority (integer value) that determines how each thread should be treated compared to others.
// Using thread priority, it can be decide when to switch from one thread in running state to another.
// Switching from one thread to another is called a 'context switch' or 'context switching', the process wherein the program switches contexts of the threads.
// A contact switch takes place by the following rules:
// 1. Voluntarily relinquish control by a thread: This occurs when explicitly yielding, sleeping or when blocked. CPU is given to the highest prio thread that's ready.
// 2. Preemptive multitasking: Lower prio thread that does not yield the CPU is preempted. Higher prio thread that wants to run, does so.
//
// The thread scheduler uses priorities to decide when threads should be allowed to run.
// How prioritization of multiple threads with equal priority that compete for CPU cycles is resolved, depends on the operating system.
// Some don't even support it and will ignore it. So priority should mostly be considered a suggestion to the JVM & OS, rather than a command.
// Also the amount of CPU time given to a thread often depends on factors besides priority, such how the OS implements multitasking.
//
// The safest way to obtain predictable, cross-platform behavior with Java is to use threads that voluntary yield control.
// A higher priority thread can preempt (=take action to prevent an anticipated event happening) a lower priority thread.
// For safety, threads that share the same priority should yield control once in a while.
// This to ensure all threads have a chance to run under a non-preemptive OS (= non interrupting a process running CPU in the middle of execution).
// Threads of CPU-intensive tasks dominate the CPU and for this reason control should be yielded occasionally so that other threads can run.
//
// Use setPriority() to set a thread's priority: final void setPriority(int level) - with level being the priority setting.
// The value of level must be in the range MIN_PRIORITY (=1) and MAX_PRIORITY (=10)
// NORM_PRIORITY is used to return a thread to default priority (=5).
// These variables are defined as static final variables within Thread.
// Obtain the current priority setting by calling getPriority(): final int getPriority()

// Thread interference / race condition
// If multiple threads are working on shared resources at the same time this can result in 'thread interference'/'race condition'.
// Each thread then races each other to complete a method.
// This doesn't have to be a problem when they are just reading, but if they are also updating the resources, it will be a problem.
// Restricting access to only one thread at a time -by serializing access to call() fixes this.
// To do so: precede call()'s definition with the synchronized keyword: synchronized void call(String msg)

// Synchronization
// Multithreading introduces asynchronous behavior to programs. There are ways to enforce synchronicity when needed.
// This is needed for example to prevent conflicts when two threads are required to communicate and share a complicated data structure.
// For example a linked list, where one thread shouldn't be writing, while the other is still reading.
//
// Synchronization is the process to ensure that a resource is used only by a single thread at a time.
// Synchronization uses a 'monitor' to achieve this: an object that is used as a mutually exclusive lock.
// Each object has its own implicit monitor that's automatically entered when one of the objects synchronized methods is called.
// Each thread can 'own' a monitor at a given time and is said to have 'entered' the monitor when acquiring a lock.
// When a thread is inside a synchronized method, no other thread can call any other synchronized method on the same object.
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
//
// 2. The synchronized statement
// Creating synchronized methods within classes to achieve synchronization will not work in all cases.
// For example when using a third party class that does not use synchronized methods and does not offer access to its source code.
// The solution is to put calls to the methods defined by this class inside a synchronized block: synchronized(objRef) { // statements to be synchronized }
// The block ensures that a call to a synchronized method that is a member of objRef class occurs only after the current thread has entered objRef's monitor.

// Interthread communication
// Use of implicit monitors in Java objects is powerful, but a more subtle level of control can be achieved through interprocess communication.
// Multithreading replaces event loop programming by dividing tasks into discrete, logical units. They also do away with polling.
// Polling is usually implemented by a loop that is used to check a condition repeatedly until a certain condition is reached, wasting CPU time.
//
// To avoid polling, Java's interprocess communication mechanism can be used via the methods:
// 1. wait() - instructs the calling thread to give up the monitor and go sleep until another thread enters the monitor and calls notify() or notifyAll()
// 2. notify() - wakes up the thread that called wait() on the same object
// 3. notifyAll() - wakes up all the threads that called wait() on the same object, of which one will be granted access
//
// These methods are implemented as final methods in Object, so all classes have them, and declared as: final void wait(), final void notify(), ..
// They can be called only from within a synchronized context.
//
// Additional notes:
// - Additional forms of wait() al;low to specify a period of time to wait.
// - Wait() normally waits until notify() or notifyAll() is called.. BUT.. in rare cases the waiting thread can be awakened due to a 'spurious wakeup'.
// Meaning a waiting thread resumes without notify() or notifyAll() being called (i.e.: the thread resumes for no apparent reason).
// It is therefore recommended that calls to wait() take place within a loop that checks the condition on which the thread is waiting.

// Deadlock
// A deadlock occurs when two threads have a circular dependency on a pair of synchronized objects.
// For example when thread 1 enters the monitor on object X and thread2 on object Y.
// If thread in X tries to call a synchronized method on Y, it will be blocked as it should.
// When the tread in Y tries to call a synchronized method on X, the threads will end up waiting forever to release their locks.
//
// Deadlock occurs when two or more threads acquire -at just the same time- locks which prevent either of them from progressing. This makes it difficult to debug.
// If a multithreaded program locks up occasionally, deadlock is one of the first things to check for.

// Suspending, Resuming and Stopping Threads
// Suspending execution of a thread can be useful sometimes. In early version of Java programs could use suspend(), resume(), stop().
// Which are methods defined by Thread to control the execution of a thread. These method should/can no longer be used, for safety reasons.
// Instead, a thread must be designed so that the run() method periodically checks to determine whether a thread should suspend/resume/stop.
// This can be accomplished by establishing a flag variable that indicates the execution state of the thread.
// The flag can be set to 'running', 'suspend' or 'stop' to have the thread respectively continue, suspend or stop.
// This approach must be used for all new code.

// Obtaining a thread's state
// A thread can exist in a number of different states. The current state can be obtained by calling getState(): Thread.State getState()
// It returns a value of type Thread.State, which indicates the state of the thread at the time of the call.
// State is an enumeration (=list of named constants) defined by Thread.
// Values that can be returned by getState(): BLOCKED, NEW, RUNNABLE, TERMINATED, TIMED_WAITING, WAITING
// To determine for example if a thread name t is in the RUNNABLE state:
// Thread.State ts = t.getState()
// if(ts == Thread.State.RUNNABLE) // ...
// Note: a thread's state may (a moment later) change after the call to getState()! Use it primarily for debugging or for profiling a thread's run-time characteristics.

// Using a factory method to create and start a thread
// It's possible to create and start a thread at the same time by using a static factory method (= a method that returns an object of a class)
// Call start() on the thread and then return a reference to the thread. This way a thread can be created and started through a single method.

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

        // **********************
        // Example of an incorrect implementation of a producer and consumer
        // **********************
        // The put() and get() methods on Q are synchronized.
        // However, nothing stops the producer from overrunning the consumer, or the consumer from consuming the same queue value twice.
        // As a result, the output is erroneous.
        // The producer will put an x number, the consumer starts and will get the number x times.
        // Both threads will continue to fight for CPU, without letting the other time.
        Queue q = new Queue();
        Producer p = new Producer(q);
        Consumer c = new Consumer(q);

        // Start the threads - which will continue running endlessly. Stop Main to exit the program.
        p.t.start();
        c.t.start();


        // **********************
        // Example of a correct implementation of a producer and consumer
        // **********************
        // Now with use of wait() and notify() to signal in both directions
        Queue2 q2 = new Queue2();
        Producer2 p2 = new Producer2(q2);
        Consumer2 c2 = new Consumer2(q2);

        // Start the threads - which will continue running endlessly. Stop Main to exit the program.
        p2.t.start();
        c2.t.start();

        // **********************
        // Deadlock example
        // **********************
        // This example will create a deadlock, with RacingThread trying to call A.last() and MainThread trying to call B.last()
        // RacingThread owns the monitor on b, while it is waiting for the monitor on a
        // MainThread at the same time owns the monitor on a and is waiting to get b
        Deadlock dl = new Deadlock(); // this will trigger the Deadlock constructor, which will initiate the creation of 2 threads
        dl.deadLockStart();

        // **********************
        // Suspending and resuming a thread with use of a flag variable
        // **********************
        // This example illustrates how the wait() and notify() methods (inherited from Object) can be used to control the execution of a thread.

        // Create the threads
        NewThread3 object1 = new NewThread3("One");
        NewThread3 object2 = new NewThread3("Two");

        // Start the threads
        object1.t.start();
        object2.t.start();

        try {
            Thread.sleep(1000);
            object1.mysuspend();
            System.out.println("Suspending thread one");
            Thread.sleep(1000);
            object1.myresume();
            System.out.println("Resuming thread one");
            object2.mysuspend();
            System.out.println("Suspending thread two");
            Thread.sleep(1000);
            object2.myresume();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }

        // wait for threads to finish
        try {
            System.out.println("Waiting for threads to finish");
            object1.t.join();
            object2.t.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        System.out.println("Main thread exiting");
    }
}