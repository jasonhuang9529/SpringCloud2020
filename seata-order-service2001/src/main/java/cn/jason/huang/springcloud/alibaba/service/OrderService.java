package cn.jason.huang.springcloud.alibaba.service;

import cn.jason.huang.springcloud.alibaba.domain.Order;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * DESC:
 *
 * @author: huangxinquan
 * DATE: 2020/8/25 15:54
 **/
public interface OrderService {

    void create(Order order);
}
