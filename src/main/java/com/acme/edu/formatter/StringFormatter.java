package com.acme.edu.formatter;

import com.acme.edu.Logger;
import com.acme.edu.printer.PrinterToConsole;

/**
 * Created by Trofim Moshik on 04.03.2018.
 *
 * Форматтер строк.
 */
public class StringFormatter implements Formatter {
    private String value;
    private static int counter = 0;

    public StringFormatter(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public void format() {
        counter++;
        String s;

        if (counter == Logger.controller.list.size()) {
            if (counter == 1) {
                s = Types.STR.getName() + this.getValue();
                Logger.controller.formattedList.add(new PrinterToConsole(s));
                counter = 0;
            } else {
                s = Types.STR.getName() + this.getValue() + " (x" + counter + ")";
                Logger.controller.formattedList.add(new PrinterToConsole(s));
                counter = 0;
            }
        }
    }
}
