package cn.jason.huang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * DESC:
 *
 * @author: huangxinquan
 * DATE: 2020/8/3 16:42
 **/
@SpringBootApplication
@EnableHystrixDashboard //开启 HystrixDashboard
public class HystrixDashboardMain9001 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardMain9001.class, args);
    }
}
