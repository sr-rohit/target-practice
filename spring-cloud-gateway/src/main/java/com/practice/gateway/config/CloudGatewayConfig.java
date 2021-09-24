package com.practice.gateway.config;

import com.practice.gateway.filters.global.GlobalSecureHeadersFilter;
import jdk.nashorn.internal.objects.Global;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.gateway.filter.factory.SecureHeadersGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.headers.RemoveHopByHopHeadersFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import java.util.UUID;
import java.util.function.Consumer;

@Configuration
public class CloudGatewayConfig {

    @Autowired
    @Qualifier("globalSecureHeadersFilter")
    private GlobalSecureHeadersFilter globalSecureHeadersFilter;

    @Autowired
    private RemoveHopByHopHeadersFilter removeHopByHopHeadersFilter;

    @Bean
    public RouteLocator buildGatewayRoutes(RouteLocatorBuilder builder) {

        return builder.routes()
                .route("service-one", route -> route.path("/service-one/**")
                        .and().method(HttpMethod.POST)
                        .filters(filter -> filter.addResponseHeader("x-trace-id", UUID.randomUUID().toString())
                                .filter(removeHopByHopHeadersFilter.filter())
                                .secureHeaders())
                        .uri("http://localhost:10001"))
                .route("service-two", route -> route.path("/service-two/**")
                        .and().method(HttpMethod.GET)
                        .filters(filter -> filter.addResponseHeader("x-trace-id", UUID.randomUUID().toString())
                                .secureHeaders(config -> new SecureHeadersGatewayFilterFactory.Config()))
                        .uri("http://localhost:10002"))
                .build();
    }
}
