package com.acme.edu.message;

import com.acme.edu.formatter.Formatter;

/**
 * Created by Trofim Moshik on 04.03.2018.
 */
public class BoolMessage extends Message {
    private boolean value;

    public BoolMessage(boolean value) {
        this.value = value;
    }

    @Override
    public Boolean getValue() {
        return value;
    }

    @Override
    public String getStringToPrint(Formatter formatter) {
        return formatter.getFormatString(this);
    }
}
