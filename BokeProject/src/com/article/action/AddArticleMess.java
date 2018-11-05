package com.article.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.article.dao.ArticleDao;
import com.article.dao.CommentDao;
import com.article.pojo.Article;
import com.article.pojo.Comment;
import com.loginAndRegister.pojo.User;

public class AddArticleMess extends HttpServlet {
	CommentDao cd=new CommentDao();
	ArticleDao ad=new ArticleDao();
	/**
	 * Constructor of the object.
	 */
	public AddArticleMess() {
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
		int articleId=Integer.parseInt(request.getParameter("articleId"));
		int userId=Integer.parseInt(request.getSession().getAttribute("userId").toString());
		request.getSession().setAttribute("articleId",articleId);
		//发表评论
		User u=(User)request.getSession().getAttribute("user");
		String userName=u.getUserName();
		String CommentContent=request.getParameter("message");
		cd.addComment(new Comment(articleId,CommentContent,userId,userName));
		
		//
		response.sendRedirect("/BokeProject/ShowFriendArticle.do");
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
			this.doPost(request, response);
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
