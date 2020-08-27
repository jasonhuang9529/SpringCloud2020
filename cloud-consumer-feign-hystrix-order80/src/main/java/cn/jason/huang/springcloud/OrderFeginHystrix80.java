package cn.jason.huang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * DESC:
 *
 * @author: huangxinquan
 * DATE: 2020/7/31 11:30
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
public class OrderFeginHystrix80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderFeginHystrix80.class, args);
    }
}
