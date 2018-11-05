package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtils {
//	static String url="jdbc:mysql://localhost:3306/blogs?useUnicode=true&characterEncoding=UTF-8";
//	static String user="root";
//	static String password="123456";
	
	static String url="jdbc:mysql://localhost:3306/blogs?useUnicode=true&characterEncoding=UTF-8";
	static String user="root";
	static String password="123456";


	public static void main(String[] args) throws Exception{
		System.out.println(getConnection());
	}
	
	static{

		try {
			Class.forName("com.mysql.jdbc.Driver");//Driver.class
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static  Connection getConnection() throws SQLException{
		return  DriverManager.getConnection(url, user, password);
	}
	
	public static void close(Connection conn,Statement st,ResultSet rs) throws SQLException{
		try {
			if(rs!=null)
				rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(st!=null)
					st.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				if(conn!=null)
					conn.close();
			}
		
		}
		
	}


}
