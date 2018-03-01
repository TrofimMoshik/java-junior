package com.acme.edu;

public class Logger {
    private static int SUM_INT = 0, SUM_STR = 0;
    private static String PRIM = "primitive: ";
    private static String REF = "reference: ";
    private static String CHAR = "char: ";
    private static String STR = "string: ";
    private static String ARR = "primitives array: ";
    private static String MATR = "primitives matrix: ";
    private static String STR_TO_COMPARE;

    public static void flush(){
        SUM_INT = 0;
        SUM_STR = 1;
        STR_TO_COMPARE = "";
    }

    public static void log(int message) {
        if (message == Integer.MAX_VALUE) {
            SUM_INT = 0;
        }
        SUM_INT += message;
        printToConsole(SUM_INT, PRIM);
    }

    public static void log(int[] message) {
        String s = "{";
        for (int i = 0; i < message.length; i++) {
            if (i == message.length - 1) {
                s += message[i];
            } else {
                s += message[i] + ", ";
            }
        }
        s += "}";
        printToConsole(s, ARR);
    }

    public static void log(int[][] message) {
        printToConsole("{", MATR);
        for (int i = 0; i < message.length; i++) {
            String s = "{";
            for (int j = 0; j < message[i].length; j++) {
                if (j == message[i].length - 1) {
                    s += message[i][j];
                } else {
                    s += message[i][j] + ", ";
                }
            }
            s +="}";
            printToConsole(s, "");
        }
        printToConsole("}", "");

    }

    public static void log(byte message) {
        Logger.flushStr();
        printToConsole(message, PRIM);
    }

    public static void log(Object message) {
        Logger.flushStr();
        printToConsole(message.toString(), REF);
    }

    public static void log(boolean message) {
        Logger.flushStr();
        if (message) {
            printToConsole("true", PRIM);
        } printToConsole("false", PRIM);
    }

    public static void log(String message) {
        SUM_INT = 0;
        printToConsole(message, STR);
    }

    public static void log(char message) {
        Logger.flushStr();
        printToConsole(message, CHAR);
    }

    private static void flushStr(){
        SUM_STR = 1;
        STR_TO_COMPARE = "";
    }

    private static void printToConsole(int message, String prefix) {
        System.out.println(prefix + message);
    }

    private static void printToConsole(String message, String prefix) {
        System.out.println(prefix + message);
    }
    private static void printToConsole(char message, String prefix) {
        System.out.println(prefix + message);
    }
}
