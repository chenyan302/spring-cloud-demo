package com.forezp;

import com.forezp.config.FeignConfig;
import com.forezp.config.OAuth2ClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "service-hi",configuration = OAuth2ClientConfig.class)//加入服务器名，不区分大小写
//@FeignClient(value = "service-hi",fallback = TestHystrix.class)//Feign封装了所有方法的熔断方法，Hystrix支持fallback的概念，在FeignClien中指定
public interface TestFeign {

    @RequestMapping("/hi")//这里的请求路径需要和eureka-client中的请求路径一致
    String home(@RequestParam String name);//这里的方法名需要和eureka-client中的方法名一致
}
