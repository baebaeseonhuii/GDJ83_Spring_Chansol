package com.sol.app.employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sol.app.util.DBConnection;

@Repository
public class EmployeeDAO {
	
	private DBConnection dbConnection = new DBConnection();
	
	public List<EmployeeDTO> getList() throws Exception{
		Connection con = dbConnection.getConnection();
		
		String sql = "SELECT * FROM EMPLOYEES ORDER BY EMPLOYEE_ID ASC";
		
		PreparedStatement pst = con.prepareStatement(sql);
		
		ResultSet rs = pst.executeQuery();
		
		List<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
		
		while(rs.next()) {
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setEmployee_id(rs.getLong("EMPLOYEE_ID"));
			employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));
			employeeDTO.setLast_name(rs.getString("LAST_NAME"));
			employeeDTO.setJob_id(rs.getString("JOB_ID"));
			list.add(employeeDTO);
		}
		
		return list;
	}
}
