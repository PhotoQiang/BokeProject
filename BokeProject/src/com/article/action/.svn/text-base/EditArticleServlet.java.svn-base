package com.article.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.article.dao.ArticleDao;
import com.article.pojo.Article;

public class EditArticleServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArticleDao dao=new ArticleDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String articleName=request.getParameter("articleName");
		String articleContent=request.getParameter("articleContent");
		int articleId=Integer.parseInt(request.getSession().getAttribute("articleId").toString());
		int loginUserId=Integer.parseInt(request.getSession().getAttribute("userId").toString());//当前用户ID
		//更新文章并返回数据
		Article newArticle=new Article(articleId,loginUserId,articleName,articleContent);
		dao.updateArticle(newArticle);
		Article article=dao.selectOneArt(articleId);
		request.getSession().setAttribute("article",article);
		response.sendRedirect("article/articleDemo.jsp");
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
