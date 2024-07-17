package com.sol.app.accounts;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sol.app.bank_infos.Bank_infosDAO;
import com.sol.app.bank_infos.Bank_infosDTO;

@Repository
public class AccountDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private Bank_infosDAO bank_infosDAO;

	private final String NAMESPACE = "com.sol.app.accounts.AccountDAO.";

	public int add(AccountDTO accountDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "add", accountDTO);
	}

	public AccountDTO detail(AccountDTO accountDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "detail", accountDTO);
	}
	
	public int transfer(Bank_infosDTO bank_infosDTO) throws Exception {
		int num = 0;
		num += sqlSession.update(NAMESPACE + "transfer", bank_infosDTO);
//		num += transferU(bank_infosDTO);
		num += sqlSession.update(NAMESPACE + "transferU", bank_infosDTO);
		num += bank_infosDAO.transfer(bank_infosDTO);
		num += bank_infosDAO.transferU(bank_infosDTO);
		return num;
	}
	
	public List<Bank_infosDTO> getList(ListOption listOption) throws Exception {
		return bank_infosDAO.getList(listOption);
	}
	
	/*
	 * public int transferU(Bank_infosDTO bank_infosDTO) throws Exception { return
	 * sqlSession.update(NAMESPACE + "transferU", bank_infosDTO); }
	 */
}
