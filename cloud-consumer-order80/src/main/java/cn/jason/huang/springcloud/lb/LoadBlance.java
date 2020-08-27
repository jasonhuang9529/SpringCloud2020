package cn.jason.huang.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * DESC: 自定义负载均衡
 *
 * @author: huangxinquan
 * DATE: 2020/7/29 13:14
 **/
public interface LoadBlance {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
