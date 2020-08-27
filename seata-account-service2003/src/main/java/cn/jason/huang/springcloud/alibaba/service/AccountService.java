package cn.jason.huang.springcloud.alibaba.service;

import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * DESC:
 *
 * @author: huangxinquan
 * DATE: 2020/8/26 13:53
 **/
public interface AccountService {

    void decrease(Long userId, BigDecimal money);

}
