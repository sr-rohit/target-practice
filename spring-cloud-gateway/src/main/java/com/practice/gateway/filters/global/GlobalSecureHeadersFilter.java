package com.practice.gateway.filters.global;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.filter.factory.SecureHeadersGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.SecureHeadersProperties;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.logging.Level;
import java.util.logging.LogManager;

@Component
public class GlobalSecureHeadersFilter implements GlobalFilter {

    public static final Logger LOGGER = LoggerFactory.getLogger(GlobalSecureHeadersFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        long startTime = System.currentTimeMillis();
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            String logLine = exchange.getRequest().getMethod().toString() + " -- " +
                    exchange.getRequest().getPath() + " -- " +
                    exchange.getRequest().getHeaders() + " -- " +
                    exchange.getResponse().getHeaders() + " -- " +
                    exchange.getResponse().getStatusCode().value() + " -- " +
                    (System.currentTimeMillis() - startTime);
            LOGGER.error(logLine);
        }));
    }
}
