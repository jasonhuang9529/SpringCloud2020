package cn.jason.huang.springcloud.alibaba.service;

import cn.jason.huang.springcloud.entities.CommonResult;
import cn.jason.huang.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * DESC:
 *
 * @author: huangxinquan
 * DATE: 2020/8/24 11:09
 **/
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(44444, "服务降级返回，----PaymentFallbackService", new Payment(id, "errorSerial"));
    }
}
