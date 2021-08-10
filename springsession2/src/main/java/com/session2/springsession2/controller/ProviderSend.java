package com.session2.springsession2.controller;

import com.session2.springsession2.configMq.RabbitConfig;
import com.session2.springsession2.service.QueueMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by LeuMu Zhao on 2021/3/23 0023 22:15
 * @author Administrator
 */
@RestController
@RequestMapping(value = "/provider")
@Slf4j
public class ProviderSend {
    @Autowired
    private QueueMessageService queueMessageService;

    @GetMapping("/send/{name}")
    public String sendMessage(@PathVariable String name) {
        try {
                Map<String, Object> messageMap = new HashMap<>();
                messageMap.put("messageId",UUID.randomUUID().toString());
                messageMap.put("name",name);
                messageMap.put("messageData","测试信息");
                messageMap.put("createTime", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                queueMessageService.send(messageMap, RabbitConfig.EXCHANGE_D, RabbitConfig.ROUTINGKEY_D);
            return "success";
        } catch (Exception e) {
            log.error(""+e);
            return "error" +e;
        }
    }
}
