package com.sol.app.departments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sol.app.util.DBConnection;

@Repository
public class DepartmentDAO {

	@Autowired
	private DBConnection dbConnection;

	public List<DepartmentDTO> getList() throws Exception {
		Connection con = dbConnection.getConnection();

		// SQL(Query)문 작성 끝에 세미콜론은 안붙임
		String sql = "SELECT * FROM DEPARTMENTS ORDER BY DEPARTMENT_ID ASC";

		// 미리 전송
		PreparedStatement st = con.prepareStatement(sql);

		// ? 값 세팅

		// 최종 전송 및 결과 처리
		ResultSet rs = st.executeQuery();

		ArrayList<DepartmentDTO> ar = new ArrayList<DepartmentDTO>();

		while (rs.next()) {
			DepartmentDTO departmentDTO = new DepartmentDTO();
			int id = rs.getInt("DEPARTMENT_ID");
			String name = rs.getString("DEPARTMENT_NAME");
			departmentDTO.setDepartment_id(id);
			departmentDTO.setDepartment_name(name);
			departmentDTO.setManager_id(rs.getLong("MANAGER_ID"));
			departmentDTO.setLocation_id(rs.getInt("LOCATION_ID"));

			ar.add(departmentDTO);
		}

		// 자원 해제
		rs.close();
		st.close();
		con.close();

		return ar;
	}

	public DepartmentDTO getDetail(Integer num) throws Exception {
		// 1. DB 접속
		Connection con = dbConnection.getConnection();

		// 2. Query문 작성
		String sql = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID=?";

		// 3. 미리 보내기
		PreparedStatement pst = con.prepareStatement(sql);

		// 4. ? 세팅
		pst.setInt(1, num);

		// 5. 최종 전송 및 결과 처리
		ResultSet rs = pst.executeQuery();

		DepartmentDTO departmentDTO = null;

		if (rs.next()) {
			departmentDTO = new DepartmentDTO();

			departmentDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			departmentDTO.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
			departmentDTO.setManager_id(rs.getLong("MANAGER_ID"));
			departmentDTO.setLocation_id(rs.getInt("LOCATION_ID"));
		}

		// 6. 자원 해제
		rs.close();
		pst.close();
		con.close();

		return departmentDTO;
	}

	public int add(DepartmentDTO dto) throws Exception {
		// 1. DB 연결
		Connection con = dbConnection.getConnection();

		// 2. SQL 작성
		String sql = "INSERT INTO DEPARTMENTS " + "(DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID) "
				+ "VALUES (DEPARTMENTS_SEQ.NEXTVAL, ?, ?, ?)";

		// 3. 미리전송
		PreparedStatement pst = con.prepareStatement(sql);

		// 4. ?처리
		pst.setString(1, dto.getDepartment_name());
		pst.setLong(2, dto.getManager_id());
		pst.setInt(3, dto.getLocation_id());

		// 5. SQL 최종 실행
		int result = pst.executeUpdate();

		// 6. 자원 해제
		pst.close();
		con.close();

		return result;
	}

	public int delete(DepartmentDTO departmentDTO) throws Exception {
		Connection con = dbConnection.getConnection();

		String sql = "DELETE FROM DEPARTMENTS WHERE DEPARTMENT_ID=?";

		PreparedStatement pst = con.prepareStatement(sql);

		pst.setInt(1, departmentDTO.getDepartment_id());

		int result = pst.executeUpdate();

		pst.close();
		con.close();

		return result;
	}

	public int update(DepartmentDTO departmentDTO) throws Exception {
		Connection con = dbConnection.getConnection();
		
		String sql = "UPDATE DEPARTMENTS "
				+ "SET DEPARTMENT_NAME=?, MANAGER_ID=?, LOCATION_ID=? "
				+ "WHERE DEPARTMENT_ID=?";
		
		PreparedStatement pst = con.prepareStatement(sql);
		
		pst.setString(1, departmentDTO.getDepartment_name());
		pst.setLong(2, departmentDTO.getManager_id());
		pst.setInt(3, departmentDTO.getLocation_id());
		pst.setInt(4, departmentDTO.getDepartment_id());
		
		int result = pst.executeUpdate();
		
		pst.close();
		con.close();
		
		return result;
	}

}
