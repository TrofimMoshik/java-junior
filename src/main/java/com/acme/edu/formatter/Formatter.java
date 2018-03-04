package com.acme.edu.formatter;

/**
 * Created by Trofim Moshik on 03.03.2018.
 *
 * Интерфейс форматтеров.
 */
public interface Formatter {
    void format();
    <T> T getValue();
}
