package com.message.action;

import java.io.IOException;
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

public class ShowReplyServlet extends HttpServlet {
	ReplyDao dao=new ReplyDao();
	MessageDao mdao= new MessageDao();
	public  ShowReplyServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Reply> lreply=new ArrayList<Reply>();
		List<Message> message=new ArrayList<Message>();
		int id=Integer.parseInt(request.getParameter("messageId"));
		lreply= dao.selectByRmessage(id);
		message=mdao.selectByMegId(id);
		String friendName= message.get(0).getFriendName();
		String messageContent=message.get(0).getMessageContent();
		request.getSession().setAttribute("friendName",friendName );
		request.getSession().setAttribute("messageContent", messageContent);
		request.getSession().setAttribute("Reply", lreply);
		response.sendRedirect("/BokeProject/message/showReply.jsp");
		
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
