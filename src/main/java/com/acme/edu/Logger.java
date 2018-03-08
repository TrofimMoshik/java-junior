package com.acme.edu;

import com.acme.edu.formatter.PrefixFormatter;
import com.acme.edu.message.*;
import com.acme.edu.printer.PrinterToConsole;

/**
 * Фасад логгера сообщений различных типов.
 * @author Moshik, Malyshev
 */
public class Logger {
    public static Controller controller = new Controller(new PrinterToConsole(), new PrefixFormatter());

    public static void flush() {
        controller.flush();
    }

    public static void log(int message) {
        controller.handler(new IntegerMessage(message));
    }

    public static void log(byte message) {
        controller.handler(new ByteMessage(message));
    }

    public static void log(char message) {
        controller.handler(new CharMessage(message));
    }

    public static void log (String message) {
        controller.handler(new StringMessage(message));
    }

    public static void log(boolean message) {
        controller.handler(new BoolMessage(message));
    }

    public static void log(Object message) {
        controller.handler(new ObjMessage(message));
    }

    public static void log(int... message) {
        controller.handler(new ArrMessage(message));
    }

    public static void log(int[][] message) {
        controller.handler(new MatrMessage(message));
    }

    public static void log(int[][][][] message) {
        controller.handler(new MultiMatrMessage(message));
    }

    public static void log(String... message) {
        controller.handler(new StrVarArgMessage(message));
    }
}
