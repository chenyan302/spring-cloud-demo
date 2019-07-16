package com.forezp;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class TestHystrix implements TestFeign {

    @Override
    public String home(@RequestParam String name){
        return "hey " + name + ", there is some problem with hi page";
    }
}
