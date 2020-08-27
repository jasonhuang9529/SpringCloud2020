package cn.jason.huang.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * DESC:
 *
 * @author: huangxinquan
 * DATE: 2020/7/29 11:55
 **/
@Configuration
public class MySelfRule {

    @Bean
    public IRule getRule(){
        //定义为随机
        return new RandomRule();
    }
}
