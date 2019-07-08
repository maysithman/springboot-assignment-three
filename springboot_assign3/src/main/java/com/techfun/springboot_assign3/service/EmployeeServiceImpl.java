package com.techfun.springboot_assign3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techfun.springboot_assign3.dao.EmployeeDao;
import com.techfun.springboot_assign3.model.Employee;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeDao employeeDao;

	@Override
	public void createEmployee(Employee employee) {
		employeeDao.createEmployee(employee);
	}

	@Override
	public List<Employee> findAllEmployee() {
		return employeeDao.findAllEmployee();
	}

	@Override
	public List<Employee> searchEmployee(String name) {
		return employeeDao.searchEmployee(name);
	}

	@Override
	public Employee findByEmployeeId(Integer id) {
		return employeeDao.findByEmployeeId(id);
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeDao.updateEmployee(employee);
	}

	@Override
	public void deleteEmployee(Integer id) {
		employeeDao.deleteEmployee(id);
	}

}
