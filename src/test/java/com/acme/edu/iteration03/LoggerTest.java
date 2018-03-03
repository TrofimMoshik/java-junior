package com.acme.edu.iteration03;

import com.acme.edu.Logger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    private Logger sp;

    //region given
    @Before
    public void setUpSystemOut() throws IOException {
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
    public void shouldLogIntegersArray()  {
        //region when
        sp.log(new int[]{-1, 0, 1});
        //endregion

        //region then
        assertSysoutContains("primitives array: {-1, 0, 1}");
        //endregion
    }

    @Test
    public void shouldLogIntegersMatrix()  {
        //region when
        sp.log(new int[][]{{-1, 0, 1}, {1, 2, 3}, {-1, -2, -3}});
        //endregion

        //region then
        assertSysoutContains("primitives matrix: {"  );
        assertSysoutContains("{-1, 0, 1}"  );
        assertSysoutContains("{1, 2, 3}"  );
        assertSysoutContains("{-1, -2, -3}"  );
        assertSysoutContains("}"  );
        //endregion
    }

    @Test
    public void shouldLogIntegersMulitidimentionalArray()  {


        //region when
        sp.log(new int[][][][]{{{{0}}}});
        //endregion

        //region then

                assertSysoutContains("primitives multimatrix: {");
                assertSysoutContains("{" + "{" + "{");
                assertSysoutContains("0");
                assertSysoutContains("}" + "}" + "}");
                assertSysoutContains("}");
        //endregion
    }

//    @Test
//    public void shouldLogStringsWithOneMethodCall()  {
//        //region when
//        sp.log("str1", "string 2", "str 3");
//        //endregion
//
//        //region then
//        assertSysoutContains("str1\nstring 2\nstr 3");
//        //endregion
//    }

//    @Test
//    public void shouldLogIntegersWithOneMethodCall()  {
//        //region when
//        sp.log(-1, 0, 1, 3);
//        //endregion
//
//        //region then
//        assertSysoutContains("3");
//        //endregion
//    }

//    @Test
//    public void shouldCorrectDealWithIntegerOverflowWhenOneMethodCall()  {
//        //region when
//        sp.log(1);
//        sp.log("str");
//        sp.log(Integer.MAX_VALUE - 10);
//        sp.log(11);
//        sp.close();
//        //endregion
//
//        //region then
//        assertSysoutContains(1);
//        assertSysoutContains("str");
//        assertSysoutContains(Integer.MAX_VALUE - 10);
//        assertSysoutContains(11);
//        //endregion
//    }

}