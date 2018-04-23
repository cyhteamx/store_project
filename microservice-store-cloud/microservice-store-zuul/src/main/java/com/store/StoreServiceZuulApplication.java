package com.store;

import com.store.filter.MyFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class StoreServiceZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreServiceZuulApplication.class, args);
	}

	@Bean
    public MyFilter tokenFilter() {
        return new MyFilter();
    }
}
