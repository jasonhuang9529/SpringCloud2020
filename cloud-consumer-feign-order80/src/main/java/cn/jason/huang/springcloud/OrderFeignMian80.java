package cn.jason.huang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * DESC:
 *
 * @author: huangxinquan
 * DATE: 2020/7/30 11:50
 **/
@SpringBootApplication
@EnableFeignClients //使用  Feign
public class OrderFeignMian80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMian80.class, args);
    }
}
