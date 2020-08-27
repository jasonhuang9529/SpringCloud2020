package cn.jason.huang.springcloud.controller;

import cn.jason.huang.springcloud.entities.CommonResult;
import cn.jason.huang.springcloud.entities.Payment;
import cn.jason.huang.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

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

    @Autowired
    private DiscoveryClient discoveryClient;

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

    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("******** element: " + element);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t"+ instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }

        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(@RequestHeader("X-Request-red") String headerVal, @RequestParam("X-Request-Id") String paramVal){
        System.out.println("通过  Gateway 过滤器添加的请求头信息：X-Request-Id = " + headerVal + "\t, 请求参数为：X-Request-Id = " + paramVal);

        return serverPort;
    }

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout(){
        //暂停几秒钟线程，模拟业务逻辑耗时
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return serverPort;
    }

    @GetMapping("/payment/zipkin")
    public String paymentZipkin(){
        return "Hi i'am paymentzipkin server fall back, welcome to atguigu, O(∩_∩)O哈哈~";
    }
}
