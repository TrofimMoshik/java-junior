package com.acme.edu;

import com.acme.edu.formatter.Formatter;
import com.acme.edu.message.*;
import com.acme.edu.printer.Printer;

/**
 * Created by Trofim Moshik on 02.03.2018.
 *
 * Контроллер. Управление процессом логирования.
 */

public class Controller {
    private Message currentMessage;
    private Printer printer;
    private Formatter formatter;

    public Controller(Printer printer, Formatter formatter) {
        this.printer = printer;
        this.formatter = formatter;
    }

    public void flush(){
        if (currentMessage == null) {
            return;
        }
        printer.print(currentMessage.getStringToPrint(formatter));
        currentMessage = null;
    }

    void handler(Message message) {
        if (currentMessage == null) {
            currentMessage = message;
            return;
        }
        if (currentMessage.needToFlushAndAccumulate(message)) {
            flush();
            currentMessage = message;
        }
    }
}
