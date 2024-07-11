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

	public Map<String, Object> getList(Pager pager) throws Exception {
		// page가 1이면 page 2 3
		// 첫번째 숫자 1 11 21
		// 두번째 숫자 10 20 30
		if (pager.getPage() == null || pager.getPage() < 1) pager.setPage(1L);

		Long perPage = 10L;
		pager.setPerPage(10L);

		pager.setTotalCount(itemDAO.countList());
		
		//1. 총 개수를 이용해서 총 페이지수 구하기
		pager.setTotalPage((long) Math.ceil((double) pager.getTotalCount() / pager.getPerPage()));

		//2. 총 페이지수를 이용해서 총 블럭수 구하기
		long perBlock = 5L;
		pager.setPerBlock(perBlock);
		
		long totalBlock = (long) Math.ceil((double) pager.getTotalPage() / pager.getPerBlock());
		pager.setTotalBlock(totalBlock);

		//3. 현재 페이지 번호로 현재 블록 번호를 구하기
		long curBlock = (long) Math.ceil((double) pager.getPage() / pager.getPerBlock());
		pager.setCurBlock(curBlock);
		
		//4. 현재 블럭 번호로 시작 번호와 끝번호 구하기
		long lastNum = curBlock*pager.getPerBlock();
		long startNum = lastNum - pager.getPerBlock() + 1L;
		lastNum = lastNum > pager.getTotalPage() ? pager.getTotalPage() : lastNum;
		startNum = startNum > lastNum ? lastNum + 1L: startNum;
		
		pager.setLastNum(lastNum);
		pager.setStartNum(startNum);
 
		if(pager.getPage() > pager.getTotalPage()) pager.setPage(pager.getTotalPage());
		// page 1 2 3 4 5 6 7 8 9 10 11
		// start 1 1 1 1 1 6 6 6 6 6 11
		// last 5 5 5 5 5 10 10 10 10 10 15

		System.out.println(pager.getTotalPage());
		
		pager.setLastRow(pager.getPage() * pager.getPerPage());
		pager.setStartRow(pager.getLastRow() - pager.getPerPage() + 1L);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", itemDAO.getList(pager));
		map.put("pager", pager);

		return map;
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
