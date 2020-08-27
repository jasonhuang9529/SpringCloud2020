package cn.jason.huang.springcloud.service;

import cn.jason.huang.springcloud.entities.Payment;

/**
 * DESC:
 *
 * @author: huangxinquan
 * DATE: 2020/7/23 17:22
 **/
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(Long id);
}
