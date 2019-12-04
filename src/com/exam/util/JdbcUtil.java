package com.exam.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtil {
	static ComboPooledDataSource dataSource=null;
	static{
		 dataSource =new ComboPooledDataSource();	
	}
	
	
	public static Connection getConn() throws SQLException
	{
		return dataSource.getConnection();	
	}
	public static ComboPooledDataSource GetDataSource()
	{
		
		return dataSource;
	}
	
	public static void close(Connection conn , Statement st , ResultSet rs) 
	{
	  if(conn!=null)
	  {
		  try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	  }
	  
	  
	  if(st!=null)
		try {
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	  if(rs!=null)
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
		
	}
	
}
