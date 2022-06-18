package com.org.mgmt.mapper;

import com.org.mgmt.dto.EmployeeDTO;
import com.org.mgmt.entity.Employee;

public class EmployeeMapper {

	public static EmployeeDTO entityToDTO(Employee employee) {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setEmpId(employee.getEmpId());
		employeeDTO.setEmpName(employee.getEmpName());
		employeeDTO.setEmpContactNo(employee.getEmpContactNo());
		employeeDTO.setEmpEmailId(employee.getEmpEmailId());
		employeeDTO.setEmpAddress(employee.getEmpAddress());
		employeeDTO.setSalary(employee.getSalary());

		return employeeDTO;
	}

	public static Employee dtoToEntity(EmployeeDTO employeeDTO) {
		Employee employee = new Employee();
		employee.setEmpName(employeeDTO.getEmpName());
		employee.setEmpContactNo(employeeDTO.getEmpContactNo());
		employee.setEmpEmailId(employeeDTO.getEmpEmailId());
		employee.setEmpAddress(employeeDTO.getEmpAddress());
		employee.setSalary(employeeDTO.getSalary());
		return employee;
	}
}
