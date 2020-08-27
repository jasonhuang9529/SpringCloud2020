package cn.jason.huang.springcloud.myhandler;

import cn.jason.huang.springcloud.entities.CommonResult;
import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * DESC:
 *
 * @author: huangxinquan
 * DATE: 2020/8/21 11:19
 **/
public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException exception){
        return new CommonResult(4444, "按客户自定义，global handlerException-------1");
    }

    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult(4444, "按客户自定义，global handlerException-------2");
    }
}
