package com.sol.app.boards.qnas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sol.app.boards.BoardDTO;
import com.sol.app.boards.BoardService;
import com.sol.app.util.Pager;

@Service
public class QnaService implements BoardService {

	@Autowired
	private QnaDAO qnaDAO;
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		//1. rowNum 계산
		pager.makeRow();
		
		//2. page 계산
		pager.makeNum(qnaDAO.countList(pager));
		
		
		return qnaDAO.getList(pager);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return qnaDAO.getDetail(boardDTO);
	}

	@Override
	public void hit(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		return qnaDAO.update(boardDTO);
	}

	@Override
	public int add(BoardDTO boardDTO) throws Exception {
		return qnaDAO.add(boardDTO);
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		return qnaDAO.delete(boardDTO);
	}
	
	public int reply(QnaDTO qnaDTO) throws Exception {
		QnaDTO parent = (QnaDTO)getDetail(qnaDTO);
		//1. STEP을 +1씩 업데이트
		int result = qnaDAO.replyUpdate(parent);
		
		//2. 답글의 REF, STEP, DEPTH 세팅
		qnaDTO.setRef(parent.getRef());
		qnaDTO.setStep(parent.getStep() + 1L);
		qnaDTO.setDepth(parent.getDepth() + 1L);
		if(qnaDTO.getBoardContents() == null) qnaDTO.setBoardContents(" ");
		return qnaDAO.reply(qnaDTO);
	}
	
}
