package com.acme.edu.formatter;

import com.acme.edu.Logger;
import com.acme.edu.printer.PrinterToConsole;

/**
 * Created by Trofim Moshik on 04.03.2018.
 *
 * Форматтер символов.
 */
public class CharFormatter implements Formatter {
    private Character value;

    public CharFormatter(char value) {
        this.value = value;
    }

    public Character getValue() {
        return value;
    }

    @Override
    public void format() {
        String s;
        s = Types.CHAR.getName() + this.getValue().toString();
        Logger.controller.formattedList.add(new PrinterToConsole(s));
    }
}
