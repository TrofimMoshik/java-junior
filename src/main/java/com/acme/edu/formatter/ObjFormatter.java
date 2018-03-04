package com.acme.edu.formatter;

import com.acme.edu.Logger;
import com.acme.edu.printer.PrinterToConsole;

/**
 * Created by Trofim Moshik on 04.03.2018.
 *
 * Форматтер объектов.
 */
public class ObjFormatter implements Formatter {
    private Object value;

    public ObjFormatter(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public void format() {
        String s;
        s = Types.REF.getName() + this.getValue().toString();
        Logger.controller.formattedList.add(new PrinterToConsole(s));

    }
}
