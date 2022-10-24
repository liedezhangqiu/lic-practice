package cn.lic.microservice.gateway.filter;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;

import java.net.URI;


@Component
public class HeaderFilter implements GlobalFilter { //GlobalFilter {  //GlobalFilter {

    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("access in HeaderFilter, and do filter ...");
        HttpHeaders httpHeaders = exchange.getRequest().getHeaders();
        logger.info("headers ：" + JSON.toJSONString(httpHeaders));
        if (httpHeaders.containsKey("User-Agent")) {
            logger.info("User-Agent : {}", httpHeaders.get("User-Agent"));
            URI uri = exchange.getRequest().getURI();
            logger.info("uri : " + JSON.toJSONString(uri));
            return chain.filter(errorExchange(exchange, uri));
        }

        Mono<Void> mono = null;
        mono = new Mono<Void>() {
            @Override
            public void subscribe(CoreSubscriber actual) {
                Context context = actual.currentContext();
                actual.onComplete();
            }
        };
        return mono;
    }

    private ServerWebExchange errorExchange(ServerWebExchange exchange, URI uri) {
        URI uriNew = UriComponentsBuilder.fromUri(uri).replacePath("/base/bs/ha").build(true).toUri();
        logger.info("uriNew : " + uriNew);
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpRequest requestNew = request.mutate().uri(uriNew).build();
        return exchange.mutate().request(requestNew).build();
    }

}




