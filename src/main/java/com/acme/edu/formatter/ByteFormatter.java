package com.acme.edu.formatter;

import com.acme.edu.Logger;
import com.acme.edu.printer.PrinterToConsole;

/**
 * Created by Trofim Moshik on 04.03.2018.
 *
 * Форматтер типа байт.
 */
public class ByteFormatter implements Formatter {
    private Byte value;

    public ByteFormatter(Byte value) {
        this.value = value;
    }

    public Byte getValue() {
        return value;
    }

    @Override
    public void format() {
        String s;
        s = Types.PRIM.getName() + this.getValue();
        Logger.controller.formattedList.add(new PrinterToConsole(s));
    }
}
