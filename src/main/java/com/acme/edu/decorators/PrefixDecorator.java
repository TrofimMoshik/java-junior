package com.acme.edu.decorators;

import com.acme.edu.printer.Printer;

public class PrefixDecorator extends DependencyDecorator {
    //region private fields
    private final String prefix;
    //endregion

    //region constructor

    /**
     * Creates instance of PrefixDecoratorCommand
     *
     * @param printers instances of Printer which will be used to log information
     */
    public PrefixDecorator(String prefix, Printer... printers) {
        if (prefix == null) {
            System.out.println("PrefixDecorator format argument should not be null");
        }

        if (printers == null || printers.length == 0) {
            System.out.println("Constructor printer argument couldn't be null");
        }
        this.printers = printers;
        this.prefix = prefix;
    }
    //endregion


    //region public methods

    /**
     * Decorates input string by prefix
     *
     * @param args array of string
     */
    @Override
    public void decorate(String... args) {
        if (args == null || args.length == 0) {
            System.out.println("PrefixDecoder arguments are null or empty");
        }
        String joinedStr = String.join(" ", args);
        if (args.length > 0) {
            printToAllPrinters(prefix + joinedStr);
        } else {
            printToAllPrinters(prefix);
        }
    }

    //endregion
}
