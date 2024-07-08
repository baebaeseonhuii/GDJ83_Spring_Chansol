package com.sol.app.accounts;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sol.app.members.MemberDTO;

@Repository
public class AccountDAO {
	
	@Autowired
	private SqlSession sqlSession;

	private final String NAMESPACE = "com.sol.app.accounts.AccountDAO.";
	
	public int add(AccountDTO accountDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "add", accountDTO);
	}
	
	public List<AccountDTO> getList(MemberDTO memberDTO) throws Exception {
		return sqlSession.selectList(NAMESPACE + "getList", memberDTO);
	}
}
