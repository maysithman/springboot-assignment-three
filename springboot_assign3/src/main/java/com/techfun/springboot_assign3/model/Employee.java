package com.techfun.springboot_assign3.model;

public class Employee {

	private Integer id;
	private String name;
	private String lastname;
	private String email;
	private String officeCode;
	private String jobTitle;

	public Employee() {
		super();
	}

	public Employee(String name, String lastname, String email, String officeCode, String jobTitle) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.officeCode = officeCode;
		this.jobTitle = jobTitle;
	}

	public Employee(Integer id, String name, String lastname, String email, String officeCode, String jobTitle) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.officeCode = officeCode;
		this.jobTitle = jobTitle;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOfficeCode() {
		return officeCode;
	}

	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

}
