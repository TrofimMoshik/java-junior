package com.acme.edu.message;

import com.acme.edu.formatter.Formatter;

/**
 * Created by Trofim Moshik on 04.03.2018.
 */
public class ArrMessage extends Message {
    private int[] value;

    public ArrMessage(int[] value) {
        this.value = value;
    }

    @Override
    public int[] getValue() {
        return value;
    }

    @Override
    public String getStringToPrint(Formatter formatter) {
        return formatter.getFormatString(this);
    }
}
