package com.lanou.feign.client;

import com.lanou.feign.utils.ResponseInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("service-provider")
@RequestMapping("/calc")
public interface CalcClient {
    @GetMapping("/add/{num1}/{num2}")
        // 注意：这里的@PathVariable注解中的参数无论方法变量名称和访问URL中的占位符名称是否一样都不能省略
    ResponseInfo add(@PathVariable("num1") int num1,@PathVariable("num2") int num2);
}
