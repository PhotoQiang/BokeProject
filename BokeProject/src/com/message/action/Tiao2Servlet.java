package com.message.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.message.dao.MessageDao;
import com.message.pojo.Message;

public class Tiao2Servlet extends HttpServlet {
	MessageDao dao=new MessageDao();
	public Tiao2Servlet() {
		super();
	}

	public void destroy() {
		super.destroy(); 
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String FriendName=(request.getSession().getAttribute("friendName").toString());
		int FriendId=Integer.parseInt(request.getSession().getAttribute("friendId").toString());
		List<Message> l=dao.selectById(FriendId);
		request.getSession().setAttribute("mess", l);
		request.getSession().setAttribute("FriendName", FriendName);
		response.sendRedirect("/BokeProject/message/MessagetoFriend.jsp");
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
