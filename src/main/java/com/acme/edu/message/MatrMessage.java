package com.acme.edu.message;

import com.acme.edu.formatter.Formatter;

/**
 * Created by Trofim Moshik on 04.03.2018.
 *
 * Обработчик двумерной матрицы.
 */
public class MatrMessage extends Message {
    private int[][] value;

    public MatrMessage(int[][] value) {
        this.value = value;
    }

    @Override
    public int[][] getValue() {
        return value;
    }

    @Override
    public String getStringToPrint(Formatter formatter) {
        return formatter.getFormatString(this);
    }
}
