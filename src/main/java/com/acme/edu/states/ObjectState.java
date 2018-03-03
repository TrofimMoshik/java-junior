package com.acme.edu.states;

import com.acme.edu.decorators.Decorator;

public class ObjectState extends State {
    //region constructor

    /**
     * Creates new ObjectState object
     */
    public ObjectState() {
    }
    //endregion

    //region public methods

    /**
     * Print Object parameter to log
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
