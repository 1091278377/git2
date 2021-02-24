package com.luoxc.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.luoxc.pojo.Aaa;
import com.luoxc.pojo.Commodity;





public class JDBCUtil {
	private static String DriverClass = null;
	private static String URL = null;
	private static String userName = null;
	private static String passWord = null;
	private static final ThreadLocal thread_local_db = new ThreadLocal();
	static {
		try {
			Properties ps = new Properties();
			String path = JDBCUtil.class.getClassLoader().getResource("").toURI().getPath();
			InputStream is = new FileInputStream(JDBCUtil.class.getResource("/").getPath()+"jdbc.properties");
			ps.load(is);
			DriverClass = ps.getProperty("driverClass");
			URL = ps.getProperty("url");
			passWord = ps.getProperty("passWord");
			userName = ps.getProperty("userName");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	// 获取连接
	public static Connection getConn() {
		Connection Conn = (Connection) thread_local_db.get();
		try {
			if (Conn == null) {
				Class.forName(DriverClass);
				Conn = DriverManager.getConnection(URL, userName, passWord);
				thread_local_db.set(Conn);// 把连接对象放入线程池
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Conn;
	}

	public static void release(Connection Conn, ResultSet rs2, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (Conn != null) {
				Conn.close();
			}
			if (rs2 != null) {
				rs2.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rs = null;
			rs2 = null;
			Conn = null;
		}
	}

	public static void release(Aaa conn, Aaa pt, Aaa rs) {
		// TODO Auto-generated method stub
		
	}

	public static void release(Commodity conn, Commodity pt, Commodity rs) {
		// TODO Auto-generated method stub
		
	}





}

