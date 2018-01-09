package com.ctbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ctbc.vo.EmpVO;

public class EmpDAO {
	private static final String GET_ALL_STMT = "SELECT * FROM z40180_empTB";

	static {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public List<EmpVO> getAll() {
		List<EmpVO> eList = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:testDB.db");
			PreparedStatement pstmt = conn.prepareStatement(GET_ALL_STMT);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				EmpVO empVO = new EmpVO();
				empVO.setEmpNo(rs.getInt("empno"));
				empVO.setEmpName(rs.getString("ename"));
				empVO.setEmpJob(rs.getString("job"));
				empVO.setEmpHireDate(java.sql.Date.valueOf(rs.getString("hiredate")));
				empVO.setDeptNo(rs.getInt("deptno"));
				eList.add(empVO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return eList;
	}
}
