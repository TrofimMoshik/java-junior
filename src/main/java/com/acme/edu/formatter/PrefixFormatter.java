package com.acme.edu.formatter;

import com.acme.edu.message.*;

/**
 * Created by Trofim Moshik on 08.03.2018.
 */
public class PrefixFormatter implements Formatter{
    @Override
    public String getFormatString(IntegerMessage msg) {
        return String.format("%s: %d", PrePostfixes.PRIM.getName(), msg.getValue());
    }

    @Override
    public String getFormatString(ByteMessage msg) {
        return String.format("%s: %d", PrePostfixes.PRIM.getName(), msg.getValue());
    }

    @Override
    public String getFormatString(CharMessage msg) {
        return String.format("%s: %c", PrePostfixes.CHAR.getName(), msg.getValue());
    }

    @Override
    public String getFormatString(StringMessage msg) {
        if (msg.getCounter() == 1) {
            return String.format("%s: %s", PrePostfixes.STR.getName(), msg.getValue());
        } else {
            return String.format("%s: %s (x%d)", PrePostfixes.STR.getName(), msg.getValue(), msg.getCounter());
        }
    }

    @Override
    public String getFormatString(BoolMessage msg) {
        return String.format("%s: %s", PrePostfixes.PRIM.getName(), msg.getValue().toString());
    }

    @Override
    public String getFormatString(ObjMessage msg) {
        return String.format("%s: %s", PrePostfixes.REF.getName(), msg.getValue().toString());
    }

    @Override
    public String getFormatString(ArrMessage arrMessage) {
        String s = PrePostfixes.PRIM_ARR.getName() + ": {";
        for (int i = 0; i < arrMessage.getValue().length; i++) {
            if (i == arrMessage.getValue().length - 1) {
                s += arrMessage.getValue()[i];
            } else {
                s += arrMessage.getValue()[i] + ", ";
            }
        }
        s += "}";
        return s;
    }

    @Override
    public String getFormatString(MatrMessage matrMessage) {
        String s = PrePostfixes.PRIM_MATR.getName() + ": {\r\n";
        for (int i = 0; i < matrMessage.getValue().length; i++) {
            s += "{";
            for (int j = 0; j < matrMessage.getValue()[i].length; j++) {
                if (j == matrMessage.getValue()[i].length - 1) {
                    s += matrMessage.getValue()[i][j];
                } else {
                    s += matrMessage.getValue()[i][j] + ", ";
                }
            }
            s += "}\r\n";
        }
        s += "}";
        return s;
    }

    @Override
    public String getFormatString(MultiMatrMessage multiMatrMessage) {
        String s = PrePostfixes.MULT_MATR.getName() + ": {\r\n";
        for (int i = 0; i < multiMatrMessage.getValue().length; i++) {
            s += "{\r\n";
            for (int j = 0; j < multiMatrMessage.getValue()[i].length; j++) {
                s += "{\r\n";
                for (int k = 0; k < multiMatrMessage.getValue()[i][j].length; k++) {
                    s += "{\r\n";
                    for (int l = 0; l < multiMatrMessage.getValue()[i][j][k].length; l++) {
                        if (l == multiMatrMessage.getValue()[i].length - 1) {
                            s += multiMatrMessage.getValue()[i][j][k][l] + "\r\n";
                        } else {
                            s += multiMatrMessage.getValue()[i][j][k][l] + ", ";
                        }
                    }
                    s += "}\r\n";
                }
                s += "}\r\n";
            }
            s += "}\r\n";
        }
        s += "}\r\n";
        return s;
    }

    @Override
    public String getFormatString(StrVarArgMessage strVarArgMessage) {
        String s = "";
        for (int i = 0; i < strVarArgMessage.getValue().length; i++) {
            s += strVarArgMessage.getValue()[i] + "\r\n";
        }
        return s;
    }
}
