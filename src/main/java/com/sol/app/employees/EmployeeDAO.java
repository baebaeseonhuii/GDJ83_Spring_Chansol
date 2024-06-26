package com.sol.app.employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sol.app.departments.DepartmentDTO;
import com.sol.app.util.DBConnection;

@Repository
public class EmployeeDAO {

	private DBConnection dbConnection = new DBConnection();

	public List<EmployeeDTO> getList() throws Exception {
		Connection con = dbConnection.getConnection();

		String sql = "SELECT * FROM EMPLOYEES ORDER BY EMPLOYEE_ID ASC";

		PreparedStatement pst = con.prepareStatement(sql);

		ResultSet rs = pst.executeQuery();

		List<EmployeeDTO> list = new ArrayList<EmployeeDTO>();

		while (rs.next()) {
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setEmployee_id(rs.getLong("EMPLOYEE_ID"));
			employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));
			employeeDTO.setLast_name(rs.getString("LAST_NAME"));
			employeeDTO.setJob_id(rs.getString("JOB_ID"));
			list.add(employeeDTO);
		}

		return list;
	}

	public EmployeeDTO getDetail(Long num) throws Exception {
		Connection con = dbConnection.getConnection();

		String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID=?";

		PreparedStatement pst = con.prepareStatement(sql);

		pst.setLong(1, num);

		ResultSet rs = pst.executeQuery();

		EmployeeDTO employeeDTO = null;
		if (rs.next()) {
			employeeDTO = new EmployeeDTO();

			employeeDTO.setEmployee_id(rs.getLong("EMPLOYEE_ID"));
			employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));
			employeeDTO.setLast_name(rs.getString("LAST_NAME"));
			employeeDTO.setEmail(rs.getString("EMAIL"));
			employeeDTO.setPhone_number(rs.getString("PHONE_NUMBER"));
			employeeDTO.setHire_date(rs.getDate("HIRE_DATE"));
			employeeDTO.setJob_id(rs.getString("JOB_ID"));
			employeeDTO.setSalary(rs.getDouble("SALARY"));
			employeeDTO.setCommission_pct(rs.getDouble("COMMISSION_PCT"));
			employeeDTO.setManager_id(rs.getLong("MANAGER_ID"));
			employeeDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
		}

		rs.close();
		pst.close();
		con.close();

		return employeeDTO;
	}

	public int add(EmployeeDTO employeeDTO) throws Exception {
		Connection con = dbConnection.getConnection();

		String sql = "INSERT INTO EMPLOYEES " + "(EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, HIRE_DATE, "
				+ "JOB_ID, SALARY, COMMISSION_PCT, MANAGER_ID, DEPARTMENT_ID) "
				+ "VALUES (EMPLOYEES_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement pst = con.prepareStatement(sql);

		pst.setString(1, employeeDTO.getFirst_name());
		pst.setString(2, employeeDTO.getLast_name());
		pst.setString(3, employeeDTO.getEmail());
		pst.setString(4, employeeDTO.getPhone_number());
		pst.setDate(5, employeeDTO.getHire_date());
		pst.setString(6, employeeDTO.getJob_id());
		pst.setDouble(7, employeeDTO.getSalary());
		pst.setDouble(8, employeeDTO.getCommission_pct());
		pst.setLong(9, employeeDTO.getManager_id());
		pst.setInt(10, employeeDTO.getDepartment_id());

		int result = pst.executeUpdate();

		return result;
	}
	
	public int delete(EmployeeDTO employeeDTO) throws Exception {
		Connection con = dbConnection.getConnection();

		String sql = "DELETE FROM EMPLOYEES WHERE EMPLOYEE_ID=?";

		PreparedStatement pst = con.prepareStatement(sql);

		pst.setLong(1, employeeDTO.getEmployee_id());

		int result = pst.executeUpdate();

		pst.close();
		con.close();

		return result;
	}

	public int update(EmployeeDTO employeeDTO) throws Exception {
		Connection con = dbConnection.getConnection();
		
		String sql = "UPDATE EMPLOYEES SET " + "FIRST_NAME=?, LAST_NAME=?, EMAIL=?, PHONE_NUMBER=?, HIRE_DATE=?, "
				+ "JOB_ID=?, SALARY=?, COMMISSION_PCT=?, MANAGER_ID=?, DEPARTMENT_ID=? "
				+ "WHERE EMPLOYEE_ID=?";

		
		PreparedStatement pst = con.prepareStatement(sql);
		
		pst.setString(1, employeeDTO.getFirst_name());
		pst.setString(2, employeeDTO.getLast_name());
		pst.setString(3, employeeDTO.getEmail());
		pst.setString(4, employeeDTO.getPhone_number());
		pst.setDate(5, employeeDTO.getHire_date());
		pst.setString(6, employeeDTO.getJob_id());
		pst.setDouble(7, employeeDTO.getSalary());
		pst.setDouble(8, employeeDTO.getCommission_pct());
		pst.setLong(9, employeeDTO.getManager_id());
		pst.setInt(10, employeeDTO.getDepartment_id());
		pst.setLong(11, employeeDTO.getEmployee_id());
		
		int result = pst.executeUpdate();
		
		pst.close();
		con.close();
		
		return result;
	}
}
