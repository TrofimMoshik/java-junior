package com.acme.edu.formatter;

import com.acme.edu.Logger;
import com.acme.edu.printer.PrinterToConsole;

/**
 * Created by Trofim Moshik on 04.03.2018.
 *
 * Форматтер двумерной матрицы.
 */
public class MatrFormatter implements Formatter {
    private int[][] value;

    public MatrFormatter(int[][] value) {
        this.value = value;
    }

    public int[][] getValue() {
        return value;
    }

    @Override
    public void format() {
        String s = Types.PRIM_MATR.getName() + "{\r\n";
        for (int i = 0; i < value.length; i++) {
            s += "{";
            for (int j = 0; j < value[i].length; j++) {
                if (j == value[i].length - 1) {
                    s += value[i][j];
                } else {
                    s += value[i][j] + ", ";
                }
            }
            s += "}\r\n";
        }
        s += "}";
        Logger.controller.formattedList.add(new PrinterToConsole(s));
    }
}
