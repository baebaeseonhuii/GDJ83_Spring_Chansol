package com.sol.app.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sol.app.util.DBConnection;

@Repository
public class ItemDAO {
	
	@Autowired
	private DBConnection dbConnection;

	public List<ItemDTO> getList() throws Exception {
		Connection con = dbConnection.getConnection();
		
		String sql = "SELECT * FROM ITEMS ORDER BY ITEM_ID DESC";
		
		PreparedStatement pst = con.prepareStatement(sql);
		
		ResultSet rs = pst.executeQuery();
		
		List<ItemDTO> list = new ArrayList<ItemDTO>();
		
		while(rs.next()) {
			ItemDTO dto = new ItemDTO();
			dto.setItem_id(rs.getLong("ITEM_ID"));
			dto.setItem_name(rs.getString("ITEM_NAME"));
			dto.setItem_detail(rs.getString("ITEM_DETAIL"));
			dto.setItem_rate(rs.getDouble("ITEM_RATE"));
			list.add(dto);
		}
		
		rs.close();
		pst.close();
		con.close();
		
		return list;
	}
	
	public ItemDTO getDetail(Long id) throws Exception{
//		List<ItemDTO> list = getList();
		
		Connection con = dbConnection.getConnection();
		
		String sql = "SELECT * FROM ITEMS WHERE ITEM_ID = ?";
		
		PreparedStatement pst = con.prepareStatement(sql);
		
		pst.setLong(1, id);
		
		ResultSet rs = pst.executeQuery();
		
		rs.next();
		
		ItemDTO dto = new ItemDTO();
		
		dto.setItem_id(rs.getLong("ITEM_ID"));
		dto.setItem_name(rs.getString("ITEM_NAME"));
		dto.setItem_detail(rs.getString("ITEM_DETAIL"));
		dto.setItem_rate(rs.getDouble("ITEM_RATE"));
		
		/*
		 * for(ItemDTO dto : list) { if(dto.getItem_id() == id) return dto; }
		 */
		rs.close();
		pst.close();
		con.close();
		return dto;
	}
	
	public void add(ItemDTO dto) throws Exception {
		Connection con = dbConnection.getConnection();
		
		String sql = "INSERT INTO ITEMS VALUES(ITEMS_SEQ.NEXTVAL, ? ,? ,?)";
		
		PreparedStatement pst = con.prepareStatement(sql);
		
		pst.setString(1, dto.getItem_name());
		pst.setString(2, dto.getItem_detail());
		pst.setDouble(3, dto.getItem_rate());
		
		pst.executeUpdate();
		
		pst.close();
		con.close();
	}
}
