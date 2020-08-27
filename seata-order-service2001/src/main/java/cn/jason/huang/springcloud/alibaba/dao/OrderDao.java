package cn.jason.huang.springcloud.alibaba.dao;

import cn.jason.huang.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * DESC:
 *
 * @author: huangxinquan
 * DATE: 2020/8/25 15:34
 **/
@Mapper
public interface OrderDao {

    /** 新建订单 */
    void create(Order order);

    /** 修改订单状态 0 -> 1，将某个用户的订单从 0 改为 1 */
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
