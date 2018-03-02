package com.acme.edu;

/**
 * Created by Trofim Moshik on 02.03.2018.
 */

class Controller {
    Message message = new Message();

    public void choose(Types t) {
        switch (t) {
            case INT:
                message.printToConsole(t);
        }
    }
}
