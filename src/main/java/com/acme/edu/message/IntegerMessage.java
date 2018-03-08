package com.acme.edu.message;

import com.acme.edu.formatter.Formatter;

/**
 * Created by Trofim Moshik on 03.03.2018.
 *
 * Исполнитель-обработчик целых чисел.
 */
public class IntegerMessage extends Message {
    private Integer value;

    public IntegerMessage(Integer value) {
        this.value = value;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public boolean needToFlushAndAccumulate(Message newMessage) {
        if ("IntegerMessage".equals(newMessage.getClass().getSimpleName())) {
            if ((long) value + (Integer) newMessage.getValue() >= Integer.MAX_VALUE) {
                return true;
            } else {
                value += (Integer) newMessage.getValue();
            }
            return false;
        }
        return true;
    }

    @Override
    public String getStringToPrint(Formatter formatter) {
        return formatter.getFormatString(this);
    }
}
