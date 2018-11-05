package com.message.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.message.dao.MessageDao;
import com.message.dao.ReplyDao;
import com.message.pojo.Message;
import com.message.pojo.Reply;

public class AddReplyServlet extends HttpServlet {
	ReplyDao dao=new ReplyDao();
	MessageDao dao1=new MessageDao();
	/**
	 * Constructor of the object.
	 */
	public AddReplyServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fId=request.getSession().getAttribute("userId").toString();
		
		int friendid=Integer.parseInt((fId));
		int rmessageId=Integer.parseInt(request.getSession().getAttribute("messageId").toString());
		int userId=Integer.parseInt(request.getSession().getAttribute("userId").toString());
		String replyContent =request.getParameter("replyContent");
		Reply r=new Reply(replyContent,rmessageId,friendid,userId);
		dao.addReply(r);
		System.out.println(rmessageId+"rmessageId");
	    
		int id =Integer.parseInt(request.getSession().getAttribute("userId").toString());
		List<Message> l =dao1.selectByUser(id);
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
