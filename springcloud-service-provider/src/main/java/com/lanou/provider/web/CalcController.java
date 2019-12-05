package com.lanou.provider.web;


import com.lanou.provider.service.CalcServiceImpl;
import com.lanou.provider.utils.ResponseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/calc")
public class CalcController {
    @Autowired
    private CalcServiceImpl calcService;
    @RequestMapping("/add/{num1}/{num2}")
    public ResponseInfo add(@PathVariable int num1,@PathVariable int num2){
       int result =    calcService.add(num1,num2);
        Map<String, Object> data = new HashMap<>();
        data.put("num1",num1);
        data.put("num2",num2);
        data.put("operator","+");
        data.put("result",result);
        return  new ResponseInfo(200,"请求成功",data);
    }

}
