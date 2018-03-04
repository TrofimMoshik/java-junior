package com.acme.edu.printer;

/**
 * Created by Trofim Moshik on 03.03.2018.
 *
 * Вывод на печать в консоль.
 */
public class PrinterToConsole implements Printer {
    private String value;

    public PrinterToConsole(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void print() {
        System.out.println(this.getValue());
    }
}
