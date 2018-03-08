package com.acme.edu.printer;

/**
 * Created by Trofim Moshik on 08.03.2018.
 *
 * Вывод на печать в консоль.
 */
public class PrinterToConsole implements Printer {
    @Override
    public void print(String string) {
        System.out.println(string);
    }
}
