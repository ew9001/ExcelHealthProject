package com.excelhealth.mytest_cases;

import org.testng.Reporter;
import org.testng.annotations.Test;


@SuppressWarnings("unused")
public class TestMeNow {


    @Test

    public void PrintMe() throws Exception {

        Reporter.log("=========== This is a test to see if my classes are running ===========", true);
        Reporter.log("====== SUCCESS =====", true);
        Reporter.log("=========== Test is complete ===========", true);

    }

}

