package com.org.mgmt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.mgmt.dto.EmployeeDTO;
import com.org.mgmt.entity.Employee;
import com.org.mgmt.mapper.EmployeeMapper;
import com.org.mgmt.repo.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<EmployeeDTO> getEmployees() {
		List<EmployeeDTO> employeesDTO = new ArrayList<>();
		employeeRepository.findAll().forEach(employeeDTO -> {
			employeesDTO.add(EmployeeMapper.entityToDTO(employeeDTO));
		});
		return employeesDTO;
	}

	public EmployeeDTO getEmployee(Long empId) {
		Optional<Employee> employeeOp = employeeRepository.findById(empId);
		if (employeeOp.isPresent()) {
			return EmployeeMapper.entityToDTO(employeeOp.get());
		}
		return null;
	}

	public EmployeeDTO saveOrUpdate(EmployeeDTO employeeDTO) {
		Employee employee = employeeRepository.save(EmployeeMapper.dtoToEntity(employeeDTO));
		return EmployeeMapper.entityToDTO(employee);
	}

	public void delete(Long empId) {
		employeeRepository.deleteById(empId);
	}
}
