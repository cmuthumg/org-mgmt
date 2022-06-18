package com.org.mgmt.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.org.mgmt.dto.AssetDTO;
import com.org.mgmt.dto.EmployeeDTO;
import com.org.mgmt.dto.OrganizationDTO;
import com.org.mgmt.entity.Asset;
import com.org.mgmt.entity.Employee;
import com.org.mgmt.entity.Organization;

public class OrginazationMapper {

	public static OrganizationDTO entityToDTO(Organization organization) {
		OrganizationDTO organizationDTO = new OrganizationDTO();
		organizationDTO.setOrgId(organization.getOrgId());
		organizationDTO.setName(organization.getName());
		organizationDTO.setContactNo(organization.getContactNo());
		organizationDTO.setEmailId(organization.getEmailId());
		organizationDTO.setAddress(organization.getAddress());

		List<Employee> employees = organization.getEmployees();
		if (Objects.nonNull(employees) && !employees.isEmpty()) {
			List<EmployeeDTO> employeesDTO = new ArrayList<>();
			for (Employee employee : employees) {
				EmployeeDTO employeeDTO = EmployeeMapper.entityToDTO(employee);
				employeeDTO.setOrgId(organization.getOrgId());
				employeesDTO.add(employeeDTO);
			}
			organizationDTO.setEmployeesDTO(employeesDTO);
		}

		List<Asset> assets = organization.getAssets();
		if (Objects.nonNull(assets) && !assets.isEmpty()) {
			List<AssetDTO> assetsDTO = new ArrayList<>();
			for (Asset asset : assets) {
				AssetDTO assetDTO =  AssetMapper.entityToDTO(asset);
				assetDTO.setOrgId(organization.getOrgId());
				assetsDTO.add(assetDTO);
			}
			organizationDTO.setAssetsDTO(assetsDTO);
		}

		return organizationDTO;
	}

	public static Organization dtoToEntity(OrganizationDTO organizationDTO) {
		Organization organization = new Organization();

		organization.setName(organizationDTO.getName());
		organization.setContactNo(organizationDTO.getContactNo());
		organization.setEmailId(organizationDTO.getEmailId());
		organization.setAddress(organizationDTO.getAddress());

		List<EmployeeDTO> employeesDTO = organizationDTO.getEmployeesDTO();
		if (Objects.nonNull(employeesDTO) && !employeesDTO.isEmpty()) {
			List<Employee> employees = new ArrayList<>();
			for (EmployeeDTO employeeDTO : employeesDTO) {
				Employee employee = EmployeeMapper.dtoToEntity(employeeDTO);
				employee.setOrganization(organization);
				employees.add(employee);
			}
			organization.setEmployees(employees);
		}

		List<AssetDTO> assetsDTO = organizationDTO.getAssetsDTO();
		if (Objects.nonNull(assetsDTO) && !assetsDTO.isEmpty()) {
			List<Asset> assets = new ArrayList<>();
			for (AssetDTO assetDTO : assetsDTO) {
				Asset asset = AssetMapper.dtoToEntity(assetDTO);
				asset.setOrganization(organization);
				assets.add(asset);
			}
			organization.setAssets(assets);
		}
		return organization;
	}
}
