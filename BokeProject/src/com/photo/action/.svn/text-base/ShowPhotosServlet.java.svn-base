package com.photo.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.photo.dao.PhotoDao;
import com.photo.pojo.Photo;


public class ShowPhotosServlet extends HttpServlet {
	PhotoDao dao=new PhotoDao();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//		//获取从页面传来的userId参数,如果是从好友列表页面传来的，则此userId是好友表中的参数
//		String userId=request.getParameter("userId");
//		List<Photo> photos=dao.selectByUser(Integer.parseInt(userId));
//		request.getSession().setAttribute("Photos",photos);
		
//		//判断userId是否是从好友列表页面传来的参数,loginUserId是user表中userId参数
//		if(request.getSession().getAttribute("loginUserId").toString().equals(userId)){
//			response.sendRedirect("photo/photo.jsp");
//		}else{
//			response.sendRedirect("photo/photoOfFriend.jsp");
//		}
		
//		//假写一个user表中userId参数
//		int userId=1;
//		request.getSession().setAttribute("loginUserId",userId);
		
		int loginUserId=Integer.parseInt(request.getSession().getAttribute("userId").toString());//传递参数值
		List<Photo> photos=dao.selectByUser(loginUserId);
		request.getSession().setAttribute("photos",photos);
		response.sendRedirect("photo/photo.jsp");
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
