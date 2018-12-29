package com.baba.smsdemo.ssm;

import com.aliyuncs.exceptions.ClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Ant
 * @Date: 2018/12/13 7:28
 * @Version 1.0
 */


@RestController
public class Producter {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;



        @RequestMapping("/info")
    public String task1(){

        Map<String,String> map = new HashMap<String,String>();
        map.put("mobile","18900513972");
        map.put("template_code","SMS_152545288");
        map.put("sign_name","wzdoo");
        map.put("param","{\"name\":\"隔壁老王\",\"code\":\"520520\"}");


        jmsMessagingTemplate.convertAndSend("sms-demo",map);

            System.out.println("发送成功！");
            return "发送成功！";
    }


}
