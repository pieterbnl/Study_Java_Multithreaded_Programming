package com.pbe.threadsexample;

// Defining colors, which can be used to indicate different threads console output more clear
public class ThreadColor {
    public static final String ANSI_RESET = "\u001B[0m"; // console default color
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m"; // used for anonymous thread
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m"; // used for another thread
    public static final String ANSI_PURPLE = "\u001B[35m"; // used for main thread
    public static final String ANSI_CYAN = "\u001B[36m";

    // note, to change backgrounds, use:
    // public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
}
