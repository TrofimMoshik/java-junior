package com.acme.edu.formatter;

import com.acme.edu.Logger;
import com.acme.edu.printer.PrinterToConsole;

/**
 * Created by Trofim Moshik on 04.03.2018.
 */
public class ArrFormatter implements Formatter {
    private int[] value;

    public ArrFormatter(int[] value) {
        this.value = value;
    }

    public int[] getValue() {
        return value;
    }

    @Override
    public void format() {
        String s = Types.PRIM_ARR.getName() + "{";
        for (int i = 0; i < this.value.length; i++) {
            if (i == this.value.length - 1) {
                s += this.value[i];
            } else {
                s += this.value[i] + ", ";
            }
        }
        s += "}";
        Logger.controller.formattedList.add(new PrinterToConsole(s));
    }
}
