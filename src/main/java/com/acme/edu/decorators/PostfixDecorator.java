package com.acme.edu.decorators;

import com.acme.edu.printer.Printer;

public class PostfixDecorator extends DependencyDecorator {

    //region private fields
    private final String postfix;
    //endregion

    //region constructor

    /**
     * Creates instance of PrefixDecoratorCommand
     *
     * @param printers instances of Printer which will be used to log information
     */
    public PostfixDecorator(String postfix, Printer... printers) {
        if (postfix == null) {
            System.out.println("PostfixDecorator format argument should not be null");
        }

        if (printers == null || printers.length == 0) {
            System.out.println("Constructor printer argument couldn't be null");
        }

        this.printers = printers;
        this.postfix = postfix;
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
            System.out.println("PostfixDecorator arguments are null or empty");
        }
        String joinedStr = String.join(" ", args);
        printToAllPrinters(joinedStr + postfix);
    }
    //endregion
}
