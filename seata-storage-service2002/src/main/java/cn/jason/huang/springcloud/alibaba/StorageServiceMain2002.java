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
 * DATE: 2020/8/26 11:05
 **/
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class StorageServiceMain2002 {

    public static void main(String[] args) {
        SpringApplication.run(StorageServiceMain2002.class, args);
    }

}
