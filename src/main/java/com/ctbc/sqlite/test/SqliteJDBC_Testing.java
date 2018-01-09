package com.ctbc.sqlite.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqliteJDBC_Testing {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
	  	Connection conn = DriverManager.getConnection("jdbc:sqlite:testDB.db");
//	  	DatabaseMetaData metaData = conn.getMetaData();
//	  	System.out.println(metaData.getDatabaseProductName());
	  	
	  	PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM z40180_deptTB ");
	  	ResultSet rs = pstmt.executeQuery();
	  	while (rs.next()) {
			System.out.println(rs.getString("deptno"));
			System.out.println(rs.getString("dname"));
			System.out.println(rs.getString("loc"));
		}
	}

}
