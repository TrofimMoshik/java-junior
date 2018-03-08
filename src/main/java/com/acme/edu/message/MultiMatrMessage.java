package com.acme.edu.message;

import com.acme.edu.formatter.Formatter;

/**
 * Created by Trofim Moshik on 04.03.2018.
 *
 * Обработчик четырехмерной матрицы.
 */
public class MultiMatrMessage extends Message {
    private int[][][][] value;

    public MultiMatrMessage(int[][][][] value) {
        this.value = value;
    }

    @Override
    public int[][][][] getValue() {
        return value;
    }

    @Override
    public String getStringToPrint(Formatter formatter) {
        return formatter.getFormatString(this);
    }
}


