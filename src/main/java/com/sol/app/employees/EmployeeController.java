package com.sol.app.employees;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/employee/*")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public void getList(Model model) throws Exception {
		List<EmployeeDTO> list = employeeService.getList();
		model.addAttribute("list", list);
	}
}
