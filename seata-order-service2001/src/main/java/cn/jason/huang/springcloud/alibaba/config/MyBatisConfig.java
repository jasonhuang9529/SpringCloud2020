package cn.jason.huang.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * DESC:
 *
 * @author: huangxinquan
 * DATE: 2020/8/25 16:39
 **/
@Configuration
@MapperScan(basePackages = "cn.jason.huang.springcloud.alibaba.dao")
public class MyBatisConfig {
}
