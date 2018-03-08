package com.acme.edu.message;

import com.acme.edu.formatter.Formatter;

/**
 * Created by Trofim Moshik on 03.03.2018.
 *
 * Интерфейс обработчиков сообщений.
 */
public abstract class Message {
    public boolean needToFlushAndAccumulate(Message msg) {
        return true;
    }

    public abstract String getStringToPrint(Formatter formatter);

    public abstract <T> T getValue();
}
