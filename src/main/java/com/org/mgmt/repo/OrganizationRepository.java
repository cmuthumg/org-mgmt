package com.org.mgmt.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.org.mgmt.entity.Organization;

@Repository
public interface OrganizationRepository extends CrudRepository<Organization, Long>{

}
