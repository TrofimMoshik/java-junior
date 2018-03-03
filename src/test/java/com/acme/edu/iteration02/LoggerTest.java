package com.acme.edu.iteration02;

import com.acme.edu.Logger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    //region given
    private Logger sp;

    @Before
    public void setUpSystemOut()  {
        tearDown();
        captureSysout();

        sp = new Logger();
    }
    //endregion

    @After
    public void tearDown() {
        resetOut();
    }

    @Test
    public void shouldLogSequentIntegersAsSum() {
        //region when
        sp.log("str 1");
        sp.log(1);
        sp.log(2);
        sp.log("str 2");
        sp.log(0);
        sp.close();
        //endregion

        //region then
        assertSysoutContains("string: str 1");
        assertSysoutContains("primitive: 3");
        assertSysoutContains("string: str 2");
        assertSysoutContains("primitive: 0");
        //endregion
    }

    @Test
    public void shouldLogCorrectlyIntegerOverflowWhenSequentIntegers() {
        //region when
        sp.log("str 1");
        sp.log(10);
        sp.log(Integer.MAX_VALUE);
        sp.log("str 2");
        sp.log(0);
        sp.close();
        //endregion

        //region then
        assertSysoutContains("string: str 1");
        assertSysoutContains("primitive: 10");
        assertSysoutContains("primitive: ");
        assertSysoutContains("string: str 2");
        assertSysoutContains("primitive: 0");
        //endregion
    }

    @Test
    public void shouldLogSameSubsequentStringsWithoutRepeat()  {
        //region when
        sp.log("str 1");
        sp.log("str 2");
        sp.log("str 2");
        sp.log(0);
        sp.log("str 2");
        sp.log("str 3");
        sp.log("str 3");
        sp.log("str 3");
        sp.close();
        //endregion

        //region then
        assertSysoutContains("string: str 1");
        assertSysoutContains("string: str 2 (x2)");
        assertSysoutContains("primitive: 0");
        assertSysoutContains("string: str 2");
        assertSysoutContains("string: str 3 (x3)");
        //endregion
    }
}