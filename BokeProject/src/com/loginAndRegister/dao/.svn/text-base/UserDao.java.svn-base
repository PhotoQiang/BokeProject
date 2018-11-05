package com.loginAndRegister.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.loginAndRegister.pojo.User;
import com.util.JdbcUtils;



public class UserDao {
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	//锟斤拷锟揭伙拷锟斤拷没锟�

public void addUser(User u){
		if(u==null){
			return ;
		}
		User user=(User)u;
		String sql="insert into User(UserId,UserName,UserPasswd) values(?,?,?)";
		try {
			conn=JdbcUtils.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setObject(1, user.getUserId());
			ps.setObject(2, user.getUserName());
			ps.setObject(3, user.getUserPasswd());
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
	//锟斤拷锟斤拷没锟絀d锟斤拷锟斤拷询锟矫伙拷锟斤拷锟斤拷
	

public List<User> findUserPasswd(User u){
		
		String sql="select UserName,UserPasswd from User where UserName=?";
		try {
			conn=JdbcUtils.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setObject(1, u.getUserName());
			rs=ps.executeQuery();
			return transate2(rs);
			
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


//查询用户 
public List<User> select(User u){
			if(u==null){
				return null;
			}
			String sql="select * from user where UserName=? and UserPasswd=?";
		try {
			conn=JdbcUtils.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setObject(1, u.getUserName());
			ps.setObject(2, u.getUserPasswd());
			rs=ps.executeQuery();
			return transate(rs);
				
			} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
    	}
		return null;			
	}

	public List<User> selectUserPasswd(User u){
		
		User user=(User)u;
		String sql="select UserPasswd from User where UserId=?";
		try {
			conn=JdbcUtils.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setObject(1, user.getUserId());
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
	
	public List<User> selectByUserName(String userName){
		
		String sql="select * from User where UserName=?";
		try {
			conn=JdbcUtils.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setObject(1, userName);
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
	private List<User> transate(ResultSet rs) {
		List<User> s=new ArrayList<User>();
		try {
			while(rs.next()){
				User user=new User(rs.getInt("UserId"),rs.getString("UserName"),rs.getString("UserPasswd"));
				s.add(user);
				}
			
			
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
		return s;
	}
	
	private List<User> transate2(ResultSet rs) {
		List<User> s=new ArrayList<User>();
		try {
			while(rs.next()){
				User user=new User(rs.getString("UserName"),rs.getString("UserPasswd"));
				s.add(user);
				}
			
			
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
		return s;
	}
	//锟斤拷锟斤拷没锟絀D锟斤拷锟睫革拷锟矫伙拷锟斤拷锟斤拷
		public User updateUserPasswd(User u){
			String sql="update User set UserPasswd =? where UserId=?";
			try {
				conn=JdbcUtils.getConnection();
				ps=conn.prepareStatement(sql);
				ps.setObject(1, u.getUserPasswd());
				ps.setObject(2, u.getUserId());
				ps.executeUpdate();
				
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

		
		
		
		public List<User> selectUserName(User u){
			
			User user=(User)u;
			String sql="select UserName from User where UserName=?";
			try {
				conn=JdbcUtils.getConnection();
				ps=conn.prepareStatement(sql);
				ps.setObject(1, user.getUserName());
				rs=ps.executeQuery();
				return transate3(rs);
				
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
public int selectUserName2(String u){
	
			String sql="select UserId from User where UserName=?";
			try {
				conn=JdbcUtils.getConnection();
				ps=conn.prepareStatement(sql);
				ps.setObject(1, u);
				rs=ps.executeQuery();
				return transate4(rs);
				
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
			return 0;
		}
		
		private List<User> transate3(ResultSet rs) {
			List<User> s=new ArrayList<User>();
			try {
				while(rs.next()){
					User user=new User(rs.getString("UserName"));
					s.add(user);
					}
				
				
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
			return s;
		}

		private int transate4(ResultSet rs) {
			int i=0;
			try {
				while(rs.next()){
					i=rs.getInt("UserId");
					}
				
				
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
			return i;
		}
		@Override
		public String toString() {
			return "UserDao [conn=" + conn + ", ps=" + ps + ", rs=" + rs + "]";
		}

}
