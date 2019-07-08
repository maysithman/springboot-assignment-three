package com.techfun.springboot_assign3.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.techfun.springboot_assign3.mapper.EmployeeMapper;
import com.techfun.springboot_assign3.model.Employee;

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void createEmployee(Employee employee) {
		String sql = "INSERT INTO emp(name, lastname, email, office_code, job_title) VALUES(?, ? ,? ,?, ?)";
		jdbcTemplate.update(sql, employee.getName(), employee.getLastname(), employee.getEmail(), employee.getOfficeCode(), employee.getJobTitle());
	}
	
	@Override
	public List<Employee> findAllEmployee() {
		String sql = "SELECT * FROM emp";
		return jdbcTemplate.query(sql, new EmployeeMapper());
	}

	@Override
	public List<Employee> searchEmployee(String name) {
		
		//select * from emp where upper(name) LIKE upper('%a%') or id=2;
		//Integer emp_id = Integer.parseInt(value);
		
		/*String sql = "SELECT * FROM emp WHERE "
				+ "upper(name) LIKE upper(\'%name%\') or "
				+ "upper(lastname) LIKE upper(\'%name%\') or " 
				+ "upper(email) LIKE upper(\'%name%\') or "
				+ "upper(office_code) LIKE upper(\'%name%\') or "
				+ "upper(job_title) LIKE upper(\'%name%\')";*/
		
		String sql1= "select * from emp where name LIKE \'%" + name + "%\' "
				+  "or lastname LIKE \'%" + name + "%\' "
				+ "or email LIKE \'%" + name + "%\' "
				+ "or office_code LIKE \'%" + name + "%\' "
				+ "or job_title LIKE \'%" + name + "%\' ";
				
		return jdbcTemplate.query(sql1, new EmployeeMapper());
	}

	@Override
	public Employee findByEmployeeId(Integer id) {
		String sql = "SELECT * FROM emp where id=?";
		Employee result = null;
		try {
			result = jdbcTemplate.queryForObject(sql, new EmployeeMapper(), id);
		} catch (EmptyResultDataAccessException e) {
			// do nothing, return null
		}
		return result;
	}

	@Override
	public void updateEmployee(Employee employee) {
		String sql = "UPDATE emp SET name=?, lastname=?, email=?, office_code=?, job_title=? WHERE id=?";
		jdbcTemplate.update(sql, employee.getName(), employee.getLastname(), employee.getEmail(), employee.getOfficeCode(), employee.getJobTitle(), employee.getId());
	}

	@Override
	public void deleteEmployee(Integer id) {
		String sql = "DELETE FROM emp WHERE id = ?";
		jdbcTemplate.update(sql, id);
	}

	

}
