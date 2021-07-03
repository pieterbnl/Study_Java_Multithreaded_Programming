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

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}
