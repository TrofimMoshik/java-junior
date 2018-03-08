package com.acme.edu.formatter;

import com.acme.edu.message.*;

/**
 * Created by Trofim Moshik on 08.03.2018.
 */
public interface Formatter {
    String getFormatString(IntegerMessage integerMessage);

    String getFormatString(ByteMessage byteMessage);

    String getFormatString(CharMessage charMessage);

    String getFormatString(StringMessage stringMessage);

    String getFormatString(BoolMessage boolMessage);

    String getFormatString(ObjMessage objMessage);

    String getFormatString(ArrMessage arrMessage);

    String getFormatString(MatrMessage matrMessage);

    String getFormatString(MultiMatrMessage multiMatrMessage);

    String getFormatString(StrVarArgMessage strVarArgMessage);
}
