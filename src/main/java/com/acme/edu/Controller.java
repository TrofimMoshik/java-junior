package com.acme.edu;

import com.acme.edu.formatter.*;
import com.acme.edu.printer.Printer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Trofim Moshik on 02.03.2018.
 *
 * Контроллер. Хранит список входных параметров, список отформатированных строк.
 * Отвечает за flush(). Передает входные параметры на форматирование и отформатированные строки
 * на печать.
 */

public class Controller {
    public List<Formatter> list = new ArrayList<Formatter>();
    public List<Printer> formattedList = new ArrayList<Printer>();

    void flush() {
        if (list.size() == 0) return;

        for (Formatter f : list) {
            f.format();
        }

        for (Printer p : formattedList) {
            p.print();
        }

        list = new ArrayList<Formatter>();
    }

    private <T> boolean checkType(T t) {
        if (list.size() == 0) return false;
        else if ((list.get(list.size() - 1).
                                    getValue().
                                        getClass().
                                            getSimpleName()).
                                                equals(t.getClass().
                                                            getSimpleName())) return true;
             else return false;
    }

    void add(int message) {
        if (this.checkType(message)) {
            int b = list.get(0).getValue();
            if ((long) b + message >= Integer.MAX_VALUE) {
                list.set(0, new IntegerFormatter(message));
                list.add(new IntegerFormatter(b));
                this.flush();
            } else {
                list.set(0, new IntegerFormatter(message + b));
            }
        } else {
            this.flush();
            list.add(new IntegerFormatter(message));
        }
    }

    void add(String message) {
        if (this.checkType(message)) {
            if (message.equals(list.get(list.size() - 1).getValue())) {
                list.add(new StringFormatter(message));
            } else {
                this.flush();
                list.add(new StringFormatter(message));
            }
        } else {
            this.flush();
            list.add(new StringFormatter(message));
        }
    }

    void add(byte message) {
        this.flush();
        list.add(new ByteFormatter(message));
        this.flush();
    }

    void add(char message) {
        this.flush();
        list.add(new CharFormatter(message));
        this.flush();
    }

    public void add(boolean message) {
        this.flush();
        list.add(new BoolFormatter(message));
        this.flush();
    }

    public void add(Object message) {
        this.flush();
        list.add(new ObjFormatter(message));
        this.flush();
    }

    public void add(int... message) {
        this.flush();
        list.add(new ArrFormatter(message));
        this.flush();
    }

    public void add(int[][] message) {
        this.flush();
        list.add(new MatrFormatter(message));
        this.flush();
    }

    public void add(int[][][][] message) {
        this.flush();
        list.add(new MultiMatrFormatter(message));
        this.flush();
    }

    public void add(String... message) {
        this.flush();
        list.add(new StrVarArgFormatter(message));
        this.flush();
    }
}
