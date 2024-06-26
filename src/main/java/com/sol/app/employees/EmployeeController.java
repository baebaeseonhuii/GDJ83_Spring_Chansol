package com.sol.app.employees;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sol.app.locations.LocationDTO;
import com.sol.app.locations.LocationService;

@Controller
@RequestMapping("/employee/*")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void getList(Model model) throws Exception {
		List<EmployeeDTO> list = employeeService.getList();
		model.addAttribute("list", list);
	}

	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String getDetail(Model model, Long employee_id) throws Exception {
		EmployeeDTO employeeDTO = employeeService.getDetail(employee_id);

		String path = "/commons/message";

		if (employeeDTO != null) {
			model.addAttribute("dto", employeeDTO);
			path = "/employee/detail";

		} else {
			model.addAttribute("result", "사원을 찾을 수 없습니다");
			model.addAttribute("url", "./list");

		}

		return path;

	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add() throws Exception {

	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(Model model, EmployeeDTO EmployeeDTO) throws Exception {
		int result = employeeService.add(EmployeeDTO);

		String url = "";
		if (result > 0) {
			url = "redirect:./list";

		} else {
			url = "/commons/message";
			model.addAttribute("result", "사원 등록 실패");
			model.addAttribute("url", "./list");

		}
		return url;
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(Model model, EmployeeDTO employeeDTO) throws Exception {
		int result = employeeService.delete(employeeDTO);

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
	public String update(Model model ,Long employee_id) throws Exception {
		EmployeeDTO employeeDTO = employeeService.getDetail(employee_id);
		
		String url = "";
		
		if(employeeDTO != null) {
			url = "/employee/update";
			model.addAttribute("dto", employeeDTO);
			
		} else {
			url = "/commons/message";
			model.addAttribute("result", "존재하지 않는 사원입니다");
			model.addAttribute("url", "./list");
			
		}
		
		return url;
		
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String update(Model model, EmployeeDTO employeeDTO) throws Exception {
		int result = employeeService.update(employeeDTO);
		
		String url = "";
		
		if(result > 0) {
			url="redirect:./list";
			
		} else {
			url = "/commons/message";
			model.addAttribute("result", "사원정보 수정 실패");
			model.addAttribute("url", "./list");
			
		}
		
		return url;
	}
}
