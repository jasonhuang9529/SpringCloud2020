package cn.jason.huang.springcloud.alibaba.service;

import cn.jason.huang.springcloud.entities.CommonResult;
import cn.jason.huang.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * DESC: Feign 接口
 *
 * @author: huangxinquan
 * DATE: 2020/8/24 10:40
 **/
@FeignClient(value = "nacos-payment-provider", fallback = PaymentFallbackService.class)
public interface PaymentService {

    @GetMapping("/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}
