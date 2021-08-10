package com.session.springsession.mailConfig;

/**
 * @author :leimu
 * @date:
 */
public interface MailService {

    //发送简单的邮件的方法
    public void  sendSimpleMail(String to, String subject, String content);

    //发送富文本的邮件的方法
    public void  sendHtmlMail(String to, String subject, String content);

    //发送带附件的邮件的方法
    public void sendAttachmentsMail(String to, String subject, String content, String filePath);

    //发送带静态资源的邮件的方法
    public void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId);
}
