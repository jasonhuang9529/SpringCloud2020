package cn.jason.huang.springcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * DESC:
 *
 * @author: huangxinquan
 * DATE: 2020/8/26 13:28
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    private Long id;
    /** 用户 id */
    private Long userId;
    /** 总额度 */
    private BigDecimal total;
    /** 已用额度 */
    private BigDecimal used;
    /** 剩余额度 */
    private BigDecimal residue;
}
