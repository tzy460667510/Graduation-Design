package com.neusoft.graduation.component;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @ClassName Email
 * @Description TODO
 * @Author Alice丶Nakiri
 * @Date 2019/11/19 21:26
 * Version 1.0
 **/
public class Email {
    public void sendEmail(String path,String title, String msg) throws Exception {//path是指你要发给哪个邮箱号，title是指你的邮件的标题。msg是指你的邮件的内容。

        Properties properties = new Properties();
        properties.put("mail.transport.protocol", "smtp");// 连接协议，即：邮件协议
        properties.put("mail.smtp.host", "smtp.qq.com");// 主机名
        properties.put("mail.smtp.port", 465);// 端口号
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.enable", "true");// 设置是否使用ssl安全连接 ---一般都使用
        properties.put("mail.debug", "true");// 设置是否显示debug信息 true 会在控制台显示相关信息
        // 得到回话对象
        Session session = Session.getInstance(properties);
        // 获取邮件对象
        Message message = new MimeMessage(session);
        // 设置发件人邮箱地址
        message.setFrom(new InternetAddress("460667510@qq.com"));
        // 设置收件人邮箱地址
        message.setRecipients(Message.RecipientType.TO, new InternetAddress[]{new InternetAddress(path)});
        //message.setRecipient(Message.RecipientType.TO, new InternetAddress("xxx@qq.com"));//一个收件人
        // 设置邮件标题
        message.setSubject(title);
        // 设置邮件内容
        message.setText(msg);
        // 得到邮差对象
        Transport transport = session.getTransport();
        // 连接自己的邮箱账户
        transport.connect("460667510@qq.com", "znaufkllwvzhbhhi");// 密码为QQ邮箱开通的stmp服务后得到的客户端授权码（你可以进入你的邮箱的设置里面查看）
        // 发送邮件
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }

    public static void main(String[] args) {
        Email email = new Email();
        try {
            email.sendEmail("tzy460667510@163.com","测试标题","测试内容");
        } catch (Exception e) {
            System.out.println("发送失败");
        }
    }
}
