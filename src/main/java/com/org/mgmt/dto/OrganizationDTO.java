package com.org.mgmt.dto;

import java.io.Serializable;
import java.util.List;

public class OrganizationDTO implements Serializable {

	private static final long serialVersionUID = -4848000796976153110L;
	private Long orgId;
	private String name;
	private String contactNo;
	private String emailId;
	private String address;
	private List<EmployeeDTO> employeesDTO;
	private List<AssetDTO> assetsDTO;

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<EmployeeDTO> getEmployeesDTO() {
		return employeesDTO;
	}

	public void setEmployeesDTO(List<EmployeeDTO> employeesDTO) {
		this.employeesDTO = employeesDTO;
	}

	public List<AssetDTO> getAssetsDTO() {
		return assetsDTO;
	}

	public void setAssetsDTO(List<AssetDTO> assetsDTO) {
		this.assetsDTO = assetsDTO;
	}

}
