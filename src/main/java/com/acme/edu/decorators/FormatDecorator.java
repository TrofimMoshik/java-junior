package com.acme.edu.decorators;

import com.acme.edu.printer.Printer;

public class FormatDecorator extends DependencyDecorator {
    //region private fields
    private final String format;
    //endregion

    //region constructor

    /**
     * Creates instance of PrefixDecoratorCommand
     *
     * @param printers instances of Printers which will be used to log information
     */
    public FormatDecorator(String format, Printer... printers)  {
        if (format == null) {
            System.out.println("FormatDecorator: format should not be null");
        }

        if (printers == null || printers.length == 0) {
            System.out.println("Constructor printer argument couldn't be null");
        }

        this.printers = printers;
        this.format = format;
    }

    //endregion


    //region public methods

    /**
     * Format input string by passed format rules
     *
     * @param args array of string
     */
    @Override
    public void decorate(String... args)  {
        if (args == null || args.length == 0) {
            System.out.println("FormatDecoder arguments are null or empty");
        }
        printToAllPrinters(String.format(format, args));
    }
    //endregion

}
