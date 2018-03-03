package com.acme.edu.printer;


    public interface Printer {
        /**
         * Print message to log
         *
         * @param message print parameter
         */
        void log(String message) ;

        void flush() ;
    }

