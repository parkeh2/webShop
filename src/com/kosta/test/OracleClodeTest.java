package com.kosta.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleClodeTest {

//	String DB_URL = "jdbc:oracle:thin:@kosta226_medium?TNS_ADMIN=D:/KOSTA/Wallet_kosta226/";
	String DB_URL = "jdbc:oracle:thin:@cometdb1_medium?TNS_ADMIN=D:/KOSTA/2/Wallet_cometdb1/";
	String DB_USER = "admin";
	String DB_PASSWORD = "Kosta226kosta";

	public void test() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		System.out.println(conn);
		String sql = "select * from casting";
		Statement st = null;
		ResultSet rs = null;
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		while (rs.next()) {
			System.out.println(rs.getString(2));
		}
		rs.close();
		st.close();
		conn.close();
	}

}