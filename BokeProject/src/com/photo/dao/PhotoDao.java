package com.photo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.photo.pojo.Photo;
import com.util.JdbcUtils;



public class PhotoDao {
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	//增
	public void addPhoto(Photo p){
		if(p==null){
			return ;
		}
		Photo photo=(Photo)p;
		String sql="insert into Photo(UserId,Url) values(?,?)";
		try {
			conn=JdbcUtils.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setObject(1, photo.getUserId());
			ps.setObject(2, photo.getUrl());
			ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			try {
				JdbcUtils.close(conn, ps, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	//删
	public Photo deletePhoto(Photo p){
		if(p==null||p.getPhotoId()==0){
			return null;
		}
		
		
		String sql="delete from Photo where PhotoId=?";
		try {
			conn=JdbcUtils.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setObject(1, p.getPhotoId());
			
			ps.executeUpdate();
			return p;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			try {
				JdbcUtils.close(conn, ps, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
		
	}
	//查
	public List<Photo> selectAll(){
		String sql="select *from Photo";
		try {
			conn=JdbcUtils.getConnection();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			return transate(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
	//获取某个人的照片
	public List<Photo> selectByUser(int userId){
		String sql="select *from Photo where userId=?";
		try {
			conn=JdbcUtils.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setObject(1,userId);
			rs=ps.executeQuery();
			return transate(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
	//转换结果集
	private List<Photo> transate(ResultSet rs) {
		
		List<Photo> l=new ArrayList<Photo>();
		try {
			while(rs.next()){
				Photo photo=new Photo(rs.getInt("PhotoId"),rs.getInt("UserId"),rs.getString("Url"));
				l.add(photo);
				
				
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
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