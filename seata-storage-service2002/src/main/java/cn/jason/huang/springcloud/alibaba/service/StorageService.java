package cn.jason.huang.springcloud.alibaba.service;

/**
 * DESC:
 *
 * @author: huangxinquan
 * DATE: 2020/8/26 11:32
 **/
public interface StorageService {

    /**
     * 扣减库存
     * @param productId 商品id
     * @param count 购买数量
     */
    void decrease(Long productId, Integer count);
}
