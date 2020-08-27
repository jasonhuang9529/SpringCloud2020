package cn.jason.huang.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * DESC:
 *
 * @author: huangxinquan
 * DATE: 2020/8/19 14:03
 **/
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
        return "--------testA";
    }

    @GetMapping("/testB")
    public String testB(){
        log.info(Thread.currentThread().getName() + "\t" + "....testB");
        return "--------testB";
    }

    @GetMapping("/testD")
    public String testD(){
//        try {
//            //暂停1秒钟线程
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        log.info("testD 测试 RT");

        log.info("testD 测试异常比例");
        int age = 10 / 0;

        return "--------testD";
    }

    @GetMapping("/testE")
    public String testE(){
        log.info("testE 测试异常数");
        int age = 10 / 0;
        return "----------testE 测试异常数";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey", fallback = "fallback_testHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2){

        int age = 10 / 0;

        return "----------testHotKey";
    }

    //兜底方法
    public String deal_testHotKey(String p1, String p2, BlockException exception){
        return "---------deal_testHotKey 自定义";  //sentinel 系统默认的提示：Blocked by Sentinel(flow limiting)
    }

    public String fallback_testHotKey(String p1, String p2){
        return "---------fallback_testHotKey";
    }

}
