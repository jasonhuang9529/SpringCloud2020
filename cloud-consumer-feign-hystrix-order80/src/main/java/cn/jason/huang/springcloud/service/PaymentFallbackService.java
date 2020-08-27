package cn.jason.huang.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * DESC:
 *
 * @author: huangxinquan
 * DATE: 2020/7/31 14:17
 **/
@Component
public class PaymentFallbackService implements PaymentHystrixService {

    @Override
    public String paymentInfo_OK(Integer id) {
        return "----PaymentFallbackService,paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "----PaymentFallbackService,paymentInfo_TimeOut";
    }

}
