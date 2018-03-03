package com.acme.edu.printer;

public class SimplePrinter implements Printer {
    /**
     * Print message to log
     *
     * @param message print parameter
     */
    @Override
    public void log(String message) {
        /**
         * Short logical operator ||
         */
        if (message == null || message.isEmpty()) {
            System.out.println("Null or empty Message passed to Printer");
        }
        System.out.println(message);
    }

    @Override
    public void flush() {
        /*Do nothing*/
    }
}
