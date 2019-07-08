package com.techfun.springboot_assign3.service;

import java.util.List;

import com.techfun.springboot_assign3.model.Employee;

public interface EmployeeService {
	
	public void createEmployee(Employee employee);
	
	public List<Employee> findAllEmployee();
	
	public List<Employee> searchEmployee(String name);
	
	public Employee findByEmployeeId(Integer id);
	
	public void updateEmployee(Employee employee);
	
	public void deleteEmployee(Integer id);

}
