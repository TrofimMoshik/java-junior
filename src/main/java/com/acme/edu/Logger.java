package com.acme.edu;

/**
 * Logger-facade.
 */
public class Logger {
    public static Controller controller = new Controller();

    public static void log(int messag) {
        controller.add(messag);
    }

    public static void log (String message) {
        controller.add(message);
    }

    public static void log(byte message) {
        controller.add(message);
    }

    public static void log(char message) {
        controller.add(message);
    }

    public static void log(boolean message) {
        controller.add(message);
    }

    public static void log(Object message) {
        controller.add(message);
    }

    public static void log(int... message) {
        controller.add(message);
    }

    public static void log(int[][] message) {
        controller.add(message);
    }

    public static void log(int[][][][] message) {
        controller.add(message);
    }

    public static void log(String... message) {
        controller.add(message);
    }
}
