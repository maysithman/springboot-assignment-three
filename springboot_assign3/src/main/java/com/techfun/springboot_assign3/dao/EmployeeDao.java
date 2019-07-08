package com.techfun.springboot_assign3.dao;

import java.util.List;

import com.techfun.springboot_assign3.model.Employee;

public interface EmployeeDao {

	public void createEmployee(Employee employee);
	
	public List<Employee> findAllEmployee();
	
	public List<Employee> searchEmployee(String name);
	
	public Employee findByEmployeeId(Integer id);
	
	public void updateEmployee(Employee employee);
	
	public void deleteEmployee(Integer id);
	
}
