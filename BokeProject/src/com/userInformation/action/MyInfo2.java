package com.userInformation.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loginAndRegister.pojo.User;
import com.userInformation.dao.UserinformationDao;
import com.userInformation.pojo.Userinformation;

public class MyInfo2 extends HttpServlet {
	UserinformationDao uinfo=new UserinformationDao();
	/**
	 * Constructor of the object.
	 */
	public MyInfo2() {
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
		List<Userinformation> l=new ArrayList<Userinformation>();
		
		String UserId=request.getSession().getAttribute("userId").toString();
		int userId=Integer.parseInt(UserId);
		
		
		String tick=request.getParameter("tick");
		String tel=request.getParameter("tel");
		String hobby=request.getParameter("hobby");
		
		uinfo.update(new Userinformation(tick, tel, hobby,userId));
		
		System.out.println("MyInfo2.doGet()"+tick+"----"+tel);
		request.getRequestDispatcher("/myInfo.do").forward(request, response);
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
this.doGet(request, response);
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
