package com.friend.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.friend.pojo.Friend;
import com.loginAndRegister.pojo.User;


import com.friend.dao.FriendDao;



public class MyFriendServlet extends HttpServlet {

	FriendDao fd=new FriendDao();
	public MyFriendServlet() {
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

         
         User user=(User)request.getSession().getAttribute("user");
         if(user!=null){
                 System.out.println(user.getUserName()+"是否获得登录用户姓名");
                 int userId=user.getUserId();
                 System.out.println("MyFriendServlet.doGet()"+userId);
                 List<Friend> friendList=fd.getAllFriend(userId);
                 System.out.println(friendList.size()+"朋友个数");
                 request.getSession().setAttribute("friendList",friendList);           
                 response.sendRedirect("/BokeProject/firstPageFriendServlet.do");
         }else{
        	 response.sendRedirect("/BokeProject/friend/noFriend.html"); 
         }
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

		doPost(request,response);
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
