package cn.jason.huang.test;

import org.junit.Test;

import java.time.ZonedDateTime;

/**
 * DESC:
 *
 * @author: huangxinquan
 * DATE: 2020/8/7 10:37
 **/
public class TestDemo1 {

    @Test
    public void testTime(){
        ZonedDateTime zbj = ZonedDateTime.now();  //默认时区
        System.out.println(zbj); //2020-08-07T10:39:31.255+08:00[Asia/Shanghai]
    }
}
