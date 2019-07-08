package com.techfun.springboot_assign3.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.techfun.springboot_assign3.model.Employee;

public class EmployeeMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee = new Employee();
		employee.setId(rs.getInt("id"));
		employee.setName(rs.getString("name"));
		employee.setLastname(rs.getString("lastname"));
		employee.setEmail(rs.getString("email"));
		employee.setOfficeCode(rs.getString("office_code"));
		employee.setJobTitle(rs.getString("job_title"));
		return employee;
	}

}
