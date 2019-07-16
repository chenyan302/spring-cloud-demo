package com.forezp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class ServerRibbonApplication {

    @Bean
    @LoadBalanced
    RestTemplate restTemplate()
    {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(ServerRibbonApplication.class, args);
    }

    /*@Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/hello")
    public String hello(@RequestParam String name)
    {
        return restTemplate.getForObject("http://SERVICE-HI/hi?name=" + name, String.class);
    }*/
}
