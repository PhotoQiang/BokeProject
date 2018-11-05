package com.article.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.article.dao.ArticleDao;
import com.article.dao.CommentDao;
import com.article.pojo.Comment;

public class DeleteCommentServlet extends HttpServlet {

	private static final long serialVersionUID = 8941298283643868889L;
	ArticleDao dao = new ArticleDao();
	CommentDao cDao = new CommentDao();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int commentId = Integer.parseInt(request.getParameter("commentId"));
		int articleId = Integer.parseInt(request.getSession()
				.getAttribute("articleId").toString());
		cDao.deleteComment(commentId);
		// 获取评论信息
		List<Comment> comments = cDao.selectComByArt(articleId);
		request.getSession().setAttribute("comments", comments);

		response.sendRedirect("article/articleDemo.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
