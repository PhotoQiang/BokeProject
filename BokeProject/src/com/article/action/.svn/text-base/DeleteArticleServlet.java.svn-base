package com.article.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.article.dao.ArticleDao;
import com.article.pojo.Article;

public class DeleteArticleServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8941298283643868889L;
	ArticleDao dao=new ArticleDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int articleId=Integer.parseInt(request.getParameter("articleId"));
		dao.deleteArticle(articleId);
		int userId=Integer.parseInt(request.getSession().getAttribute("userId").toString());
		List<Article> articles=dao.selectArtByUser(userId);
		request.getSession().setAttribute("userArticles",articles);
		response.sendRedirect("article/articleList.jsp");
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
