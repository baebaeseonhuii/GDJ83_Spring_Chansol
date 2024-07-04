package com.sol.app.members;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	@Autowired
	private MemberDAO memberDAO;
	
	public int join(MemberDTO dto) throws Exception {
		return memberDAO.join(dto);
	}
	
	public MemberDTO login(MemberDTO dto) throws Exception {
		MemberDTO result = memberDAO.login(dto);
		if(result != null) {
			if(result.getMember_pw().equals(dto.getMember_pw())) {
				return result;
			} else {
				return null;
			}
		}
		return result;
	}
}
