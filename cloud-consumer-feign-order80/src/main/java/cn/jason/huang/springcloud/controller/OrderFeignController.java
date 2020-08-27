package cn.jason.huang.springcloud.controller;

import cn.jason.huang.springcloud.entities.CommonResult;
import cn.jason.huang.springcloud.entities.Payment;
import cn.jason.huang.springcloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * DESC:
 *
 * @author: huangxinquan
 * DATE: 2020/7/30 13:28
 **/
@RestController
public class OrderFeignController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return paymentFeignService.create(payment);
    }

    @GetMapping("/consumer/payment/feign/timeout")
    public String paymentFeignTimeout(){
        /*
            feign-ribbon，客户端一般默认等待 1 秒钟
         */
        return paymentFeignService.paymentFeignTimeout();
    }
}
