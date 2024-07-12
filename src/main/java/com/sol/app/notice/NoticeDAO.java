package com.sol.app.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sol.app.util.Pager;

@Repository
public class NoticeDAO {
	
	@Autowired
	private SqlSession sqlSession;

	private final String NAMESPACE = "com.sol.app.notice.NoticeDAO.";
	
	public List<NoticeDTO> getList(Pager pager) throws Exception {
		Long result = sqlSession.selectOne(NAMESPACE + "countSearch", pager);
		if(result == 0L) return null;
		return sqlSession.selectList(NAMESPACE + "getList", pager);
	}

	public NoticeDTO getDetail(NoticeDTO noticeDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getDetail", noticeDTO);
	}
	
	public void hit(NoticeDTO noticeDTO) throws Exception {
		sqlSession.update(NAMESPACE + "hit", noticeDTO);
	}

	public int update(NoticeDTO noticeDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "update", noticeDTO);

	}

	public int add(NoticeDTO noticeDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "add", noticeDTO);

	}

	public int delete(NoticeDTO noticeDTO) throws Exception {
		return sqlSession.delete(NAMESPACE + "delete", noticeDTO);

	}
	
	public Long countList (Pager pager) {
		return sqlSession.selectOne(NAMESPACE + "countList", pager);
	}
}
