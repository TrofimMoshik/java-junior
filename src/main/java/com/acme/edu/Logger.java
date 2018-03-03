package com.acme.edu;

import com.acme.edu.decorators.PrefixDecorator;
import com.acme.edu.printer.Printer;
import com.acme.edu.printer.SimplePrinter;
import com.acme.edu.states.*;

public class Logger {

    //region public fields
    public static final String LOG_PRIMITIVE = "primitive: ";
    public static final String REFERENCE = "reference: ";
    public static final String LOG_CHAR = "char: ";
    public static final String LOG_STRING = "string: ";
    public static final String PRIMITIVES_ARRAY = "primitives array: ";
    public static final String PRIMITIVES_MATRIX = "primitives matrix: ";
    public static final String PRIMITIVES_MULTIMATRIX = "primitives multimatrix: ";
    public static final String BRACE_OPEN = "{";
    public static final String BRACE_CLOSE = "}";



    //endregion

    //region private fields
    private static State curState = null;
    private static State intState = new IntState();
    private static State stringState = new StringState();
    private static State charState = new CharState();
    private static State boolState = new BooleanState();
    private static State objectState = new ObjectState();
    private State stateStringArray;

    private static Printer[] printers;

    //endregion

    //region constructor

    /**
     * Creates Logger instance
     */
    public Logger() {
        printers = new Printer[]{new SimplePrinter()};
    }

    public Logger(Printer... printers)  {
        if (printers == null || printers.length == 0) {
            System.out.println("There is no printers!!!!");
        }
        this.printers = printers;
    }
    //endregion

    //region public methods



    public static void log(int message)  {
        initState(intState);

            PrefixDecorator decor = new PrefixDecorator(
                    Logger.LOG_PRIMITIVE, printers);
            curState = curState.switchState(intState, String.valueOf(message), decor);

    }

    public static void log(String message, boolean useDecorator)  {
        initState(stringState);

        String prefix = "";
        if (useDecorator) {
            prefix = Logger.LOG_STRING;
        }
            PrefixDecorator decor = new PrefixDecorator(
                    prefix, printers);
            curState = curState.switchState(stringState, message, decor);

    }

    public static void log(String message)  {
        log(message, true);
    }


    public static void log(char message)  {
        initState(charState);

        PrefixDecorator decor = new PrefixDecorator(
                    Logger.LOG_CHAR, printers);

            curState = curState.switchState(charState, String.valueOf(message), decor);

    }

    public static void log(boolean message)  {
        initState(boolState);
        PrefixDecorator decor = new PrefixDecorator(
                    Logger.LOG_PRIMITIVE, printers);
            curState = curState.switchState(boolState, String.valueOf(message), decor);

    }

    public static void log(Object message)  {
        initState(objectState);
        PrefixDecorator decor = new PrefixDecorator(
                Logger.REFERENCE, printers);
        curState = curState.switchState(objectState, String.valueOf(message), decor);

    }


    /**
     * выбивается из общей канвы
     * @param messages
     */
    public static void log(int[] messages)  {


//        initState(intState);
//
//            PrefixDecorator decor = new PrefixDecorator(
//                    Logger.PRIMITIVES_ARRAY, printers);

        String s = "{";
        for (int i = 0; i < messages.length; i++) {
            if (i == messages.length - 1) {
                s += messages[i];
            } else {
                s += messages[i] + ", ";
            }
        }
        s += "}";
        System.out.println(PRIMITIVES_ARRAY+ s);

//            curState = curState.switchState(intState, String.valueOf(sum), decor);
//            curState.flush();

    }

    /**
     * конфликтные условия с верхним тестом
     *
     */

   /* public static void log(int... messages)  {

        long sum = 0;
        initState(intState);

            PrefixDecorator decor = new PrefixDecorator(
                    Logger.LOG_PRIMITIVE, printers);

            for (int message : messages) {
                sum += message;
            }

            curState = curState.switchState(intState, String.valueOf(sum), decor);
            curState.flush();

    }
*/
    /**
     * Проходит тесты, но выбивается из общей канвы
     * при тестах выкидывает
     * java.lang.NumberFormatException: For input string: "{-1, 0, 1}{1, 2, 3}{-1, -2, -3}"
     * @param messages
     */
    public static void log(int[][] messages)  {
//        initState(intState);
//        PrefixDecorator decor = new PrefixDecorator(
//                    Logger.PRIMITIVES_MATRIX, printers);
        StringBuilder str = new StringBuilder();
        putInString(messages, str);
        System.out.println(PRIMITIVES_MATRIX + BRACE_OPEN + str.toString() + "}");
//       curState = curState.switchState(intState, str.toString(), decor);
//       curState.flush();

    }

    /**
     * Проходит тесты, но выбивается из общей канвы
     * @param messages
     */

    public void log(int[][][]... messages)  {
        StringBuilder str = new StringBuilder();
        for (int[][][] matrixThree : messages) {
            str.append(BRACE_OPEN);
            for (int[][] matrix : matrixThree) {
                str.append(BRACE_OPEN);
                putInString(matrix, str);
                str.append(BRACE_CLOSE);
            }
            str.append(BRACE_CLOSE);
        }
        System.out.println(PRIMITIVES_MULTIMATRIX + BRACE_OPEN + str.toString() + "}");

    }




    /**
     * Print string array parameter to log
     *
     * @param messages print parameter
     */

    /**
     * Close log in order to print result
     */
    public void close()  {
            curState.flush();
    }

    //endregion

    private static void putInString(int[][] ints, StringBuilder str) {
        for (int[] array : ints) {
            str.append("{");
            for (int j = 0; j < ints.length; j++) {
                str.append(array[j]);
                if (j != ints.length - 1)
                    str.append(", ");
            }
            str.append(BRACE_CLOSE);
        }
    }

    //region private methods

    private static void initState(State st) {
        if (curState == null) {
            curState = st;
        }
    }
//endregion

}