package com.lanou.feignHystrix.web;



import com.lanou.feignHystrix.Client.CalcClient;
import com.lanou.feignHystrix.utils.ResponseInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/calc")
@Slf4j
public class CalcController {
    @Autowired
    private CalcClient calcClient;
    @RequestMapping("/add")
    public String add(@RequestParam int num1, @RequestParam int num2, Model model){
        ResponseInfo add = calcClient.add(num1, num2);
      Map data = (Map) add.getData();
      model.addAttribute("result",data.get("result"));
      model.addAttribute("num1",num1);
      model.addAttribute("num2",num2);
      return "index";

    }
}
