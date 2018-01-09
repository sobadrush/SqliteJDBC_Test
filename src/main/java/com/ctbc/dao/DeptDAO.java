package com.ctbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ctbc.vo.DeptVO;

public class DeptDAO {
	private static final String GET_ALL_STMT = "SELECT * FROM z40180_deptTB";

	static {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public List<DeptVO> getAll() {
		List<DeptVO> dList = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:testDB.db");
			PreparedStatement pstmt = conn.prepareStatement(GET_ALL_STMT);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				DeptVO deptVO = new DeptVO();
				deptVO.setDeptNo(rs.getInt("deptno"));
				deptVO.setDeptName(rs.getString("dname"));
				deptVO.setDeptLoc(rs.getString("loc"));
				dList.add(deptVO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dList;
	}

}
