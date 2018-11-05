package com.userInformation.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.userInformation.pojo.Userinformation;
import com.util.JdbcUtils;



public class UserinformationDao {
	  Connection conn=null;
	     PreparedStatement ps=null;
	   ResultSet rs=null;
	   
	   public void add(Userinformation ui) { 
			if(ui==null){
				return ;
			}
			String sql="insert into Userinformation(UserId,TickName,Telphone,Hobby) values(?,?,?,?)";
			try{
		    conn=JdbcUtils.getConnection();
		    ps=conn.prepareStatement(sql);
		    ps.setObject(1, ui.getUserId());
			 ps.setObject(2, ui.getTickName());
			 ps.setObject(3, ui.getTelphone());
			 ps.setObject(4, ui.getHobby());
			  ps.executeUpdate();
		    
		    }catch (Exception e) {
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
	   public Userinformation delete(Userinformation ui) {
			
			if(ui==null){
				return null;
			}
			String sql="delete from Userinformation where informationId=?";
			try{
			conn=JdbcUtils.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setObject(1,ui.getInformationId());
			ps.executeUpdate();

			}catch (Exception e) {
				// TODO: handle exception
			}finally
			{
				try {
					JdbcUtils.close(conn, ps, rs);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			return null;
		}  
	   public List<Userinformation> selectAll(int id) {
			String sql="select * from userinformation where UserId=? ";
			try{
			conn=JdbcUtils.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			 return transate(rs);
			}catch (Exception e) {
				// TODO: handle exception
			}finally{
				
				try {
					JdbcUtils.close(conn, ps, rs);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return null;
		}
		private List<Userinformation> transate(ResultSet rs) throws SQLException{
			List<Userinformation>  l=new ArrayList<Userinformation>();
			try{
				while(rs.next()){
					Userinformation userinformation=new Userinformation(rs.getInt("InformationId"),rs.getInt("UserId"),rs.getString("TickName"),rs.getString("Telphone"),rs.getString("Hobby"));
				   l.add(userinformation);
				   }
			}catch (Exception e) {
				// TODO: handle exception
			}finally{
				JdbcUtils.close(conn, ps, null);
			}
			return l;
		}
		public void update(Userinformation ui) {
			String sql="update Userinformation set TickName=?,Telphone=?,Hobby=? where UserId=?";
			try{
			conn=JdbcUtils.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setObject(1, ui.getTickName());
			ps.setObject(2, ui.getTelphone());
			ps.setObject(3, ui.getHobby());
			ps.setObject(4, ui.getUserId());
			
			ps.executeUpdate();
			
			}catch (Exception e) {
				// TODO: handle exception
			}finally
			{
				try {
					JdbcUtils.close(conn, ps, rs);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		}
