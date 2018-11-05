package com.article.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.article.pojo.Article;
import com.util.CreatePage;
import com.util.JdbcUtils;




public class ArticleDao {
	Connection conn=null;
	PreparedStatement  ps= null;
    ResultSet rs=null;
    
    //查询某人文章总数
    public int totalRecord(int userId){
    	int m=0;
    	String sql="select count(*) from aricle where UserId=?";
		try {
			 conn=JdbcUtils.getConnection();
			 ps= conn.prepareStatement(sql);
			 ps.setObject(1, userId);
			 rs=ps.executeQuery();
			 while(rs.next()){
				m++;
			
			 }
			 
			 return m;
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			try {
				JdbcUtils.close(conn, ps, null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
    }
    
    //分页查找某人文章
    public List<Article> pageArticle(CreatePage cpage,int userId){
    	
    	Integer i=userId;
    	if(i==null){
    	return null;
    	}
    	List<Article> ArticleList =new ArrayList<Article>();
    	String sql="select * from aricle where UserId=? limit ?,?";
		try {
			 conn=JdbcUtils.getConnection();
			 ps= conn.prepareStatement(sql);
			 int page=cpage.getCurrentPage();  //查找该页的文章
		
			 int perRecord=cpage.getPerRecord();
			 ps.setObject(1, userId);
			 ps.setObject(2, (page-1)*perRecord);
			 ps.setObject(3, perRecord);
			 rs=ps.executeQuery(); 
             ArticleList=translate(rs);
       
             if(ArticleList!=null){
             return ArticleList;
             }else{
            	 return null;
             }
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			try {
				JdbcUtils.close(conn, ps, null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
    }
	
	//发表文章
	public void addArticle(Article artc){
		String sql="insert into aricle(UserId,ArticleName,ArticleContent) values(?,?,?)";
		try {
			 conn=JdbcUtils.getConnection();
			 PreparedStatement  ps= conn.prepareStatement(sql);
			 ps.setObject(1,artc.getUserId());
			 ps.setObject(2,artc.getArticleName());
			 ps.setObject(3,artc.getArticleContent());

			 ps.executeUpdate(); 
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			try {
				JdbcUtils.close(conn, ps, null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//删除文章
	public void deleteArticle(int articleId){
		Integer i=articleId;
    	if(i==null){
    	return ;
    	}
		String sql="delete from aricle where ArticleId=?";
		try {
			 conn=JdbcUtils.getConnection();
			 PreparedStatement  ps= conn.prepareStatement(sql);
			 ps.setObject(1, articleId);


			 ps.executeUpdate(); 
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			try {
				JdbcUtils.close(conn, ps, null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
	
	//修改文章
	public void updateArticle(Article artc){

			String sql="update aricle set ArticleName=?,ArticleContent=? where ArticleId=?";
			try {
				 conn=JdbcUtils.getConnection();
				 PreparedStatement  ps= conn.prepareStatement(sql);
				 ps.setObject(1, artc.getArticleName());
				 ps.setObject(2, artc.getArticleContent());
				 ps.setObject(3, artc.getArticleId());
	ps.executeUpdate() ; 
			} catch (Exception e) {
				// TODO: handle exception
			}finally{
				try {
					JdbcUtils.close(conn, ps, null);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
	
	//查找一篇文章
	public Article selectOneArt(int articleId){
		Integer i=articleId;
    	if(i==null){
    	return null;
    	}
			String sql="select * from aricle where ArticleId=?";
			try {
				 conn=JdbcUtils.getConnection();
				 PreparedStatement  ps= conn.prepareStatement(sql);
				 ps.setObject(1, articleId);
				 rs=ps.executeQuery(); 
				 if(rs.next()){
					 Article artc=new Article(rs.getInt("ArticleId"),rs.getInt("UserId"),rs.getString("ArticleName"),rs.getString("ArticleContent"));
					 return artc;
					 }
			} catch (Exception e) {
				// TODO: handle exception
			}finally{
				try {
					JdbcUtils.close(conn, ps, null);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return null;
	}
	
	//查找某人所有文章
	public List<Article> selectArtByUser(int userId){
		Integer i=userId;
    	if(i==null){
    	return null;
    	}
			String sql="select * from aricle where UserId=?";
			try {
				 conn=JdbcUtils.getConnection();
				 PreparedStatement  ps= conn.prepareStatement(sql);
				 ps.setObject(1, userId);
				 rs=ps.executeQuery(); 
	             List<Article> articleList=translate(rs);
	             if(articleList!=null){
	             return articleList;
	             }else{
	            	 return null;
	             }
			} catch (Exception e) {
				// TODO: handle exception
			}finally{
				try {
					JdbcUtils.close(conn, ps, null);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return null;
	}
	
	
	
	//处理结果集
	private List<Article> translate(ResultSet rs){
		List <Article> l=new ArrayList<Article>();
		try {
			while(rs.next()){
				Article artc=new Article(rs.getInt("ArticleId"),rs.getInt("UserId"),rs.getString("ArticleName"),rs.getString("ArticleContent"));
				l.add(artc);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
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
