package com.suncd.demopdf.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/zabbix/sendMsg")
public class TestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String sendMsg(String user, String subject, String msg) {
        // 数据处理
        LOGGER.info("用户:{},主题:{},消息内容:{}", user, subject, msg);
        return null;
    }
}
