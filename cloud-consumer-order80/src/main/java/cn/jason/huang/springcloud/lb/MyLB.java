package cn.jason.huang.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * DESC:
 *
 * @author: huangxinquan
 * DATE: 2020/7/29 13:16
 **/
@Component
public class MyLB implements LoadBlance {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement(){
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= 2147483647 ? 0 : current + 1;  // 2147483647 整型最大值
        }while(!this.atomicInteger.compareAndSet(current, next));

        System.out.println("********第几次访问，次数next: " + next);

        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
