package com.example.gatewayYsfi2;

//import org.keycloak.adapters.springsecurity.client.KeycloakClientRequestFactory;
//import org.keycloak.adapters.springsecurity.client.KeycloakRestTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args ) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Bean
	DiscoveryClientRouteDefinitionLocator definitionLocator(ReactiveDiscoveryClient rdc,
														DiscoveryLocatorProperties dlp){

		return new DiscoveryClientRouteDefinitionLocator(rdc,dlp);

	}

//	@Bean
//	RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
//
//		return builder.routes()
//
//				.route(r -> r.path("/customers/**").uri("http://localhost:8081/").id("r1"))
//				.route(r -> r.path("/products/**").uri("http://localhost:8082/").id("r2"))
//				.build();
//
//	}



}