package com.acme.edu.formatter;

/**
 * Created by Trofim Moshik on 02.03.2018.
 *
 * Перечисление строковых констант.
 */
enum Types {
    PRIM("primitive: "), REF("reference: "), CHAR("char: "), STR("string: "),
    PRIM_ARR("primitives array: "), PRIM_MATR("primitives matrix: "), MULT_MATR("primitives multimatrix: ");

    private String name;

    Types(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
