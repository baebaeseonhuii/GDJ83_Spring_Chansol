package com.sol.app.boards;

import java.util.List;

import com.sol.app.util.Pager;

public interface BoardService {
	public List<BoardDTO> getList(Pager pager) throws Exception;

	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception;

	public void hit(BoardDTO boardDTO) throws Exception;

	public int update(BoardDTO boardDTO) throws Exception;

	public int add(BoardDTO boardDTO) throws Exception;

	public int delete(BoardDTO boardDTO) throws Exception;
}
