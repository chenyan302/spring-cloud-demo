package com.forezp.service.impl;

import com.forezp.service.HelloService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    private RestTemplate restTemplate;

    public String hiError(String name)
    {
        return "hey " +
                name + ", there is some problem with hi page";
    }

    // 断路器配置，当无法调用如下方法时，就会调用自定的hiError方法。
    @HystrixCommand(fallbackMethod = "hiError")
    public String sayHello(String name) {
        //调用生产者的服务返回信息
        return restTemplate.getForObject("http://SERVICE-HI/hi?name="+name, String.class);
    }



}
