package com.sol.app.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sol.app.util.Pager;

@Service
public class NoticeService {
	@Autowired
	private NoticeDAO noticeDAO;

	public List<NoticeDTO> getList(Pager pager) throws Exception {
		pager.setPerBlock(5L);
		if(pager.getSearch() == null) pager.setSearch("");
		if(pager.getPage() == null || pager.getPage() < 1L) pager.setPage(1L);
		if(pager.getKind() == null)pager.setKind("k1");
		if(pager.getPerPage() == null)pager.setPerPage(10L);
		
		pager.setTotalCount(noticeDAO.countList(pager));
		
		pager.setTotalPage(pager.getTotalCount()/pager.getPerPage());
		if(pager.getTotalCount()%pager.getPerPage() != 0L) {
			pager.setTotalPage(pager.getTotalCount()/pager.getPerPage() + 1L);
		}
		
		if(pager.getPage() > pager.getTotalPage())pager.setPage(pager.getTotalPage());
		
		pager.setTotalBlock(pager.getTotalPage()/pager.getPerBlock());
		if(pager.getTotalPage()*pager.getPerBlock() != 0L) {
			pager.setTotalBlock(pager.getTotalPage()/pager.getPerBlock() + 1L);
		}
		
		pager.setCurBlock(pager.getPage()/pager.getPerBlock());
		if(pager.getPage()%pager.getPerBlock() != 0L) {
			pager.setCurBlock(pager.getPage()/pager.getPerBlock()+1L);
		}
		
		pager.setStartNum((pager.getCurBlock()-1L)*pager.getPerBlock()+1L);
		pager.setLastNum(pager.getStartNum() + pager.getPerBlock() - 1L);
		if(pager.getLastNum() > pager.getTotalPage()) pager.setLastNum(pager.getTotalPage());
		if(pager.getStartNum() > pager.getLastNum()) pager.setStartNum(pager.getLastNum() + 1L);
		
		pager.setStartRow((pager.getPage()-1L) * pager.getPerPage() +1L);
		pager.setLastRow(pager.getStartRow() + pager.getPerPage() - 1L);
		
		return noticeDAO.getList(pager);
	}

	public NoticeDTO getDetail(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.getDetail(noticeDTO);
	}
	
	public void hit(NoticeDTO noticeDTO) throws Exception {
		noticeDAO.hit(noticeDTO);
	}

	public int update(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.update(noticeDTO);
	}

	public int add(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.add(noticeDTO);
	}

	public int delete(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.delete(noticeDTO);
	}
}
