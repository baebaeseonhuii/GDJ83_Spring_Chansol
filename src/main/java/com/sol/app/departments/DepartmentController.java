package com.sol.app.departments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/department/*") // **은 폴더 포함. *은 이하 모든 파일
public class DepartmentController {

	// IOC: Inversion of Controll
	// 객체 생성, 메서드 호출
	// @Annotaion: Controller, Service, Repository, Component

	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void getlist(Model model) throws Exception {
		List<DepartmentDTO> ar = departmentService.getList();
		
		// Model + View
		// ModelAndView mv = new ModelAndView();
		// mv.addObject("list", ar);
		// return mv;
		
		model.addAttribute("list", ar);
	}
}
