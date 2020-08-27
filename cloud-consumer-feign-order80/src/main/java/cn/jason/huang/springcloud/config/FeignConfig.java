package cn.jason.huang.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * DESC: Feign 配置类
 *
 * @author: huangxinquan
 * DATE: 2020/7/30 16:11
 **/
@Configuration
public class FeignConfig {

    /**
     * 配置 Feign 的日志级别
     * @return
     */
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
