package com.message.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loginAndRegister.dao.UserDao;
import com.loginAndRegister.pojo.User;
import com.message.dao.MessageDao;
import com.message.pojo.Message;

public class AddMessageServlet extends HttpServlet {
	MessageDao dao=new MessageDao();
	UserDao udao=new UserDao();
	/**
	 * Constructor of the object.
	 */
	public AddMessageServlet() {
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
		int UseId=Integer.parseInt(request.getSession().getAttribute("userId").toString());
//		String MessageContent=new String(request.getParameter("messageText").getBytes("ISO-8859-1"),"UTF-8");
	    String MessageContent=request.getParameter("messageText");
	    int FriendId=Integer.parseInt(request.getSession().getAttribute("friendId").toString());;
	    String FriendName=request.getSession().getAttribute("friendName").toString();
	    

		User u=(User)request.getSession().getAttribute("user");
		String userName=u.getUserName();
	    
		int uid=udao.selectUserName2(FriendName);
		
		
	    Message m=new Message(UseId,MessageContent,FriendId,userName,uid);
	    
	    dao.add(m);
	    List<Message> l=dao.selectById(FriendId);
	    request.getSession().setAttribute("mess", l);
	    response.sendRedirect("/BokeProject/message/MessagetoFriend.jsp");
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
