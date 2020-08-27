package cn.jason.huang.springcloud.dao;

import cn.jason.huang.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * DESC:
 *
 * @author: huangxinquan
 * DATE: 2020/7/23 17:05
 **/
@Mapper
public interface PaymentDao {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
