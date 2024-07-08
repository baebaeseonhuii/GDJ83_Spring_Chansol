package com.sol.app.product;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sol.app.DefaultTest;

public class ItemDAOTest extends DefaultTest {

	@Autowired
	private ItemDAO itemDAO;
	
	@Test
	public void getDetailTest() throws Exception {
		ItemDTO itemDTO = new ItemDTO();
		itemDTO.setItem_id(1L);
		itemDTO = itemDAO.getDetail(itemDTO);
		//단정문
		assertNotNull(itemDTO);
	}
	
	@Test
	public void addTest() throws Exception {
		ItemDTO itemDTO = new ItemDTO();
		itemDTO.setItem_name("TEST02");
		itemDTO.setItem_detail("test용 상품입니다.");
		itemDTO.setItem_rate(99.99);
		
		assertNotEquals(0, itemDAO.add(itemDTO));
//		assertNull(itemDAO.add(itemDTO));
	}
}
