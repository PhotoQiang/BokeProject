package com.article.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.article.pojo.Comment;
import com.util.JdbcUtils;

public class CommentDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	// 删除评论
	public void deleteComment(int commentId) {
		Integer i = commentId;
		if (i == null) {
			return;
		}
		String sql = "delete from comment where CommentId=?";
		try {
			conn = JdbcUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, commentId);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				JdbcUtils.close(conn, ps, null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// 增加评论
	public void addComment(Comment artc) {

		String sql = "insert into Comment(ArticleId,CommentContent,UserId,UserName) values(?,?,?,?)";
		try {
			conn = JdbcUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, artc.getArticleId());
			ps.setObject(2, artc.getCommentContent());
			ps.setObject(3, artc.getUserId());
			ps.setObject(4, artc.getUserName());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				JdbcUtils.close(conn, ps, null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// 查询某文章所有评论

	public List<Comment> selectComByArt(int articleId) {
		Integer i = articleId;

		if (i == null) {
			return null;
		}
		String sql = "select * from comment where articleId=?";
		try {
			conn = JdbcUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, articleId);
			rs = ps.executeQuery();
			return translate(rs);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				JdbcUtils.close(conn, ps, null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	// 处理结果集
	private List<Comment> translate(ResultSet rs) {
		List<Comment> l = new ArrayList<Comment>();
		try {
			while (rs.next()) {
				Comment artc = new Comment(rs.getInt("commentId"),
						rs.getInt("articleId"), rs.getString("commentContent"),
						rs.getInt("userId"),rs.getString("userName"));
				l.add(artc);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				JdbcUtils.close(conn, ps, null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return l;

	}

}
