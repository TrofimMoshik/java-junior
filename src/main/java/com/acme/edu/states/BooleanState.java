package com.acme.edu.states;

import com.acme.edu.decorators.Decorator;

public class BooleanState extends State{
    //region constructor

    /**
     * Creates new BooleanState object
     */
    public BooleanState() {

    }
    //endregion

    //region public methods

    /**
     * Print String parameter to log
     *
     * @param msg print parameter
     */
    @Override
    public void log(String msg, Decorator decor) {
        decor.decorate(msg);
    }

    /**
     * Flush log in order to print buffer result
     */
    @Override
    public void flush() {
        /*Do nothing*/
    }
    //endregion
}
