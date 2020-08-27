package cn.jason.huang.springcloud.alibaba.controller;

import cn.jason.huang.springcloud.alibaba.service.PaymentService;
import cn.jason.huang.springcloud.entities.CommonResult;
import cn.jason.huang.springcloud.entities.Payment;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * DESC:
 *
 * @author: huangxinquan
 * DATE: 2020/8/21 15:04
 **/
@RestController
@Slf4j
public class CircleBreakerController {

    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/consumer/fallback/{id}")
//    @SentinelResource(value = "fallback")   //没有配置
//    @SentinelResource(value = "fallback", fallback = "handlerFallback")   //fallback 只负责业务异常
//    @SentinelResource(value = "fallback", blockHandler = "blockHandler")   //blockHandler 只负责 Sentinel 控制台配置违规
//    @SentinelResource(value = "fallback", fallback = "handlerFallback", blockHandler = "blockHandler")   //blockHandler 只负责 Sentinel 控制台配置违规
    @SentinelResource(value = "fallback", fallback = "handlerFallback", blockHandler = "blockHandler",
            exceptionsToIgnore = {IllegalArgumentException.class})   //exceptionsToIgnore 忽略属性
    public CommonResult<Payment> fallback(@PathVariable("id") Long id){
        CommonResult result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/" + id, CommonResult.class, id);
        if(id == 4){
            throw new IllegalArgumentException("IllegalArgumentException，非法参数异常....");
        }else if(result.getData() == null){
            throw new NullPointerException("NullPointerException，该 ID 没有对应记录，空指针异常");
        }

        return result;
    }

    //fallback
    public CommonResult<Payment> handlerFallback(@PathVariable("id") Long id, Throwable e){
        Payment payment = new Payment(id, "null");
        return new CommonResult<>(444, "兜底异常 handlerFallback，exception 内容 " + e.getMessage(), payment);
    }

    //blockHandler
    public CommonResult<Payment> blockHandler(@PathVariable("id") Long id, BlockException blockException){
        Payment payment = new Payment(id, "null");
        return new CommonResult<>(445, "blockHandler-sentinel 限流，无此流水：blockException: " + blockException.getMessage(), payment);
    }

    //==========OpenFeign
    @GetMapping(value = "/consumer/openfeign/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id){
        return paymentService.paymentSQL(id);
    }
}
