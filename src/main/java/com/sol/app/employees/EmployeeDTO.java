package com.sol.app.employees;

import java.sql.Date;

public class EmployeeDTO {
	private Long employee_id;
	private String first_name;
	private String last_name;
	private String email;
	private String phone_number;
	private Date hire_date;
	private String job_id;
	private Double salary;
	private Double commision_pct;
	private Long manager_id;
	private Long department_id;
	
	public Long getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(Long employee_id) {
		this.employee_id = employee_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public Date getHire_date() {
		return hire_date;
	}
	public void setHire_date(Date hire_date) {
		this.hire_date = hire_date;
	}
	public String getJob_id() {
		return job_id;
	}
	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Double getCommision_pct() {
		return commision_pct;
	}
	public void setCommision_pct(Double commision_pct) {
		this.commision_pct = commision_pct;
	}
	public Long getManager_id() {
		return manager_id;
	}
	public void setManager_id(Long manager_id) {
		this.manager_id = manager_id;
	}
	public Long getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(Long department_id) {
		this.department_id = department_id;
	}

	 
}
