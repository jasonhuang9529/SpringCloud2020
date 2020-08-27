package cn.jason.huang.springcloud.service.impl;

import cn.jason.huang.springcloud.dao.PaymentDao;
import cn.jason.huang.springcloud.entities.Payment;
import cn.jason.huang.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * DESC:
 *
 * @author: huangxinquan
 * DATE: 2020/7/23 17:23
 **/
@Service
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
