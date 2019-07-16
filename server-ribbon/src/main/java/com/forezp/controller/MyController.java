package com.forezp.controller;

import com.forezp.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 调用service层，再调用restTemplate
 */
@Controller
@RequestMapping(value="/myhello")
public class MyController {

    @Autowired
    private HelloService helloService;

    @ResponseBody
    @RequestMapping(value = "/myhi")
    //浏览器访问 http://localhost:8764/myhello/myhi?name=128
    public String sayHello(@RequestParam String name){
        System.out.println(name);
        return helloService.sayHello(name);
        //return restTemplate.getForObject("http://SERVICE-HI/hi?name=123" , String.class);
    }
}
