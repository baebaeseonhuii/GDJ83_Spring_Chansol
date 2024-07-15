package com.sol.app.boards.notices;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sol.app.members.MemberDTO;
import com.sol.app.util.Pager;

@Controller
@RequestMapping(value="/notice/")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String getList(Pager pager, Model model) throws Exception {
		List<NoticeDTO> list = noticeService.getList(pager);
		if(list == null) {
			model.addAttribute("result", "게시글이 존재하지 않습니다");
			model.addAttribute("url", "/notice/list");
			return "/commons/message"; 
		}
		model.addAttribute("list", list);
		return "/notice/list";
	}

	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public void getDetail(NoticeDTO noticeDTO, Model model) throws Exception {
		hit(noticeDTO);
		noticeDTO = noticeService.getDetail(noticeDTO);
		model.addAttribute("dto", noticeDTO);
	}
	
	public void hit(NoticeDTO noticeDTO) throws Exception {
		noticeService.hit(noticeDTO);
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update(Model model, NoticeDTO noticeDTO) throws Exception {
		noticeDTO = noticeService.getDetail(noticeDTO);
		model.addAttribute("dto", noticeDTO);
		return "notice/write";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(NoticeDTO noticeDTO) throws Exception {
		int num = noticeService.update(noticeDTO);
		return "redirect:detail?boardNum=" + noticeDTO.getBoardNum();
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add() throws Exception {
		return "notice/write";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(Pager pager, NoticeDTO noticeDTO, HttpSession httpSession) throws Exception {
		MemberDTO memberDTO = (MemberDTO) httpSession.getAttribute("member");
		noticeDTO.setBoardWriter(memberDTO.getMember_id());
		int num = noticeService.add(noticeDTO);
		return "redirect:list";
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(NoticeDTO noticeDTO) throws Exception {
		int num = noticeService.delete(noticeDTO);
		return "redirect:list";
	}
}
