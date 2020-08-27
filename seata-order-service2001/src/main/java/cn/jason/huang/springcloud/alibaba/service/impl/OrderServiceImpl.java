package cn.jason.huang.springcloud.alibaba.service.impl;

import cn.jason.huang.springcloud.alibaba.dao.OrderDao;
import cn.jason.huang.springcloud.alibaba.domain.Order;
import cn.jason.huang.springcloud.alibaba.service.AccountService;
import cn.jason.huang.springcloud.alibaba.service.OrderService;
import cn.jason.huang.springcloud.alibaba.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * DESC:
 *
 * @author: huangxinquan
 * DATE: 2020/8/25 15:55
 **/
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private StorageService storageService;

    @Autowired
    private AccountService accountService;

    /**
     * 下订单 --> 减库存 --> 扣钱 --> 修改订单状态
     * @param order
     */
    @Override
    @GlobalTransactional(name = "fsp-create-order", rollbackFor = Exception.class) //name 随便，只要不冲突就行；
    public void create(Order order) {
        //1、新建订单
        log.info("-----> 开始新建订单<-----");
        orderDao.create(order);

        //2、扣减库存
        log.info("-----> 订单微服务调用库存，做扣减 count <-----");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("-----> 订单微服务调用库存，做扣减 count end<-----");

        //3、扣减账户的钱
        log.info("-----> 订单微服务调用账户，做扣减 money<-----");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("-----> 订单微服务调用账户，做扣减 money end<-----");

        //4、修改订单状态，从 0 -> 1，1代表已完成
        log.info("-----> 修改订单状态开始 <-----");
        orderDao.update(order.getUserId(), 0);
        log.info("-----> 修改订单状态结束 <-----");

        log.info("-----> 下订单结束，O(∩_∩)O哈哈~ <-----");
    }
}
