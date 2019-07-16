package com.forezp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {
    @Autowired
    TestFeign testFeign;
    @RequestMapping(value = "/hi")
    // 浏览器访问 http://192.168.0.119:8765/hi?name=123
    public String home(@RequestParam String name){
        return testFeign.home(name);
    }
}

