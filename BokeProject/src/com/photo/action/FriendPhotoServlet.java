package com.photo.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.photo.dao.PhotoDao;
import com.photo.pojo.Photo;


public class FriendPhotoServlet extends HttpServlet {
	PhotoDao dao=new PhotoDao();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String userId=request.getSession().getAttribute("friendUserId").toString();
		System.out.println("FriendPhotoServlet.doGet()----------------"+userId+"---------------");
		List<Photo> photos=dao.selectByUser(Integer.parseInt(userId));
		request.getSession().setAttribute("friendPhotos",photos);
		response.sendRedirect("photo/photoOfFriend.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
