package com.sol.app.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
	
	@Autowired
	private ItemDAO itemDAO;
	
	public List<ItemDTO> getList() throws Exception {
		return itemDAO.getList();
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
