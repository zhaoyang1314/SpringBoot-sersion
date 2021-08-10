package com.session.springsession.bean;

import lombok.Data;
import org.springframework.core.io.FileSystemResource;

/**
 * @author: wade
 * @Date: 2021/07/14/15:29
 * @qq:1143011510
 * @Description:
 */
@Data
public class MailBean {
    /**
     * 邮件主题
     */
    private String subject;

    /**
     * 邮件内容
     */
    private String text;

    /**
     * 附件
     */
    private FileSystemResource file;

    /**
     * 附件名称
     */
    private String attachmentFilename;

    /**
     * 内容ID，用于发送静态资源邮件时使用
     */
    private String contentId;

    public static MailBean getMailBean() {
        return new MailBean();
    }
}
