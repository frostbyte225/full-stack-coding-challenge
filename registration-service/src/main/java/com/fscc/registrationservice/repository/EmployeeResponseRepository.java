package com.fscc.registrationservice.repository;

import com.fscc.registrationservice.entity.EmployeeResponse;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeResponseRepository extends MongoRepository<EmployeeResponse, Integer> {

}
