package com.fscc.registrationservice.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fscc.registrationservice.entity.EmployeeRequest;
import com.fscc.registrationservice.entity.EmployeeResponse;
import com.fscc.registrationservice.service.EmployeeProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EmployeeProducerImpl implements EmployeeProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private ObjectMapper objectMapper = new ObjectMapper();

    private Logger logger = LoggerFactory.getLogger(EmployeeProducerImpl.class);

    private String STATUS = "PENDING";

    public String produce(EmployeeRequest employeeRequest) throws Exception {
        var newEmployee = mapEmployeeToEmployeeResponse(employeeRequest);

        logger.info("Created new employee {} with status of {}", newEmployee.getFirstName(), newEmployee.getStatus());

        kafkaTemplate.send("t.employee", newEmployee.getFirstName() + " " + newEmployee.getLastName(), objectMapper.writeValueAsString(newEmployee));

        logger.info("Employee status : {}\nEmployee Status Date : {}", newEmployee.getStatus(), newEmployee.getStatusDate());
        return objectMapper.writeValueAsString(newEmployee);
    }

    public EmployeeResponse mapEmployeeToEmployeeResponse(EmployeeRequest employeeRequest) {
        EmployeeResponse employeeResponse = new EmployeeResponse();

        employeeResponse.setId(employeeRequest.getId());
        employeeResponse.setFirstName(employeeRequest.getFirstName());
        employeeResponse.setLastName(employeeRequest.getLastName());
        employeeResponse.setEmail(employeeRequest.getEmail());
        employeeResponse.setStatus(STATUS);
        employeeResponse.setStatusDate(new Date());

        return employeeResponse;
    }
}
