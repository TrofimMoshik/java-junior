package com.acme.edu.formatter;

import com.acme.edu.Logger;
import com.acme.edu.printer.PrinterToConsole;

/**
 * Created by Trofim Moshik on 04.03.2018.
 *
 * Форматтер четырехмерной матрицы.
 */
public class MultiMatrFormatter implements Formatter {
    private int[][][][] value;

    public MultiMatrFormatter(int[][][][] value) {
        this.value = value;
    }

    public int[][][][] getValue() {
        return value;
    }

    @Override
    public void format() {
        String s = Types.MULT_MATR.getName() + "{\r\n";
        for (int i = 0; i < value.length; i++) {
            s += "{\r\n";
            for (int j = 0; j < value[i].length; j++) {
                s += "{\r\n";
                for (int k = 0; k < value[i][j].length; k++) {
                    s += "{\r\n";
                    for (int l = 0; l < value[i][j][k].length; l++) {
                        if (l == value[i].length - 1) {
                            s += value[i][j][k][l] + "\r\n";
                        } else {
                            s += value[i][j][k][l] + ", ";
                        }
                    }
                    s += "}\r\n";
                }
                s += "}\r\n";
            }
            s += "}\r\n";
        }
        s += "}";
        Logger.controller.formattedList.add(new PrinterToConsole(s));
    }
}


