package com.acme.edu.states;

import com.acme.edu.decorators.Decorator;

public abstract class State {
    protected Decorator prevDecorator;

    /**
     * Print message to log
     *
     * @param msg print parameter
     */
    abstract void log(String msg, Decorator decor) ;

    /**
     * Flush in order to print buffer result to log
     */
    public abstract void flush() ;

    public State switchState(State newState, String message, Decorator decor) {
        if (this != newState) {
            this.flush();
        }
        prevDecorator = decor;
        newState.log(message, decor);
        return newState;
    }

}
