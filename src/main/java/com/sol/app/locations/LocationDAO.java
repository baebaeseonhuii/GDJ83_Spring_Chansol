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
		
		while(rs.next()) {
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
}