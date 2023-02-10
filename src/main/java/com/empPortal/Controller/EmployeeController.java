package com.empPortal.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empPortal.model.Employee;
import com.empPortal.Service.EmployeeService;

@RestController
@CrossOrigin
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/hi")
	public String getTest(@RequestHeader("Authorization") String authorization) {
		return "Hi Shakil";
	}
	
	@GetMapping
	public List<Employee> getEmployees(@RequestHeader("Authorization") String authorization) {
		return employeeService.getEmployees();
	}
	
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable Long id, @RequestHeader("Authorization") String authorization) {
		return employeeService.getEmployeeById(id);
	}
	
//	@PostMapping(value = "/createEmployee", consumes = "application/json", produces = "application/json")
//	public Employee addEmployee(@RequestBody Employee employee) {
//		return employeeService.addEmployee(employee);
//	}
	
	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee, @RequestHeader("Authorization") String authorization) {
		return employeeService.updateEmployee(id, employee);
	}
	
	@DeleteMapping("/{id}")
	public Employee deleteEmployee(@PathVariable Long id, @RequestHeader("Authorization") String authorization) {
		return employeeService.deleteEmployee(id);
	}
	
}
