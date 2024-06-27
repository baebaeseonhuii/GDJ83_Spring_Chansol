package com.sol.app.departments;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
		List<DepartmentDTO> list = departmentService.getList();
		List<Map<String, Object>> info = departmentService.getInfo();
		
//		Model + View
//		mv.addObject("list", ar);
//		mv.setViewName("department/list");

		model.addAttribute("list", list);
		model.addAttribute("info", info);
	}

	@RequestMapping(value = "detail", method = RequestMethod.GET)
	// 미쳤네,, 그냥 파라미터 key값을 이름으로 하는 매개변수를 넣어준다
	public String getDetail(Model model, @RequestParam(defaultValue = "10") Integer department_id) throws Exception {
		DepartmentDTO departmentDTO = departmentService.getDetail(department_id);

		String path = "commons/message";

		if (departmentDTO != null) {
			model.addAttribute("dto", departmentDTO);
			path = "department/detail";

		} else {
			model.addAttribute("result", "부서를 찾을 수 없습니다");
			model.addAttribute("url", "./list");

		}

		return path;

	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add() throws Exception {

	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(Model model, DepartmentDTO departmentDTO) throws Exception {
		int result = departmentService.add(departmentDTO);

		String url = "";

		if (result > 0) {
			url = "redirect:./list";

		} else {
			url = "/commons/message";
			model.addAttribute("result", "부서 등록 실패");
			model.addAttribute("url", "./list");

		}

		return url;
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(Model model, DepartmentDTO departmentDTO) throws Exception {
		int result = departmentService.delete(departmentDTO);

		String url = "";

		if (result > 0) {
			url = "redirect:./list";
			
		} else {
			url = "/commons/message";
			model.addAttribute("result", "부서 삭제 실패");
			model.addAttribute("url", "./list");
			
		}
		
		return url;
	}
	
	@RequestMapping(value="update", method=RequestMethod.GET)
	public String update(Model model ,Integer department_id) throws Exception {
		DepartmentDTO departmentDTO = departmentService.getDetail(department_id);
		
		String url = "";
		
		if(departmentDTO != null) {
			url = "/department/update";
			model.addAttribute("dto", departmentDTO);
			
		} else {
			url = "/commons/message";
			model.addAttribute("result", "존재하지 않는 부서입니다");
			model.addAttribute("url", "./list");
			
		}
		
		return url;
		
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String update(Model model, DepartmentDTO departmentDTO) throws Exception {
		int result = departmentService.update(departmentDTO);
		
		String url = "";
		
		if(result > 0) {
			url="redirect:./list";
			
		} else {
			url = "/commons/message";
			model.addAttribute("result", "부서 수정 실패");
			model.addAttribute("url", "./list");
			
		}
		
		return url;
	}
}
