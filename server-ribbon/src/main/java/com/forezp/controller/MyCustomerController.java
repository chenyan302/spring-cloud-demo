package com.forezp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 * 直接调用restTemplate
 */
@Controller
@RequestMapping(value="/CApi")
public class MyCustomerController {
    @Autowired
    private RestTemplate restTemplate;

    @ResponseBody
    @RequestMapping(value="CgetInfo")
    public String getCINfo() {
        return restTemplate.getForObject("http://SERVICE-HI/hi?name=123" , String.class);
        //return getServiceI()+"\n"+getServiceII();
    }
    private String getServiceI() {
        String info = restTemplate.getForObject("http://SERVICE-HI/hi?name=123" , String.class);
        return info;
    }
    private String getServiceII() {
        String info = restTemplate.getForObject("http://SERVICE-HI/hi?name=456" , String.class);
        return info;
    }
}

