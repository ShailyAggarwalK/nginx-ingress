package com.mybank.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.web.servlet.function.RequestPredicates.GET;
import static org.springframework.web.servlet.function.RouterFunctions.route;

@SpringBootApplication
public class CustomerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }
}

@Configuration
class Config {
    @Bean
    public RouterFunction<ServerResponse> routerFunction(RequestHandler requestHandler) {
        return route(
                GET("/health"), request -> ServerResponse.ok().body("Customer is healthy")
        ).andRoute(GET("/customer/home"), request -> requestHandler.welcomeCustomer());
    }
}

@Component
class RequestHandler {
    public ServerResponse welcomeCustomer() {
        return ServerResponse.ok().body("Welcome to Customer portal of my-bank");
    }
}