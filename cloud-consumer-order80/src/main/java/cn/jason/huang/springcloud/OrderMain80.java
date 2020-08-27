package cn.jason.huang.springcloud;

import cn.jason.huang.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import javax.naming.Name;

/**
 * DESC:
 *
 * @author: huangxinquan
 * DATE: 2020/7/24 11:33
 **/
@SpringBootApplication
@EnableEurekaClient
// 访问 CLOUD-PAYMENT-SERVICE 服务，使用自定的负载均衡规则
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MySelfRule.class)
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }
}
