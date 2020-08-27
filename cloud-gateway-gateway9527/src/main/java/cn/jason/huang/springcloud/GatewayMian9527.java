package cn.jason.huang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * DESC:
 *
 * @author: huangxinquan
 * DATE: 2020/8/6 15:28
 **/
@SpringBootApplication
@EnableEurekaClient
public class GatewayMian9527 {
    public static void main(String[] args) {
        SpringApplication.run(GatewayMian9527.class, args);
    }
}
