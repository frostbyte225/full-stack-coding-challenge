package com.ibm.fscc.employeeservice.dto;

import com.ibm.fscc.employeeservice.dao.EmployeeRepository;
import com.ibm.fscc.employeeservice.data.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<EmployeeEntity> getAllEmployees() {
        List<EmployeeEntity> employees = new ArrayList<EmployeeEntity>();
        employees.addAll(employeeRepository.findAll());

        return employees;
    }

    public EmployeeEntity getEmployeeById(Long id) {
        return employeeRepository.findById(id).get();
    }

    public void saveOrUpdateEmployee(EmployeeEntity employee) {
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public void update(EmployeeEntity employee) {
        employeeRepository.save(employee);
    }

}
