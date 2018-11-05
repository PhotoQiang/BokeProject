package com.article.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.article.dao.ArticleDao;
import com.article.dao.CommentDao;
import com.article.pojo.Article;
import com.article.pojo.Comment;

public class ShowFriendArticle extends HttpServlet {
CommentDao cd=new CommentDao();
ArticleDao ad=new ArticleDao();
	/**
	 * Constructor of the object.
	 */
	public ShowFriendArticle() {
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
			
			int articleId=0;
			if(request.getParameter("articleId")==null){
				articleId=Integer.parseInt(request.getSession().getAttribute("articleId").toString());
			}else
			articleId=Integer.parseInt(request.getParameter("articleId"));
			//查看文章
			Article l=ad.selectOneArt(articleId);
			request.getSession().setAttribute("article", l);
			
			//查看评论
			List<Comment> lc=cd.selectComByArt(articleId);
			request.getSession().setAttribute("Cot", lc);
			
			
			response.sendRedirect("article/friendarticle.jsp");
			
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
