package com.message.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.friend.dao.FriendDao;
import com.friend.pojo.Friend;
import com.message.dao.MessageDao;
import com.message.pojo.Message;

public class MyMessageServlet extends HttpServlet {
	MessageDao dao =new MessageDao();
	FriendDao dao1=new FriendDao();
	public MyMessageServlet() {
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
		String userId=request.getSession().getAttribute("userId").toString();
		int id =Integer.parseInt(userId);
		
		List<Message> l =dao.selectByUser(id);
		request.getSession().setAttribute("ms", l);
		System.out.println("MyMessageServlet.doGet()_______"+l);
		response.sendRedirect("/BokeProject/message/MyMessage.jsp");
	}

	
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
