package cn.jason.huang.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * DESC: 自定义 Gateway 过滤器
 *
 * @author: huangxinquan
 * DATE: 2020/8/7 14:07
 **/
@Component
@Slf4j
public class MyLogGatewayFilter implements GlobalFilter, Ordered {

    /**
     * 过滤逻辑
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("************** come in MyLogGatewayFilter: " + new Date());

        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        if(uname == null){
            log.info("****用户名为 null，非法用户");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }

        log.info("****欢迎用户：" + uname);

        return chain.filter(exchange);
    }

    /**
     * 加载过滤器的顺序
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
