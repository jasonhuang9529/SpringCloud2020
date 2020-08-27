package cn.jason.huang.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * DESC:
 *
 * @author: huangxinquan
 * DATE: 2020/8/25 15:09
 **/
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)  //取消数据源的自动创建
public class OrderServiceMain2001 {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceMain2001.class, args);
    }
}
