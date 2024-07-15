package com.sol.app.boards.notices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sol.app.boards.BoardDAO;
import com.sol.app.boards.BoardDTO;
import com.sol.app.boards.BoardService;
import com.sol.app.util.Pager;

@Service
public class NoticeService implements BoardService {
	
	@Autowired
	@Qualifier("noticeDAO")
	private BoardDAO boardDAO;

	public List<BoardDTO> getList(Pager pager) throws Exception {
		
		pager.makeRow();
		pager.makeNum(boardDAO.countList(pager));
		
		return boardDAO.getList(pager);
	}

	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return boardDAO.getDetail(boardDTO);
	}
	
	public void hit(BoardDTO boardDTO) throws Exception {
		boardDAO.hit(boardDTO);
	}

	public int update(BoardDTO boardDTO) throws Exception {
		return boardDAO.update(boardDTO);
	}

	public int add(BoardDTO boardDTO) throws Exception {
		return boardDAO.add(boardDTO);
	}

	public int delete(BoardDTO boardDTO) throws Exception {
		return boardDAO.delete(boardDTO);
	}
}
