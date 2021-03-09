package com.ibm.fscc.employeeservice.dao;
import com.ibm.fscc.employeeservice.data.EmployeeEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "employee", path = "employee")
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
}
