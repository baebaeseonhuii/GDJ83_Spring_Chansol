package com.sol.app.utilgit;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectiongit {
	
	public Connection getConnection() throws Exception {
		String username = "";
		String password = "";
		
		String url  = "jdbc:oracle:thin:@ip:port:sid";
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Class.forName(driver);
		
		Connection con = DriverManager.getConnection(url, username, password);
		
		return con;
	}
}
