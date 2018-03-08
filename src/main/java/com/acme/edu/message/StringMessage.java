package com.acme.edu.message;

import com.acme.edu.formatter.Formatter;

/**
 * Created by Trofim Moshik on 04.03.2018.
 *
 * Обработчик строк.
 */
public class StringMessage extends Message {
    private String value;
    private int counter;

    public StringMessage(String value) {
        this.value = value;
        counter = 1;
    }

    @Override
    public String getValue() {
        return value;
    }

    public int getCounter() {
        return counter;
    }

    @Override
    public boolean needToFlushAndAccumulate(Message newMsg) {
        if ("StringMessage".equals(newMsg.getClass().getSimpleName())) {
            if (value.equals(newMsg.getValue().toString())) {
                counter++;
                return false;
            } else {
                return true;
            }
        }
        return true;
    }

    @Override
    public String getStringToPrint(Formatter formatter) {
        return formatter.getFormatString(this);
    }
}
