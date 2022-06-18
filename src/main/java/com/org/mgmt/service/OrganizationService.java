package com.org.mgmt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.mgmt.dto.OrganizationDTO;
import com.org.mgmt.entity.Organization;
import com.org.mgmt.mapper.OrginazationMapper;
import com.org.mgmt.repo.OrganizationRepository;

@Service
@Transactional
public class OrganizationService {

	@Autowired
	private OrganizationRepository organizationRepository;

	public List<OrganizationDTO> getOrganizations() {
		List<OrganizationDTO> organizations = new ArrayList<>();
		organizationRepository.findAll().forEach(organization -> {
			organizations.add(OrginazationMapper.entityToDTO(organization));
		});
		return organizations;
	}

	public OrganizationDTO getOrganization(Long orgId) {
		Optional<Organization> organizationOp = organizationRepository.findById(orgId);
		if (organizationOp.isPresent()) {
			return OrginazationMapper.entityToDTO(organizationOp.get());
		}
		return null;
	}

	public OrganizationDTO saveOrUpdate(OrganizationDTO organizationDTO) {
		Organization inputOrganization = OrginazationMapper.dtoToEntity(organizationDTO);
		Organization organization = organizationRepository.save(inputOrganization);
		return OrginazationMapper.entityToDTO(organization);
	}

	public void delete(Long orgId) {
		organizationRepository.deleteById(orgId);
	}

}
