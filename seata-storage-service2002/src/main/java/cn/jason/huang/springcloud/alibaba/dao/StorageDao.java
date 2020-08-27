package cn.jason.huang.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * DESC:
 *
 * @author: huangxinquan
 * DATE: 2020/8/26 11:10
 **/
@Mapper
public interface StorageDao {

    /** 扣减库存 */
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
