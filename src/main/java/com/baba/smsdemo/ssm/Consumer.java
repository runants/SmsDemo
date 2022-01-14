package com.baba.smsdemo.ssm;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Author: Ant
 * @Date: 2018/12/13 7:38
 * @Version 1.0
 */
@Component

public class Consumer {

    @Resource(name="smsUtils")
//    @Autowired
    private SmsUtils smsUtils;

    @JmsListener(destination = "sms-demo")
    public void task2(Map<String,String> map){

        try {
            SendSmsResponse smsResponse = smsUtils.sendSms(map);
            System.out.println("code:"+smsResponse.getCode() + "message is:"+smsResponse.getMessage());
        } catch (ClientException e) {
            e.printStackTrace();
        }

        System.out.println(map);

    }




}
