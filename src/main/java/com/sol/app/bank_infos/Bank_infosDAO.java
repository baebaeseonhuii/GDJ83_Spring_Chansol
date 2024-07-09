package com.sol.app.bank_infos;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Bank_infosDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "com.sol.app.bank_infos.Bank_infosDAO.";
	
	public int transfer(Bank_infosDTO bank_infosDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "transfer", bank_infosDTO);
	}
	
	public int transferU(Bank_infosDTO bank_infosDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "transferU", bank_infosDTO);
	}
}
