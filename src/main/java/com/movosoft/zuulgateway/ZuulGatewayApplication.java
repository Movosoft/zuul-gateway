package com.movosoft.zuulgateway;

import com.movosoft.zuulgateway.filter.pre.PreRequestFinderFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulServer
public class ZuulGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulGatewayApplication.class, args);
    }

    @Bean
    public PreRequestFinderFilter preRequestFinderFilter() {
        return new PreRequestFinderFilter();
    }
}
