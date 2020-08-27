package cn.jason.huang.springcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DESC:
 *
 * @author: huangxinquan
 * DATE: 2020/8/26 11:06
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {

    private Long id;
    /** 商品 id */
    private Long productId;
    /** 总库存 */
    private Integer total;
    /** 已用库存 */
    private Integer used;
    /** 剩余库存 */
    private Integer residue;
}
