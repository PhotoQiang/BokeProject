package com.message.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.message.pojo.Message;
import com.util.JdbcUtils;

public class MessageDao {
	   Connection conn=null;
	     PreparedStatement ps=null;
	   ResultSet rs=null;
public void add(Message m) { 
	if(m==null){
		return ;
	}
	String sql="insert into message(UseId,MessageContent,FriendId,FriendName,ToUserId) values(?,?,?,?,?)";
	try{
    conn=JdbcUtils.getConnection();
    ps=conn.prepareStatement(sql);
    ps.setObject(1, m.getUseId());
	 ps.setObject(2, m.getMessageContent());
	 ps.setObject(3, m.getFriendId());
	 ps.setObject(4, m.getFriendName());
	 ps.setObject(5, m.getToUserId());
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
public Message delete(Message m) {
	
	if(m==null){
		return null;
	}
	String sql="delete from message where MessageId=?";
	try{
	conn=JdbcUtils.getConnection();
	ps=conn.prepareStatement(sql);
	ps.setObject(1, m.getMessageId());
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
//
public static void main(String[] args) {
	MessageDao dao=new MessageDao();
	System.out.println(dao.selectById(1));
}
// 

public List<Message> selectByMegId( int id) {
	String sql="select * from  message WHERE MessageId = ?";
	try{
	conn=JdbcUtils.getConnection();
	ps=conn.prepareStatement(sql);
	ps.setInt(1, id); 
	rs=ps.executeQuery();
	 return transate(rs);
	}catch (Exception e) {
		e.printStackTrace();
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
public List<Message> selectAll() {
	String sql="select * from Message";
	try{
	conn=JdbcUtils.getConnection();
	ps=conn.prepareStatement(sql);
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
private List<Message> transate(ResultSet rs) throws SQLException{
	List<Message>  l=new ArrayList<Message>();
	try{
		while(rs.next()){
			Message message=new Message(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getInt(6));
			l.add(message);
		}
	}catch (Exception e) {
		// TODO: handle exception
	}
	return l;
}

public List<Message> selectById( int id) {
	String sql="select * from  message WHERE FriendId = ?";
	try{
	conn=JdbcUtils.getConnection();
	ps=conn.prepareStatement(sql);
	ps.setInt(1, id); 
	rs=ps.executeQuery();
	 return transate(rs);
	}catch (Exception e) {
		e.printStackTrace();
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


public List<Message> selectByUser( int id) {
	String sql="select * from  message WHERE ToUserId = ?";
	try{
	conn=JdbcUtils.getConnection();
	ps=conn.prepareStatement(sql);
	ps.setInt(1, id); 
	rs=ps.executeQuery();
	 return transate(rs);
	}catch (Exception e) {
		e.printStackTrace();
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

}
