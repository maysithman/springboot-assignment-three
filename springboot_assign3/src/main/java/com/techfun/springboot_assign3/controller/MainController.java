package com.techfun.springboot_assign3.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.techfun.springboot_assign3.model.Employee;
import com.techfun.springboot_assign3.service.EmployeeService;

@Controller
public class MainController {
	
	@Autowired
	EmployeeService employeeService;
	
	private static List<Employee> employees = new ArrayList<Employee>();
	
	@GetMapping(value = { "/", "/index" })
	public String index(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		
		List<Employee> employees = employeeService.findAllEmployee();
		model.addAttribute("employees", employees);
		return "index";
	}
	
	@GetMapping(value = { "/employee" })
	public String showEmployeeRegisterForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "employee";
	}

	@PostMapping(value = { "/employee" })
	public String saveEmployee(Model model, @ModelAttribute("employee") Employee emp) {

		String name = emp.getName();
		String lastname = emp.getLastname();
		String email = emp.getEmail();
		String officeCode = emp.getOfficeCode();
		String jobTitle = emp.getJobTitle();
		
		Employee newEmployee = new Employee(name, lastname, email, officeCode, jobTitle);
		employees.add(newEmployee);
		employeeService.createEmployee(newEmployee);
		
		return "redirect:/index";

	}
	
	@GetMapping(value = "/updateEmployee/{id}")
	public ModelAndView showUpdateEmployeeForm(@PathVariable("id") Integer id,
			@ModelAttribute("updateEmployee") Employee empoyee) {
		Employee emp = employeeService.findByEmployeeId(id);
		ModelAndView mav = new ModelAndView("employeeEdit");
		mav.addObject("updateEmployee", emp);
		return mav;
	}

	@PostMapping(value = "/updateEmployee")
	public String updateEmployee(@ModelAttribute("updateEmployee") Employee employee) {
		employeeService.updateEmployee(employee);
		return "redirect:/index";
	}
	
	@GetMapping(value = "/employee/deleteEmployee/{id}")
	public String deleteEmployee(@ModelAttribute("id") Integer id) throws Exception {
		employeeService.deleteEmployee(id);
		return "redirect:/index";
	}

	@GetMapping(value = "/queryEmployee/{id}")
	public ModelAndView showDetailedEmployee(@PathVariable("id") Integer id,
			@ModelAttribute("queryEmployee") Employee empoyee) {
		Employee emp = employeeService.findByEmployeeId(id);
		ModelAndView mav = new ModelAndView("employeeDetail");
		mav.addObject("queryEmployee", emp);
		return mav;
	}
	
	@PostMapping(value = "/queryEmployee")
	public String detailedEmployee(@ModelAttribute("queryEmployee") Employee employee) {
		//employeeService.findByEmployeeId(id)(employee);
		return "redirect:/index";
	}
	
	@PostMapping(value = { "/searchEmployee" })
    public String searchCustomer(Model model, @ModelAttribute("employee") Employee employee) {
		
		String name = employee.getName();
       
        List<Employee> employees = employeeService.searchEmployee(name);
        model.addAttribute("employees", employees);
        
        Employee emp = new Employee();
        model.addAttribute("employee", emp);
        
        return "index";
        
    }
	
}
