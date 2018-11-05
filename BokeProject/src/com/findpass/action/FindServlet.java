package com.findpass.action;

import javax.servlet.*;
import javax.servlet.http.*;

import com.loginAndRegister.dao.UserDao;
import com.loginAndRegister.pojo.User;




import java.io.*;
import java.util.*;

public class FindServlet extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=utf-8";
    UserDao user=new UserDao();
    private String message;
    //Initialize global variables
    public void init() throws ServletException {
    }

    //Process the HTTP Get request
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
    	this.doPost(request, response);
    }

    //Process the HTTP Post request
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        response.setContentType(CONTENT_TYPE);
        request.setCharacterEncoding("utf-8");//
        List<User> l=new ArrayList<User>();
        String UserName0 = request.getParameter("email");
        
        
        
        l=user.findUserPasswd(new User(UserName0));
        String userName=null;
        String userPass=null;
        if(l!=null&&l.size()>0)
        {
        	for (User user : l) {
				 userName=user.getUserName();
				 userPass=user.getUserPasswd();
			}
        	if(userName.equals(UserName0)){//用户输入的email和数据库中的进行匹配
                MailSend ms = new MailSend();
                String message = "博动博客网：<br/> 亲爱的"+userName+":<br>这是你的密码："+userPass+"  请牢记！";
                //发送密码到邮箱
                if(ms.sendMail(userName,message,"密码找回")){//如果发送成功
                    this.setMessage("密码已经成功发送到你的邮箱，请查收！");
                    System.out.print("亲爱的"+userName+":/t这是你的密码："+userPass+"  请牢记！");
                    request.getRequestDispatcher("/personInfo/findsucceed.jsp").forward(request, response);
                }else{
                    this.setMessage("邮件发送失败，请稍候再试 ！");
                }
            }else{
                this.setMessage("对不起，用户名或者电子邮箱有误！");
            }
        }
        
    }

    //Clean up resources
    public void destroy() {
    }
    
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
