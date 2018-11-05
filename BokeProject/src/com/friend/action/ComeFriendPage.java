package com.friend.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.friend.dao.FriendDao;
import com.friend.pojo.Friend;
import com.loginAndRegister.dao.UserDao;
import com.loginAndRegister.pojo.User;

public class ComeFriendPage extends HttpServlet {

	FriendDao fd=new FriendDao();
	UserDao ud=new UserDao();
	
	public ComeFriendPage() {
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

	  String fid=request.getParameter("friendId");
	  if(fid!=null){
		  int friendId=Integer.parseInt(fid);
		  Friend friend=(Friend)fd.getOneFriend(friendId); 
		  String userName=friend.getFriendName();
		  
		  request.getSession().setAttribute("friendId", friendId);
		  request.getSession().setAttribute("friendName", userName);
		 
		  List<User> uList=ud.selectByUserName(userName);
		  if(uList!=null&uList.size()>0){
			 User friendUser=uList.get(0);
			 int friendUserId=friendUser.getUserId();
			 
			 System.out.println(friendUser+"以获取好友信息");
			 System.out.println(friendUser.getUserName()+"以获取好友信息");
			 System.out.println(friendUserId+"以获取好友信息");
			 
			 request.getSession().setAttribute("friendUser", friendUser);
			 request.getSession().setAttribute("friendUserId", friendUserId);
		  }  
	  }
	  response.sendRedirect("/BokeProject/friendMainPage.jsp");
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
