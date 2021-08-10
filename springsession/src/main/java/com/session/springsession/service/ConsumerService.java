package com.session.springsession.service;

import com.session.springsession.bean.MailBean;
import com.session.springsession.configMq.RabbitMqConfig;
import com.session.springsession.mailConfig.MailUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterThrowing;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.Proxy;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * Created by LeuMu Zhao on 2021/3/23 0023 22:36
 */
@Component
@Slf4j
public class ConsumerService {

    @RabbitListener(queues = RabbitMqConfig.QUEUE_A)
    @RabbitHandler
    public void consumeMessage(Message message){
        try {
            MailBean mailBean = MailBean.getMailBean();
            mailBean.setText(message.toString());
            attachEmail(mailBean);
        } catch (Exception e) {
            log.info("异常的消息",e.getMessage());
            e.printStackTrace();
        }
        log.info("收到的消息:{}",message);
    }

     @Autowired
    private MailUtil mailUtil;
    private void attachEmail(MailBean mailBean) {
        String filePath="C:\\Users\\keppel\\Pictures\\测试一下下.jpg";
        FileSystemResource file = new FileSystemResource(new File(filePath));
        String attachmentFilename = filePath.substring(filePath.lastIndexOf(File.separator));
        mailBean.setSubject("SpringBoot集成JavaMail实现邮件发送");
        mailBean.setText("SpringBoot集成JavaMail实现附件邮件发送");
        mailBean.setFile(file);
        mailBean.setAttachmentFilename(attachmentFilename);
        mailUtil.sendMailAttachment(mailBean);
    }
}
