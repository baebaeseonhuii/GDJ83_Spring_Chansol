package com.sol.app.accounts;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sol.app.bank_infos.Bank_infosDTO;
import com.sol.app.members.MemberDTO;
import com.sol.app.members.MemberService;

@Controller
@RequestMapping("/accounts/*")
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private MemberService memberService;
	
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
		
		return "/commons/message";
	}
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public void getList(ListOption listOption, Model model) throws Exception {
		List<Bank_infosDTO> list = accountService.getList(listOption);
		model.addAttribute("bank_infos", list);
	}
	
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public void detail(AccountDTO accountDTO, Model model) throws Exception {
		accountDTO = accountService.detail(accountDTO);
		model.addAttribute("dto",accountDTO);
	}
	
	@RequestMapping(value="transfer", method=RequestMethod.GET)
	public void transfer (Model model, AccountDTO accountDTO) throws Exception {
		accountDTO = accountService.detail(accountDTO);
		model.addAttribute("selectedAccount", accountDTO);
	}
	
	@RequestMapping(value="transfer", method=RequestMethod.POST)
	public String transfer (HttpSession httpSession, Model model, Bank_infosDTO bank_infosDTO, String bank_pw) throws Exception {
		MemberDTO memberDTO = (MemberDTO)httpSession.getAttribute("member");
		memberDTO = memberService.detail(memberDTO);
		int num = accountService.transfer(memberDTO, bank_infosDTO, bank_pw);
		if (num == -1) {
			model.addAttribute("result", "존재하지 않는 계좌번호입니다.");
			model.addAttribute("url", "/members/mypage");
			return "/commons/message";
		}
		return "redirect:/members/mypage";
	}

}
