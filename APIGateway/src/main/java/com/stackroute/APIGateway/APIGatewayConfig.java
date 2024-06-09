package com.stackroute.APIGateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class APIGatewayConfig {
@Bean
public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
return builder.routes()
.route("UserService-MS", b -> b.path("/api/users/**")
.uri("http://localhost:8080"))
.route("Authentication-MS", r -> r.path("/api/v1.0/authentication/**")
.uri("http://localhost:8081"))
.route("StockAPI-MS", r -> r.path("/api/v1.0/stocks/**")
.uri("http://localhost:8082"))
.route("FavoriteStocks-MS", r -> r.path("/wishlist/**")
.uri("http://localhost:8083"))
.build();
}
}