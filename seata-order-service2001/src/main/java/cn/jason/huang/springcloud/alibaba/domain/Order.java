package cn.jason.huang.springcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * DESC: 订单实体类
 *
 * @author: huangxinquan
 * DATE: 2020/8/25 15:10
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private Long id;
    private Long userId;
    private Long productId;
    private Integer count;
    private BigDecimal money;

    /**
     * 订单状态，0：创建中， 1：已完成
     */
    private Integer status;
}
