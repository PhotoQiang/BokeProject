package com.message.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.message.pojo.Reply;
import com.util.JdbcUtils;

public class ReplyDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	// 添加回复
	public void addReply(Reply r) {
		
		if (r == null) {
			return;
		}
		Reply reply = (Reply) r;
		String sql = "insert into Reply(ReplyContent,RmessageId,userId,friendId)values(?,?,?,?)";
		try {
			conn = JdbcUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setObject(1, reply.getReplyContent());
			ps.setObject(2, reply.getRmessageId());
			ps.setObject(3, reply.getUserId());
			ps.setObject(4, reply.getFriendId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				JdbcUtils.close(conn, ps, null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	// ɾ��һ������
	public Reply deleteReply(Reply r) {
		
		if (r == null || r.getReplyId() == 0) {
			return null;
		}
		String sql = "delete from Reply where replyId=?";
		try {
			conn = JdbcUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setObject(1, r.getReplyId());
			ps.executeUpdate();
			return r;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	
	public  List<Reply>  selectByRmessage(int id){
		
		String sql="select * from reply where rmessageId=?";
		try {
			conn=JdbcUtils.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setObject(1, id);
			rs=ps.executeQuery();
			System.out.println(rs+"rsrsrsrsrsrsr");
			return transate(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			return null;
	
	}

	private List<Reply> transate(ResultSet rs) throws SQLException {
		List<Reply> l = new ArrayList<Reply>();
		try {
			while (rs.next()) {
				Reply reply = new Reply(rs.getInt("ReplyId"),
						rs.getString("ReplyContent"), rs.getInt("RmessageId"),
						rs.getInt("UserId"), rs.getInt("FriendId"));
				l.add(reply);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		} 
		return l;
	}
	
	
	
}





