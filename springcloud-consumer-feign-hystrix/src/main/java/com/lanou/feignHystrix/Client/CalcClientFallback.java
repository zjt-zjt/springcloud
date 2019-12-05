package com.lanou.feignHystrix.Client;

import com.lanou.feignHystrix.utils.ResponseInfo;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Component
@RequestMapping("fallback")
public class CalcClientFallback implements CalcClient {
    @Override
    public ResponseInfo add(int num1, int num2) {
        Map data = new HashMap();
        data.put("num1", num1);
        data.put("num2", num2);
        data.put("result", -1);
        ResponseInfo responseInfo = new ResponseInfo(203,  "降级结果", data);
        return responseInfo;
    }
}
