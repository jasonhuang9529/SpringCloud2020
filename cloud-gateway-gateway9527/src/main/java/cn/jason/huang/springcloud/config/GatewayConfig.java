package cn.jason.huang.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * DESC: Gateway 配置类
 *
 * @author: huangxinquan
 * DATE: 2020/8/6 16:05
 **/
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){

        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        // http://news.baidu.com/guonei
//        RouteLocator path1 = routes.route("path1",
//                r -> r.path("/guonei")
//                        .uri("http://news.baidu.com/guonei"))
//                .build();
//        return path1;

        routes.route("path1",
                r -> r.path("/guonei")
                        .uri("http://news.baidu.com/guonei"))
                .build();

        return routes.build();
    }
}
