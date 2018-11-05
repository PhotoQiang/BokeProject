package com.findpass.action;


import javax.mail.BodyPart;
import javax.mail.Multipart;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import javax.mail.Session;
import java.util.Properties;
import javax.mail.internet.MimeMessage;
import javax.mail.Message;
import java.util.Date;


public class MailSend {
    public boolean sendMail(String emailTo,String content,String subject) {
        String username="admin";///发信使用的用户名
        String password="1993123sin";//发信使用的密码
        String fromEmail="sin_rise@163.com";
        String body = content; //正文内容
        try {
//****************************创建会话***************************************
            Properties props = new Properties();
            props.put("mail.smtp.host","smtp.163.com");//发件人使用发邮件的电子信箱服务器
            props.put("mail.smtp.auth","true"); //这样才能通过验证
            Session mailsession = Session.getInstance(props); //获得默认的session对象
            mailsession.setDebug(true);

//*****************************构造消息***************************************
            MimeMessage msg = new MimeMessage(mailsession);

            InternetAddress from=new InternetAddress(username+"<"+fromEmail+">");
            msg.setFrom(from);
            InternetAddress to=new InternetAddress(emailTo); //设置收件人地址并规定其类型
            msg.setRecipient(Message.RecipientType.TO,to);
            msg.setSentDate(new Date()); //设置发信时间
            msg.setSubject(subject); //设置主题
           // msg.setText(body); //设置 正文
          //给消息对象设置内容
            BodyPart mdp=new MimeBodyPart();//新建一个存放信件内容的BodyPart对象
            mdp.setContent(body, "text/html;charset= GB2312");//设置 发送邮件内容为HTML类型,并为中文编码
            Multipart mm=new MimeMultipart();
            mm.addBodyPart(mdp);
            msg.setContent(mm);
            msg.saveChanges();
            Transport transport=mailsession.getTransport("smtp");
            transport.connect("smtp.163.com","sin_rise",password);//发邮件人帐户密码,此外是我的帐户密码，使用时请修改。
            transport.sendMessage(msg,msg.getAllRecipients());
            transport.close();
//*******************************发送消息********************************
            msg.writeTo(System.out);//保存消息 并在控制台 显示消息对象中属性信息
            System.out.println("邮件已成功发送到 " + emailTo);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            return false;
        }

    }
}

