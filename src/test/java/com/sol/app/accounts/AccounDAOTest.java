package com.sol.app.accounts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sol.app.DefaultTest;
import com.sol.app.bank_infos.Bank_infosDTO;

public class AccounDAOTest extends DefaultTest{

	@Autowired
	private AccountDAO accountDAO;
	
	/*
	 * @Test public void detailTest() throws Exception {
	 * 
	 * AccountDTO accountDTO = new AccountDTO();
	 * accountDTO.setBank_id("00000110000000000004"); accountDTO =
	 * accountDAO.detail(accountDTO); assertNotNull(accountDTO);
	 * assertNotNull(accountDTO.getItemDTO());
	 * 
	 * }
	 */
	
	@Test
	public void transferTest() throws Exception  {
		Bank_infosDTO bank_infosDTO = new Bank_infosDTO();
		bank_infosDTO.setBank_id("00000120000000000006");
		bank_infosDTO.setAccount_u("00000110000000000004");
		bank_infosDTO.setBalance(10000L);
		bank_infosDTO.setDifference(5000L);
		
		assertEquals(4, accountDAO.transfer(bank_infosDTO));
	}

}
