package com.sol.app.employees;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;

	public List<EmployeeDTO> getList() throws Exception {
		return employeeDAO.getList();
	}

	public EmployeeDTO getDetail(Long num) throws Exception {
		return employeeDAO.getDetail(num);
	}

	public int add(EmployeeDTO employeeDTO) throws Exception {
		return employeeDAO.add(employeeDTO);
	}
}
