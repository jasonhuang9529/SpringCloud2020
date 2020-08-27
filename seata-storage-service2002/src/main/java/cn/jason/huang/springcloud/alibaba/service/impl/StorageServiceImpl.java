package cn.jason.huang.springcloud.alibaba.service.impl;

import cn.jason.huang.springcloud.alibaba.dao.StorageDao;
import cn.jason.huang.springcloud.alibaba.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * DESC:
 *
 * @author: huangxinquan
 * DATE: 2020/8/26 11:33
 **/
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("--------> storage-service 中扣减库存开始 <---------");
        storageDao.decrease(productId, count);
        log.info("--------> storage-service 中扣减库存结束 <---------");
    }
}
