package com.acme.edu.formatter;

import com.acme.edu.Logger;
import com.acme.edu.printer.PrinterToConsole;

/**
 * Created by Trofim Moshik on 04.03.2018.
 */
public class BoolFormatter implements Formatter {
    private boolean value;

    public BoolFormatter(boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return value;
    }

    @Override
    public void format() {
        String s;
        s = Types.PRIM.getName() + this.getValue().toString();
        Logger.controller.formattedList.add(new PrinterToConsole(s));
    }
}
