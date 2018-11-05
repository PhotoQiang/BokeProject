package com.userInformation.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loginAndRegister.dao.UserDao;
import com.loginAndRegister.pojo.User;



public class UpdatePass extends HttpServlet {
	UserDao ud=new UserDao();
	/**
	 * Constructor of the object.
	 */
	public UpdatePass() {
		super();
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
		
		this.doPost(request, response);

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

		User u=(User)request.getSession().getAttribute("user");
		
		String UserId=request.getSession().getAttribute("userId").toString();
		int userId=Integer.parseInt(UserId);
		
		String newpass=null;
		String old1=request.getParameter("oPass");
		if(u.getUserPasswd().equals(old1)){
			 newpass=request.getParameter("nPass");
			ud.updateUserPasswd(new User(userId,newpass));
		}
		
		System.out.println("UpdatePass.doGet()_____"+userId+"------"+newpass);
		
		request.getRequestDispatcher("/personInfo/succeed.jsp").forward(request, response);
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
