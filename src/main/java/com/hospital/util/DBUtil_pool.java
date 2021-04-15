package com.hospital.util;
/**
 * 数据库连接池技术
 * @author Administrator
 *
 */

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil_pool {
	private static ComboPooledDataSource dateSource=new ComboPooledDataSource();

	/**
	 * 链接
	 * @return conn
	 */
	public static Connection getConnection() {
		Connection conn=null;
		try {
			conn=dateSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	/**
	 * 释放资源
	 * c3p0不需要conn.close
	 * @param stat
	 * @param rs
	 */
	public static void closeReSource(Statement stat,ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//释放资源
		}
		if(stat!=null) {
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//释放资源
		}
//		if(conn!=null) {
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}//释放资源
//		}
	}

}
