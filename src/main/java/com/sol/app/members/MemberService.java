package com.sol.app.members;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sol.app.accounts.AccountDAO;
import com.sol.app.accounts.AccountDTO;

@Service
public class MemberService {
	@Autowired
	private MemberDAO memberDAO;

	@Autowired
	private AccountDAO accountDAO;
	
	public int join(MemberDTO dto) throws Exception {
		return memberDAO.join(dto);
	}

	public MemberDTO login(MemberDTO memberDTO) throws Exception {
		MemberDTO result = memberDAO.login(memberDTO);
		if (result != null) {
			if (result.getMember_pw().equals(memberDTO.getMember_pw())) {
				// 로그인 성공 지점
				return result;
				
			} else {
				return null;
				
			}
		}
		
		return result;
	}

	public int update(MemberDTO dto) throws Exception {
		return memberDAO.update(dto);
	}

	public int delete(MemberDTO dto) throws Exception {
		return memberDAO.delete(dto);
	}
	
	public MemberDTO detail(MemberDTO dto) throws Exception {
		return memberDAO.detail(dto);
	}
}
