package cn.jason.huang.springcloud.controller;

import cn.jason.huang.springcloud.dao.PaymentDao;
import cn.jason.huang.springcloud.entities.CommonResult;
import cn.jason.huang.springcloud.entities.Payment;
import cn.jason.huang.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * DESC:
 *
 * @author: huangxinquan
 * DATE: 2020/7/23 17:29
 **/
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){

        int result = paymentService.create(payment);
        log.info("*****插入结果：" + result);

        if(result > 0){
            return new CommonResult(200, "插入数据库成功,serverPort:" + serverPort, payment);
        }else{
            return new CommonResult(444, "插入数据失败");
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){

        Payment payment = paymentService.getPaymentById(id);
        log.info("*****查询结果：" + payment);

        if(payment != null){
            return new CommonResult<Payment>(200,"查询成功！serverPort:" + serverPort,payment);
        }else{
            return new CommonResult<Payment>(444,"没有对应记录，查询 ID:" + id,null);
        }
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }
}
