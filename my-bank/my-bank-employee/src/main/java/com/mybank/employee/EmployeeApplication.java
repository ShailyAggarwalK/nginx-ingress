package com.mybank.employee;

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
public class EmployeeApplication {
	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}
}

@Configuration
class Config {
	@Bean
	public RouterFunction<ServerResponse> routerFunction(RequestHandler requestHandler) {
		return route(
				GET("/health"), request -> ServerResponse.ok().body("Employee is healthy")
		).andRoute(GET("/employee/home"), request -> requestHandler.welcomeEmployee());
	}
}

@Component
class RequestHandler {
	public ServerResponse welcomeEmployee() {
		return ServerResponse.ok().body("Welcome to Employee portal of my-bank");
	}
}