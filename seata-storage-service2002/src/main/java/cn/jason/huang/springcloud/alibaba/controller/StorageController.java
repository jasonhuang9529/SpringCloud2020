package cn.jason.huang.springcloud.alibaba.controller;

import cn.jason.huang.springcloud.alibaba.domain.CommonResult;
import cn.jason.huang.springcloud.alibaba.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * DESC:
 *
 * @author: huangxinquan
 * DATE: 2020/8/26 11:36
 **/
@RestController
public class StorageController {

    @Autowired
    private StorageService storageService;

    @PostMapping("/storage/decrease")
    public CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count){
        storageService.decrease(productId, count);
        return new CommonResult(200, "Storage Service 扣减库存成功！");
    }
}
