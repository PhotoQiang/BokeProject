package com.friend.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.friend.pojo.Friend;
import com.util.CreatePage;
import com.util.JdbcUtils;


public class FriendDao {
	
	Connection conn=null;
	PreparedStatement  ps= null;
    ResultSet rs=null;
    
    //查询某人好友总数
    public int totalRecord(int userId){
    	String sql="select count(*) from friend where UserId=?";
		try {
			 conn=JdbcUtils.getConnection();
			 PreparedStatement  ps= conn.prepareStatement(sql);
			 ps.setObject(1, userId);
			 rs=ps.executeQuery();
			 while(rs.next()){
				int tr=rs.getInt(1);
			   return tr;
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
		return 0;
    }
    
    //查找某一页的好友
    public List<Friend> pageFriend(CreatePage cpage,int userId){
    	Integer i=userId;
    	if(i==null){
    	return null;
    	}
    	String sql="select * from friend where UserId=? limit ?,?";
		try {
			 conn=JdbcUtils.getConnection();
			 PreparedStatement  ps= conn.prepareStatement(sql);
			 int page=cpage.getCurrentPage();  //查找该页的好友
			 int perRecord=cpage.getPerRecord();
			 ps.setObject(1, userId);
			 ps.setObject(2, (page-1)*perRecord);
			 ps.setObject(3, perRecord);
			 rs=ps.executeQuery(); 
             List<Friend> friendList=translate(rs);
             if(friendList!=null){
             return friendList;
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
	 
	//添加一个好友
	public void add(Friend f){

			if(f==null){
				return ;
			}
			String sql="insert into friend(FriendName,UserId) values(?,?)";
			try {
				 conn=JdbcUtils.getConnection();
				 PreparedStatement  ps= conn.prepareStatement(sql);
				 ps.setObject(1, f.getFriendName());
				 ps.setObject(2, f.getUserId());

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
	
	//删除一个好友
	public void delete(int friendId){
		Integer i=friendId;
		if(i==null){
			return ;
		}
		String sql="delete from friend where FriendId=?";
		try {
			 conn=JdbcUtils.getConnection();
			 PreparedStatement  ps= conn.prepareStatement(sql);
			 ps.setObject(1, friendId);


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

	//获取某一个好友
	public Friend getOneFriend(int friendId){
		Integer i=friendId;
		if(i==null){
		     return null;
		}
		String sql="select * from friend where FriendId=?";
		try {
			 conn=JdbcUtils.getConnection();
			 PreparedStatement  ps= conn.prepareStatement(sql);
			 ps.setObject(1, friendId);
			 rs=ps.executeQuery(); 
			 if(rs.next()){
			 Friend f=new Friend(rs.getInt("friendId"),rs.getString("friendName"),rs.getInt("userId"));
			 return f;
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
	
	//获取某个人的所有好友
	public List<Friend> getAllFriend(int userId){
    	Integer i=userId;
    	if(i==null){
    	     return null;
    	}
		String sql="select * from friend where UserId=?";
		try {
			 conn=JdbcUtils.getConnection();
			 PreparedStatement  ps= conn.prepareStatement(sql);
			 ps.setObject(1, userId);
			 rs=ps.executeQuery(); 
             List<Friend> friendList=translate(rs);
             if(friendList!=null){
             return friendList;
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
	
	//处理结果集，返回一个朋友集合
	private List<Friend> translate(ResultSet rs){
		List <Friend> l=new ArrayList<Friend>();
		try {
			while(rs.next()){
				Friend f=new Friend(rs.getInt("friendId"),rs.getString("friendName"),rs.getInt("userId"));
				l.add(f);
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
