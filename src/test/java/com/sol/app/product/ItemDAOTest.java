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
	public void pageTest() {
		long perPage = 10L;
		long[] totalCount = new long[101];
		for (int i = 1; i < 101; i++) {
			totalCount[i] = i;
			long totalPage = (long) Math.ceil((double) totalCount[i] / perPage);
			System.out.println(totalCount[i] + ": " + totalPage);
		}
	}

	public void addTest2() throws Exception {
		ItemDTO itemDTO = new ItemDTO();
		for (int i = 0; i < 100; i++) {
			itemDTO.setItem_name("addTest2_" + i);
			Double rate = (int) (Math.random() * 1000) / 100.0;
			itemDTO.setItem_rate(rate);
			itemDTO.setItem_detail("detail" + i);
			itemDAO.add(itemDTO);
			Thread.sleep(50);
		}
		System.out.println("====== Finish ======");
	}

	public void getDetailTest() throws Exception {
		ItemDTO itemDTO = new ItemDTO();
		itemDTO.setItem_id(1L);
		itemDTO = itemDAO.getDetail(itemDTO);
		// 단정문
		assertNotNull(itemDTO);
	}

	public void addTest() throws Exception {
		ItemDTO itemDTO = new ItemDTO();
		itemDTO.setItem_name("TEST02");
		itemDTO.setItem_detail("test용 상품입니다.");
		itemDTO.setItem_rate(99.99);

		assertNotEquals(0, itemDAO.add(itemDTO));
//		assertNull(itemDAO.add(itemDTO));
	}
}
