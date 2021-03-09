package com.fscc.registrationservice.controller;

import com.fscc.registrationservice.entity.EmployeeRequest;
import com.fscc.registrationservice.entity.EmployeeResponse;
import com.fscc.registrationservice.repository.EmployeeResponseRepository;
import com.fscc.registrationservice.service.impl.EmployeeProducerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class KafkaController {

    @Autowired
    private EmployeeProducerImpl employeeProducer;

    @Autowired
    private EmployeeResponseRepository employeeRepository;

    private Logger logger = LoggerFactory.getLogger(KafkaController.class);

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> register(@RequestBody EmployeeRequest employeeRequest) {
        String response;
        try {
            response = employeeProducer.produce(employeeRequest);
        } catch (Exception e) {
            throw new IllegalArgumentException("There was a problem with the passed employee");
        }

        logger.info("Received {}", employeeRequest.getFirstName());

        return ResponseEntity.ok().body(response);

    }

    @GetMapping(value = "employees")
    public List<EmployeeResponse> getEmployees() {
        return employeeRepository.findAll();
    }
}
