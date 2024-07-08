package com.sol.app.accounts;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sol.app.members.MemberDTO;

@Controller
@RequestMapping("/accounts/*")
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value="add", method=RequestMethod.GET)
	public void add() throws Exception {
		
	}
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public String add(AccountDTO accountDTO, HttpSession httpSession, Model model) throws Exception {
		MemberDTO memberDTO = (MemberDTO)httpSession.getAttribute("member");
		
		accountDTO.setMember_id(memberDTO.getMember_id());
		
		System.out.println(accountDTO.getItem_id());
		System.out.println(accountDTO.getBank_pw());
		
		accountDTO.setBalance(0L);
		
		int num = accountService.add(accountDTO);
		
		if(num > 0) {
			model.addAttribute("result", "계좌 생성 완료");
			model.addAttribute("url", "/");
		} else {
			model.addAttribute("result", "계좌 생성 실패");
			model.addAttribute("url", "/");
		}
		
		return "/commons/messages";
	}
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public void getList() throws Exception {
		
	}
}
