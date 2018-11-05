package com.sendmail.action;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.*;
import javax.servlet.http.*;

import com.loginAndRegister.dao.UserDao;

import java.io.*;
import java.util.*;

public class SendServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4707486569356636366L;
	UserDao user = new UserDao();
	private String message;

	// Initialize global variables
	public void init() throws ServletException {
	}

	// Process the HTTP Get request
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	// Process the HTTP Post request
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("sendName");
		String password = request.getParameter("sendPass");
		String fromEmail = request.getParameter("sendMail");
		String content = request.getParameter("sendContent");
		String emailTo = "sin_rise@163.com";
		String subject = request.getParameter("subject");

		int index = fromEmail.lastIndexOf("@");
		String omail = fromEmail.substring((index + 1), fromEmail.length());

		try {
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp." + omail);// 发件人使用发邮件的电子信箱服务器
			props.put("mail.smtp.auth", "true"); // 这样才能通过验证
			Session mailsession = Session.getInstance(props); // 获得默认的session对象
			mailsession.setDebug(true);

			MimeMessage msg = new MimeMessage(mailsession);
			InternetAddress from = new InternetAddress(username + "<"
					+ fromEmail + ">");
			msg.setFrom(from);
			InternetAddress to = new InternetAddress(emailTo); // 设置收件人地址并规定其类型
			msg.setRecipient(Message.RecipientType.TO, to);
			msg.setSentDate(new Date()); // 设置发信时间
			msg.setSubject(subject); // 设置主题
			msg.setText(content); // 设置 正文
			// 给消息对象设置内容
			BodyPart mdp = new MimeBodyPart();// 新建一个存放信件内容的BodyPart对象
			mdp.setContent(content, "text/html;charset= GB2312");// 设置
																	// 发送邮件内容为HTML类型,并为中文编码
			Multipart mm = new MimeMultipart();
			mm.addBodyPart(mdp);
			msg.setContent(mm);
			msg.saveChanges();
			Transport transport = mailsession.getTransport("smtp");
			transport.connect("smtp." + omail, fromEmail, password);// 发邮件人帐户密码,此外是我的帐户密码，使用时请修改。
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
			msg.writeTo(System.out);// 保存消息 并在控制台 显示消息对象中属性信息
			System.out.println("邮件已成功发送到 " + emailTo);

			response.sendRedirect("/BokeProject/sendmail/secced.html");
		} catch (AddressException e) {
			e.printStackTrace();
			System.out.println(e);
			response.sendRedirect("/BokeProject/sendmail/fail.html");
		} catch (MessagingException e) {
			e.printStackTrace();
			System.out.println(e);
			response.sendRedirect("/BokeProject/sendmail/fail.html");
		}
	}

	// Clean up resources
	public void destroy() {
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
