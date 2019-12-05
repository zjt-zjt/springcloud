package com.lanou.hystrix.web;


import com.lanou.hystrix.utils.ResponseInfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Controller
@RequestMapping("/calc")
@Slf4j
public class CalcController {
    @Autowired(required = false)
    private RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "addFallBack",commandKey = "calc_add-command")
    @RequestMapping("/add")
    public String add(@RequestParam int num1, @RequestParam int num2, Model model){
        ResponseEntity<ResponseInfo> entity  =  restTemplate.getForEntity("http://service-provider:8086/calc/add/"+num1+"/"+num2, ResponseInfo.class);
       ResponseInfo  info = entity.getBody();
      Map data = (Map) info.getData();
      model.addAttribute("result",data.get("result"));
      model.addAttribute("num1",num1);
      model.addAttribute("num2",num2);
      return "index";

    }


    /**
     *
     * @param num1
     * @param num2
     * @param model
     * @return
     */
    public  String addFallBack(@RequestParam int num1, @RequestParam int num2, Model model){
        model.addAttribute("result","-1");
        model.addAttribute("num1",num1);
        model.addAttribute("num2",num2);
        return "index";
    }

}
