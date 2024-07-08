package com.sol.app.members;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sol.app.DefaultTest;
import com.sol.app.accounts.AccountDTO;

public class MemberDAOTest extends DefaultTest {

	@Autowired
	private MemberDAO memberDAO;

	@Test
	public void loginTest() throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setMember_id("kk3223");
		memberDTO = memberDAO.login(memberDTO);
		
		assertEquals(1, memberDTO.getDtos().size());
		
	}

}
