package com.acme.edu.message;

import com.acme.edu.formatter.Formatter;

/**
 * Created by Trofim Moshik on 04.03.2018.
 *
 * Форматтер символов.
 */
public class CharMessage extends Message {
    private Character value;

    public CharMessage(char value) {
        this.value = value;
    }

    @Override
    public Character getValue() {
        return value;
    }

    @Override
    public String getStringToPrint(Formatter formatter) {
        return formatter.getFormatString(this);
    }
}
