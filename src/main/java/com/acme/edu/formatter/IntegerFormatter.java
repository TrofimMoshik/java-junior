package com.acme.edu.formatter;

import com.acme.edu.Logger;
import com.acme.edu.printer.PrinterToConsole;

/**
 * Created by Trofim Moshik on 03.03.2018.
 *
 * Форматтер целых чисел.
 */
public class IntegerFormatter implements Formatter {
    private Integer value;

    public IntegerFormatter(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public void format() {
        String s;
        s = Types.PRIM.getName() + this.getValue();
        Logger.controller.formattedList.add(new PrinterToConsole(s));
    }
}
