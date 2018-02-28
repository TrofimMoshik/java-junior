package com.acme.edu;

public class Logger {
    public static void log(int message) {
        System.out.println("primitive: " + message);
    }

    public static void log(byte message) {
        System.out.println("primitive: " + message);
    }

    public static void log(Object message) {
        System.out.println("reference: " + message);
    }

    public static void log(boolean message) {
        if (message == true) {
            System.out.println("primitive: " + "true");
        } System.out.println("primitive: false");

    }

public static void log(String message) {
        System.out.println("string: " + message);
    }

    public static void log(char message) {
        System.out.println("char: " + message);
    }
}
