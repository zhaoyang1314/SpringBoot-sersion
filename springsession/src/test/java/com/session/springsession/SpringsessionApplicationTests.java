package com.session.springsession;

import com.session.springsession.mailConfig.MailUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.Proxy;

@SpringBootTest
class SpringsessionApplicationTests {

    @Test
    void contextLoads() {
        MailUtil mailUtil = new MailUtil();
//        mailUtil.sendMail();

    }

}
