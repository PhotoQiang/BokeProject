package com.friend.action;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.friend.dao.FriendDao;
import com.friend.pojo.Friend;
import com.loginAndRegister.pojo.User;
import com.util.CreatePage;

public class FirstPageFriendServlet extends HttpServlet {

	FriendDao fd=new FriendDao();
	CreatePage cpage=new CreatePage();
	public FirstPageFriendServlet() {
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
		
         User user=(User)request.getSession().getAttribute("user");
         
         cpage.setCurrentPage(1);
         cpage.setPerRecord(5);
     
         if(user!=null){
        	 int userId=user.getUserId();
        	 cpage.setTotalRecord(fd.totalRecord(userId));
        	 cpage.setTotalPage(cpage.getTotalRecord(),cpage.getPerRecord());
        	 request.getSession().setAttribute("cpage",cpage);
        	 List<Friend> friendList=fd.pageFriend(cpage, userId);
        	 request.getSession().setAttribute("friendList",friendList); 
         }
		response.sendRedirect("/BokeProject/friend/myFriend.jsp");
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
