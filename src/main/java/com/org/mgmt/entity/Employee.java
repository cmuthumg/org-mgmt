package com.org.mgmt.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long empId;
	
	@NotNull
	private String empName;
	private String empContactNo;
	private String empEmailId;
	private String empAddress;
	private Long salary;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "org_Id", referencedColumnName = "orgId")
	private Organization organization;

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpContactNo() {
		return empContactNo;
	}

	public void setEmpContactNo(String empContactNo) {
		this.empContactNo = empContactNo;
	}

	public String getEmpEmailId() {
		return empEmailId;
	}

	public void setEmpEmailId(String empEmailId) {
		this.empEmailId = empEmailId;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}
}
