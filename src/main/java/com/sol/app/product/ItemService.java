package com.sol.app.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sol.app.util.Pager;

@Service
public class ItemService {

	@Autowired
	private ItemDAO itemDAO;

	public List<ItemDTO> getList(Pager pager) throws Exception {
		// page가 1이면 page 2 3
		// 첫번째 숫자 1 11 21
		// 두번째 숫자 10 20 30
		if (pager.getPage() == null) pager.setPage(1L);

		Long perPage = 10L;
		pager.setPerPage(10L);
		pager.setLastRow(pager.getPage()*pager.getPerPage());
		pager.setStartRow(pager.getLastRow()-pager.getPerPage()+1L);
		
		pager.setTotalCount(itemDAO.countList());
		
		pager.setTotalPage((long) Math.ceil((double) pager.getTotalCount() / pager.getPerPage()));
		
		System.out.println(pager.getTotalPage());
		
		return itemDAO.getList(pager);
//		return itemDAO.getList(map);
	}

	public ItemDTO getDetail(ItemDTO dto) throws Exception {
		return itemDAO.getDetail(dto);
	}

	public int add(ItemDTO dto) throws Exception {
		return itemDAO.add(dto);
	}

	public int delete(ItemDTO dto) throws Exception {
		return itemDAO.delete(dto);
	}

	public int update(ItemDTO dto) throws Exception {
		return itemDAO.update(dto);
	}
}
