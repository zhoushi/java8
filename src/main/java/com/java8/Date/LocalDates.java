package com.java8.Date;

/**
 * Created by Administrator on 2016/11/15.
 */

import java.time.LocalDate;

/**
 * 时间日期类
 */
public class LocalDates {

    public LocalDate getLocalDate(){
        //设置当前日期
        LocalDate localDatenow = LocalDate.now();

        //通过时间工厂设置日期
        return LocalDate.of(2014,9,28);
    }
}
