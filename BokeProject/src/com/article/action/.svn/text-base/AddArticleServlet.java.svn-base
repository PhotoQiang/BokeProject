package com.article.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.article.dao.ArticleDao;
import com.article.pojo.Article;

public class AddArticleServlet extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArticleDao dao=new ArticleDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String articleName=request.getParameter("articleName");
		String articleContent=request.getParameter("articleContent");
		int loginUserId=Integer.parseInt(request.getSession().getAttribute("userId").toString());//当前用户ID
		Article newArticle=new Article(loginUserId,articleName,articleContent);
		dao.addArticle(newArticle);
		List<Article> articles=dao.selectArtByUser(loginUserId);
		request.getSession().setAttribute("userArticles",articles);
		response.sendRedirect("article/articleList.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
