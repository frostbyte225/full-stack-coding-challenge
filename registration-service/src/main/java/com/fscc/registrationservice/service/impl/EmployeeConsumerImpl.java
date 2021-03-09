package com.fscc.registrationservice.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fscc.registrationservice.entity.EmployeeResponse;
import com.fscc.registrationservice.repository.EmployeeResponseRepository;
import com.fscc.registrationservice.service.EmployeeConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EmployeeConsumerImpl implements EmployeeConsumer {

    @Autowired
    private EmployeeResponseRepository employeeRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

    private Logger logger = LoggerFactory.getLogger(EmployeeProducerImpl.class);

    private String VERIFIED = "VERIFIED";

    @KafkaListener(topics = "t.employee")
    public void consume(String employeeResponse) throws Exception {

        var response = objectMapper.readValue(employeeResponse, EmployeeResponse.class);

        // here we are going to want to change the pending status to approved and save to db
        // currently don't have noSQL db up and running, so I am going to commend out the code
        // employeeRepository.save(response);

        response.setStatus(VERIFIED);
        response.setStatusDate(new Date());

        employeeRepository.save((EmployeeResponse) response);

        logger.info("Transformed employee to verified for employee : {}", response.getFirstName() + " " + response.getLastName());
        logger.info("Employee status : {}\nEmployee Status Date : {}", response.getStatus(), response.getStatusDate());

    }
}
