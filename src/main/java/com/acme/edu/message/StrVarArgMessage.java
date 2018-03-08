package com.acme.edu.message;

import com.acme.edu.formatter.Formatter;

/**
 * Created by Trofim Moshik on 04.03.2018.
 *
 * Обработчик массива строк.
 */
public class StrVarArgMessage extends Message {
    private String[] value;

    public StrVarArgMessage(String[] value) {
        this.value = value;
    }

    @Override
    public String[] getValue() {
        return value;
    }

    @Override
    public String getStringToPrint(Formatter formatter) {
        return formatter.getFormatString(this);
    }
}
