package cn.jason.huang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * DESC:
 *
 * @author: huangxinquan
 * DATE: 2020/7/27 17:06
 **/
@SpringBootApplication
@EnableDiscoveryClient  //该注解用于向 consul 或者 zookeeper 作为注册中心时注册服务
public class PaymentMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class, args);
    }
}
