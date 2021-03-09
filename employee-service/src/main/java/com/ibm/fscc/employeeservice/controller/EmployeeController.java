package com.ibm.fscc.employeeservice.controller;

import com.ibm.fscc.employeeservice.dao.EmployeeRepository;
import com.ibm.fscc.employeeservice.data.EmployeeEntity;
import com.ibm.fscc.employeeservice.dto.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.util.List;

@RestController
@RequestMapping(path = "")
public class EmployeeController {

	@Autowired
	private Environment env;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private EmployeeService employeeService;

	@GetMapping(path = "/status/check")
	public String status() {
		return "Working on port " + env.getProperty("server.port") + "!";
	}

//	@GetMapping(path = "/get-employees")
//	public List<EmployeeEntity> getEmployees() {
//		return employeeRepository.findAll();
//	}

	@GetMapping(path = "/employees")
	public List<EmployeeEntity> getEmployees() {
		return employeeService.getAllEmployees();
	}

	@GetMapping(path = "/employee/{employeeId}")
	public EmployeeEntity getEmployee(@PathVariable("employeeId") Long employeeId) {
		return employeeService.getEmployeeById(employeeId);
	}

	@DeleteMapping(path = "/employee/{employeeId}")
	public void deleteEmployee(@PathVariable("employeeId") Long employeeId) {
		employeeService.deleteEmployee(employeeId);
	}

	@PostMapping(path = "/employees")
	public void saveEmployee(@RequestBody EmployeeEntity employee) {
		employeeService.saveOrUpdateEmployee(employee);
	}

	@PutMapping(path = "/employees")
	public EmployeeEntity update(@RequestBody EmployeeEntity employee) {
		employeeService.saveOrUpdateEmployee(employee);
		return employeeService.getEmployeeById(employee.getId());
	}

}
