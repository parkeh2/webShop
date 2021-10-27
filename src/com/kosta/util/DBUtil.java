package com.kosta.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {

	public static void dbClose(Connection conn, Statement st, ResultSet rs) {
		//�ڿ��ݳ�
		try {
			if(rs!=null) rs.close();
			if(st!=null) st.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection dbConnect(String path) {
		//DB���� 
		Connection conn = null;
		String url, id, pass;
	 
		try {
			//class memory load , instance ����ϴ� ��� 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Properties pro = new Properties();
			path=path + "\\WEB-INF\\dbinfo.properties";
			pro.load(new FileReader(path));
			url = pro.getProperty("url");
			id = pro.getProperty("userid");
			pass = pro.getProperty("password");				
			conn = DriverManager.getConnection(url, id, pass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
