package com.fscc.registrationservice.service;

import com.fscc.registrationservice.entity.EmployeeRequest;
import com.fscc.registrationservice.entity.EmployeeResponse;
import org.springframework.stereotype.Component;

@Component
public interface EmployeeProducer {

    public String produce(EmployeeRequest employeeRequest) throws Exception;

    public EmployeeResponse mapEmployeeToEmployeeResponse(EmployeeRequest employeeRequest);

}
