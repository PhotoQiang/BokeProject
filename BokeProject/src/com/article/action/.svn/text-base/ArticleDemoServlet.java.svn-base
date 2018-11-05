package com.article.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.article.dao.ArticleDao;
import com.article.dao.CommentDao;
import com.article.pojo.Article;
import com.article.pojo.Comment;

public class ArticleDemoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	ArticleDao dao=new ArticleDao();
	CommentDao cDao=new CommentDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int articleId=Integer.parseInt(request.getParameter("articleId"));
		Article article=dao.selectOneArt(articleId);
		request.getSession().setAttribute("article",article);
		//获取评论信息
		List<Comment> comments=cDao.selectComByArt(article.getArticleId());
		request.getSession().setAttribute("comments",comments);
		request.getSession().setAttribute("articleId",articleId);
		
		response.sendRedirect("article/articleDemo.jsp");
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
