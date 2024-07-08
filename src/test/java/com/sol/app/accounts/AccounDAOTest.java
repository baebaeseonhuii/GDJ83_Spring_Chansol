package com.sol.app.accounts;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sol.app.DefaultTest;

public class AccounDAOTest extends DefaultTest{

	@Autowired
	private AccountDAO accountDAO;
	
	@Test
	public void detailTest() throws Exception {
		
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setBank_id("00000110000000000004");
		accountDTO = accountDAO.detail(accountDTO);
		assertNotNull(accountDTO);
		assertNotNull(accountDTO.getItemDTO());
		
	}

}
