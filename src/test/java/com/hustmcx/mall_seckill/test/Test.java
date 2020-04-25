package com.hustmcx.mall_seckill.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

    @org.junit.Test
    public void test01() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startTimeDate = dateFormat.parse("2004-4-4");
        System.out.println(startTimeDate);

    }
}
