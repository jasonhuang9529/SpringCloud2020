package cn.jason.huang.springcloud.alibaba.controller;

import cn.jason.huang.springcloud.alibaba.domain.CommonResult;
import cn.jason.huang.springcloud.alibaba.domain.Order;
import cn.jason.huang.springcloud.alibaba.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * DESC:
 *
 * @author: huangxinquan
 * DATE: 2020/8/25 16:36
 **/
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult<Order> create(Order order){
        orderService.create(order);
        return new CommonResult<>(200, "订单创建成功");
    }
}
