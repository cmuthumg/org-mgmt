package com.org.mgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.mgmt.dto.AssetDTO;
import com.org.mgmt.dto.EmployeeDTO;
import com.org.mgmt.dto.OrganizationDTO;
import com.org.mgmt.service.AssetService;
import com.org.mgmt.service.EmployeeService;
import com.org.mgmt.service.OrganizationService;

@RestController
@RequestMapping("/service")
public class OrginazationEndPoints {

	@Autowired
	OrganizationService organizationService;

	@Autowired
	EmployeeService employeeService;

	@Autowired
	AssetService assetService;

	@GetMapping("/organizations")
	public ResponseEntity<List<OrganizationDTO>> getOrganizations() {

		return ResponseEntity.ok(organizationService.getOrganizations());
	}

	@GetMapping("/organization/{orgId}")
	public ResponseEntity<OrganizationDTO> getOrganization(@PathVariable("orgId") Long orgId) {
		return ResponseEntity.ok(organizationService.getOrganization(orgId));
	}

	@PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
	@PostMapping("/organization/save")
	public ResponseEntity<OrganizationDTO> saveOrganization(@RequestBody OrganizationDTO organizationDTO) {

		return ResponseEntity.ok(organizationService.saveOrUpdate(organizationDTO));
	}

	@PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
	@DeleteMapping("/organization/{orgId}")
	private ResponseEntity<String> deleteByIdOrganization(@PathVariable("orgId") Long orgId) {
		try {
			organizationService.delete(orgId);
		} catch (Exception exception) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>("Organizations deleted with id: " + orgId, HttpStatus.OK);
	}

	// Employees
	@GetMapping("/organization/employees")
	public ResponseEntity<List<EmployeeDTO>> getEmployees() {

		return ResponseEntity.ok(employeeService.getEmployees());
	}

	@GetMapping("/organization/employee/{orgId}")
	public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable("empId") Long empId) {
		return ResponseEntity.ok(employeeService.getEmployee(empId));
	}

	@PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
	@PostMapping("/organization/employee/save")
	public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody EmployeeDTO employeeDTO) {

		return ResponseEntity.ok(employeeService.saveOrUpdate(employeeDTO));
	}

	@PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
	@DeleteMapping("/organization/employee/{orgId}")
	private ResponseEntity<String> deleteByIdEmployee(@PathVariable("empId") Long empId) {
		try {
			employeeService.delete(empId);
		} catch (Exception exception) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>("Employee deleted with id: " + empId, HttpStatus.OK);
	}

	// Assets
	@GetMapping("/organization/assets")
	public ResponseEntity<List<AssetDTO>> getAssets() {

		return ResponseEntity.ok(assetService.getAssets());
	}

	@GetMapping("/organization/asset/{assetId}")
	public ResponseEntity<AssetDTO> getAsset(@PathVariable("assetId") Long assetId) {
		return ResponseEntity.ok(assetService.getAsset(assetId));
	}

	@PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
	@PostMapping("/organization/asset/save")
	public ResponseEntity<AssetDTO> saveAsset(@RequestBody AssetDTO assetDTO) {

		return ResponseEntity.ok(assetService.saveOrUpdate(assetDTO));
	}

	@PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
	@DeleteMapping("/organization/asset/{assetId}")
	private ResponseEntity<String> deleteByIdAsset(@PathVariable("assetId") Long assetId) {
		try {
			assetService.delete(assetId);
		} catch (Exception exception) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>("Asset deleted with id: " + assetId, HttpStatus.OK);
	}

}
