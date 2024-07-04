package com.sol.app.members;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	@Autowired
	private SqlSession sqlSession;

	private final String NAMESPACE = "com.sol.app.members.MemberDAO.";

	public int join(MemberDTO dto) throws Exception {
		return sqlSession.insert(NAMESPACE + "join", dto);
	}

	public MemberDTO login(MemberDTO dto) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "login", dto);
	}
}
