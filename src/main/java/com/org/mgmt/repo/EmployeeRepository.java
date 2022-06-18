package com.org.mgmt.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.org.mgmt.entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}
