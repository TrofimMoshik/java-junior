package com.acme.edu.formatter;

import com.acme.edu.Logger;
import com.acme.edu.printer.PrinterToConsole;

/**
 * Created by Trofim Moshik on 04.03.2018.
 *
 * Форматтер массива строк.
 */
public class StrVarArgFormatter implements Formatter {
    private String[] value;

    public StrVarArgFormatter(String[] value) {
        this.value = value;
    }

    public String[] getValue() {
        return value;
    }

    @Override
    public void format() {
        String s = "";
        for (int i = 0; i < value.length; i++) {
            s += value[i] + "\r\n";
        }
        Logger.controller.formattedList.add(new PrinterToConsole(s));
    }
}
