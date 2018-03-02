package com.acme.edu;

/**
 * Created by Trofim Moshik on 02.03.2018.
 */
class TypeDefinition {
    Types checkType(int mes) {
        return Types.INT;
    }
    Types checkType(int[] mes) {
        return Types.INTARR;
    }
    Types checkType(int[][] mes) {
        return Types.INTMATR;
    }
    Types checkType(byte mes) {
        return Types.BYTE;
    }
    Types checkType(Object mes) {
        return Types.OBJECT;
    }
    Types checkType(boolean mes) {
        return Types.BOOL;
    }
    Types checkType(String mes) {
        return Types.STRING;
    }
    Types checkType(char mes) {
        return Types.CHAR;
    }

}
