package com.briup.ch08.common.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class ConnectionFactory {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	
	static {
		driver = "com.mysql.jdbc.Driver";
		//jdbc:mysql://ip:port/dbName
		url="jdbc:mysql://127.0.0.1:3306/wy";
		user = "root";
		password = "root";
		
	}
	/**
	 * 静态方法
	 * */
	public static Connection getConn() throws Exception{
		//加载驱动
		Class.forName(driver);
		//获取连接
		Connection con =  DriverManager.getConnection(url, user, password);
		//System.out.println(con);
		return con;
	}
	
	@Test
	public void test() throws Exception{
		ConnectionFactory.getConn();
	}
	
	public static void close(ResultSet rs,PreparedStatement pstmt,Connection conn) throws SQLException{
		if(rs!=null){
			rs.close();
		}
		if(pstmt!=null){
			pstmt.close();
		}
		if(conn!=null){
			conn.close();
		}
	}
}
