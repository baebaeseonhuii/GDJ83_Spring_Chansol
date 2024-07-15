package com.sol.app.boards.qnas;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.sol.app.boards.BoardDAO;
import com.sol.app.boards.BoardDTO;
import com.sol.app.util.Pager;

public class QnaDAO implements BoardDAO{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void hit(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int add(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Long countList(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
