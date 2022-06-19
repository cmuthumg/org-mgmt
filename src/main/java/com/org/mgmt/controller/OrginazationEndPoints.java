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

	@GetMapping(path = "/organizations", produces = "application/xml")
	public ResponseEntity<List<OrganizationDTO>> getOrganizations() {

		return ResponseEntity.ok(organizationService.getOrganizations());
	}

	@GetMapping(path = "/organization/{orgId}", produces = "application/xml")
	public ResponseEntity<OrganizationDTO> getOrganization(@PathVariable("orgId") Long orgId) {
		return ResponseEntity.ok(organizationService.getOrganization(orgId));
	}

	@PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
	@PostMapping(path = "/organization/save", produces = "application/xml")
	public ResponseEntity<OrganizationDTO> saveOrganization(@RequestBody OrganizationDTO organizationDTO) {

		return ResponseEntity.ok(organizationService.saveOrUpdate(organizationDTO));
	}

	@PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
	@DeleteMapping("/organization/{orgId}")
	public ResponseEntity<String> deleteByIdOrganization(@PathVariable("orgId") Long orgId) {
		try {
			System.out.println("orgId >"+orgId);
			organizationService.delete(orgId);
		} catch (Exception exception) {
			exception.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>("Organizations deleted with id: " + orgId, HttpStatus.OK);
	}

	// Employees
	@GetMapping(path = "/organization/employees", produces = "application/xml")
	public ResponseEntity<List<EmployeeDTO>> getEmployees() {

		return ResponseEntity.ok(employeeService.getEmployees());
	}

	@GetMapping(path = "/organization/employee/{orgId}", produces = "application/xml")
	public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable("empId") Long empId) {
		return ResponseEntity.ok(employeeService.getEmployee(empId));
	}

	@PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
	@PostMapping(path = "/organization/employee/save", produces = "application/xml")
	public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody EmployeeDTO employeeDTO) {

		return ResponseEntity.ok(employeeService.saveOrUpdate(employeeDTO));
	}

	@PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
	@DeleteMapping("/organization/employee/{orgId}")
	public ResponseEntity<String> deleteByIdEmployee(@PathVariable("empId") Long empId) {
		try {
			employeeService.delete(empId);
		} catch (Exception exception) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>("Employee deleted with id: " + empId, HttpStatus.OK);
	}

	// Assets
	@GetMapping(path = "/organization/assets", produces = "application/xml")
	public ResponseEntity<List<AssetDTO>> getAssets() {

		return ResponseEntity.ok(assetService.getAssets());
	}

	@GetMapping(path = "/organization/asset/{assetId}", produces = "application/xml")
	public ResponseEntity<AssetDTO> getAsset(@PathVariable("assetId") Long assetId) {
		return ResponseEntity.ok(assetService.getAsset(assetId));
	}

	@PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
	@PostMapping(path = "/organization/asset/save", produces = "application/xml")
	public ResponseEntity<AssetDTO> saveAsset(@RequestBody AssetDTO assetDTO) {

		return ResponseEntity.ok(assetService.saveOrUpdate(assetDTO));
	}

	@PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
	@DeleteMapping("/organization/asset/{assetId}")
	public ResponseEntity<String> deleteByIdAsset(@PathVariable("assetId") Long assetId) {
		try {
			assetService.delete(assetId);
		} catch (Exception exception) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>("Asset deleted with id: " + assetId, HttpStatus.OK);
	}

}
