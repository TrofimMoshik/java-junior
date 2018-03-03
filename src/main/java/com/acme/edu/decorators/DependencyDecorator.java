package com.acme.edu.decorators;

import com.acme.edu.printer.Printer;

public abstract class DependencyDecorator implements Decorator{
    private static final String message = "Some of printers are not available";
    protected Printer[] printers;

    /**
     * Format input string by passed format rules
     *
     * @param args array of string
     */
    @Override
    public abstract void decorate(String... args);
    /**
     * Flushs printers buffer if it is exists
     *
     */
    @Override
    public void flush() {
        for (Printer printer : printers) {
                printer.flush();
        }
    }
    /**
     * Prints message on all available printers
     *
     * @param message param to print
     */
    protected void printToAllPrinters(String message) {

        for (Printer printer : printers) {
                printer.log(message);
        }
    }
}
