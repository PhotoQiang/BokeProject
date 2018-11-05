package com.article.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.article.dao.ArticleDao;
import com.article.pojo.Article;

public class UpdateArticleServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArticleDao dao=new ArticleDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int articleId=Integer.parseInt(request.getParameter("articleId"));
		Article article=dao.selectOneArt(articleId);
		request.getSession().setAttribute("article",article);
		request.getSession().setAttribute("articleId",article.getArticleId());
		response.sendRedirect("article/aditArticle.jsp");
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
