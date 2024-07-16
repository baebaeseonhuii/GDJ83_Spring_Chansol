package com.sol.app.notice;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sol.app.DefaultTest;
import com.sol.app.boards.BoardDTO;
import com.sol.app.boards.notices.NoticeDAO;
import com.sol.app.boards.notices.NoticeDTO;
import com.sol.app.util.Pager;

public class NoticeDAOTest extends DefaultTest {

	@Autowired
	private NoticeDAO noticeDAO;

	private Pager pager;
	private NoticeDTO noticeDTO;

	@Before
	public void before() throws Exception {
		pager = new Pager();
		pager.setSearch("");
		pager.setKind("k1");
		pager.setStartRow(1L);
		pager.setLastRow(100L);

		noticeDTO = new NoticeDTO();
		noticeDTO.setBoardWriter("kk3223");
	}

	@Test
	public void getListTest() throws Exception {
		List<BoardDTO> list = noticeDAO.getList(pager);
		for(BoardDTO dto : list) {
			System.out.println(dto.getBoardTitle());
		}
	}

	
	public void addTest() throws Exception {
		System.out.println("?");
		for (int i = 1; i <= 100; i++) {
			noticeDTO.setBoardTitle("Test Title" + i);
			noticeDTO.setBoardContents("Test Contents" + i);
			noticeDAO.add(noticeDTO);
			Thread.sleep(50);
		}
		System.out.println("!");
	}

}
