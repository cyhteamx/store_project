package com.store;

//import AccessFilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@EnableFeignClients
//@EnableOAuth2Sso
//@ComponentScan(basePackages = {"com.store.filter", "com.store.*"})
@EnableGlobalMethodSecurity(prePostEnabled = true)
@SpringCloudApplication
//@ComponentScan(basePackages = {"com.store", "com.store.filter"})
public class ZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulApplication.class, args);
	}

	/*@Bean
	public AccessFilter tokenFilter() {
		return new AccessFilter();
	}*/
}

