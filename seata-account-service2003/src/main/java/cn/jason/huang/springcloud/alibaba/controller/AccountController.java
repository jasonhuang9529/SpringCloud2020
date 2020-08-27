package cn.jason.huang.springcloud.alibaba.controller;

import cn.jason.huang.springcloud.alibaba.domain.CommonResult;
import cn.jason.huang.springcloud.alibaba.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * DESC:
 *
 * @author: huangxinquan
 * DATE: 2020/8/26 13:58
 **/
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/account/decrease")
    public CommonResult decrease(Long userId, BigDecimal money){
        accountService.decrease(userId, money);
        return new CommonResult(200, "account-service 扣减账户余额成功！");
    }
}
