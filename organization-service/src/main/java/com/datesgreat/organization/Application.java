package com.datesgreat.organization;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SuppressWarnings("unused")
@SpringBootApplication
@EnableEurekaClient
//@EnableEurekaClients
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
