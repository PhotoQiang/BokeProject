package com.friend.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.userInformation.dao.UserinformationDao;
import com.userInformation.pojo.Userinformation;

public class Finfo extends HttpServlet {
	UserinformationDao uinfo=new UserinformationDao();
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
		List<Userinformation> l=new ArrayList<Userinformation>();
		String UserId=request.getSession().getAttribute("friendUserId").toString();
		
		System.out.println("Finfo.doPost()"+UserId);
		int userId=Integer.parseInt(UserId);
		
		
		l=uinfo.selectAll(userId);
		request.getSession().setAttribute("finfo", l);
		
		System.out.println("Finfo.doPost()"+l);
		request.getRequestDispatcher("/personInfo/fInfo.jsp").forward(request, response);
	}

}
