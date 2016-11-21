package com.test.util;

import com.java8.util.JsonUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/21.
 */
public class UtilsTest {



    @Test
    public void toJsonTest() throws IllegalAccessException, InstantiationException {
        SBean sBean = new SBean();
        sBean.setName("zhou");
        sBean.setAge(18);
        SBean sBean1 = new SBean();

        sBean1.setName("yun");
        sBean1.setAge(19);
        List<SBean> lists = new ArrayList<>();
        lists.add(sBean);
        lists.add(sBean1);

        JsonUtils.toJsonString(lists).toString();
        System.out.println(JsonUtils.toJsonString(lists).toString());
    }
}
