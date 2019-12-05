package com.lanou.provider.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.stereotype.Service;

import java.util.Random;


@Slf4j
@Service
public class CalcServiceImpl {
    @Autowired
    private Registration registration;

    public int add(int num1,int num2){
     String    serviceInfo =  registration.getHost()+"-"+registration.getInstanceId();

     log.info(serviceInfo+"->" + num1 + "+" + num2 + "=" + (num1 + num2));


        // 模拟处理时间长的服务调用
        Random random = new Random();
        int sleepTime = random.nextInt(3000);
        log.info("休眠时间：" + sleepTime+"ms.");
        try {
            Thread.sleep(sleepTime);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
      return  num1+num2;
    }


}
