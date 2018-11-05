package com.loginAndRegister.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loginAndRegister.dao.UserDao;
import com.loginAndRegister.pojo.User;



public class LoginServlet extends HttpServlet {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
UserDao dao=null;
	
	public LoginServlet() {
		super();
		dao=new UserDao();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
           String UserName=request.getParameter("userName");
           String UserPasswd=request.getParameter("password");
           
           System.out.println(UserName);
           System.out.println(UserPasswd);
           
           User u=new User(UserName,UserPasswd);
           List<User> userList=dao.select(u);
           System.out.println(u+"__________");
           if(userList!=null&&userList.size()>0){
        	   User user=userList.get(0);
        	   
        	   System.out.println(user.getUserName());
        	   
        	   request.getSession().setAttribute("userId",user.getUserId());
        	   
        	   request.getSession().setAttribute("loginUserName",user.getUserName());
        	   
        	   String UserId=request.getSession().getAttribute("userId").toString();
               
        	   System.out.println(UserId);
        	   
        	   request.getSession().setAttribute("user",user);
        	   response.sendRedirect("/BokeProject/mainPage.jsp");
           }else{
        	   response.sendRedirect("");
           }
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
