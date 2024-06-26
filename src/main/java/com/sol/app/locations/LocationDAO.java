package com.sol.app.locations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sol.app.util.DBConnection;

@Repository
public class LocationDAO {

	@Autowired
	private DBConnection dbConnection;

	public List<LocationDTO> getList() throws Exception {
		Connection con = dbConnection.getConnection();
		String sql = "SELECT * FROM LOCATIONS ORDER BY LOCATION_ID ASC";

		PreparedStatement pst = con.prepareStatement(sql);

		ResultSet rs = pst.executeQuery();

		List<LocationDTO> list = new ArrayList<LocationDTO>();

		while (rs.next()) {
			LocationDTO locationDTO = new LocationDTO();
			locationDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			locationDTO.setStreet_address(rs.getString("STREET_ADDRESS"));
			locationDTO.setPostal_code(rs.getString("POSTAL_CODE"));
			locationDTO.setCity(rs.getString("CITY"));
			locationDTO.setState_province(rs.getString("STATE_PROVINCE"));
			locationDTO.setCountry_id(rs.getString("COUNTRY_ID"));
			list.add(locationDTO);
		}

		rs.close();
		pst.close();
		con.close();

		return list;
	}

	public LocationDTO getDetail(Integer num) throws Exception {

		Connection con = dbConnection.getConnection();

		String sql = "SELECT * FROM LOCATIONS WHERE LOCATION_ID=?";

		PreparedStatement pst = con.prepareStatement(sql);

		pst.setInt(1, num);

		ResultSet rs = pst.executeQuery();

		LocationDTO locationDTO = null;
		if (rs.next()) {
			locationDTO = new LocationDTO();

			locationDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			locationDTO.setStreet_address(rs.getString("STREET_ADDRESS"));
			locationDTO.setPostal_code(rs.getString("POSTAL_CODE"));
			locationDTO.setCity(rs.getString("CITY"));
			locationDTO.setState_province(rs.getString("STATE_PROVINCE"));
			locationDTO.setCountry_id(rs.getString("COUNTRY_ID"));
		}

		rs.close();
		pst.close();
		con.close();

		return locationDTO;
	}

	public int add(LocationDTO locationDTO) throws Exception {
		Connection con = dbConnection.getConnection();

		String sql = "INSERT INTO LOCATIONS "
				+ "(LOCATION_ID, STREET_ADDRESS, POSTAL_CODE, CITY, STATE_PROVINCE, COUNTRY_ID) "
				+ "VALUES (LOCATIONS_SEQ.NEXTVAL, ?, ?, ?, ?, ?)";

		PreparedStatement pst = con.prepareStatement(sql);

		pst.setString(1, locationDTO.getStreet_address());
		pst.setString(2, locationDTO.getPostal_code());
		pst.setString(3, locationDTO.getCity());
		pst.setString(4, locationDTO.getState_province());
		pst.setString(5, locationDTO.getCountry_id());

		int result = pst.executeUpdate();

		return result;
	}
}
