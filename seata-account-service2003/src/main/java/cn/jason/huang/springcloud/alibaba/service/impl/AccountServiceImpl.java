package cn.jason.huang.springcloud.alibaba.service.impl;

import cn.jason.huang.springcloud.alibaba.dao.AccountDao;
import cn.jason.huang.springcloud.alibaba.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * DESC:
 *
 * @author: huangxinquan
 * DATE: 2020/8/26 13:54
 **/
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("--------> account-service 中扣账户开始 <---------");

        //模拟超时异常，全局事务回滚
//        try {
//            //openFeign 调用的默认时间是1秒
//            TimeUnit.SECONDS.sleep(20);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        accountDao.decrease(userId, money);
        log.info("--------> account-service 中扣账户结束 <---------");
    }
}
