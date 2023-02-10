package com.empPortal.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empPortal.repository.EmployeeRepository;
import com.empPortal.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}
	
	@Override
	public Employee getEmployeeById(Long id) {
		return employeeRepository.findById(id).orElseThrow(()-> new RuntimeException("Employee with the Id "+id+" does not exist"));
	}
	
	@Override
	public Employee addEmployee(Employee employee) {
		Employee savedEmployee = employeeRepository.save(employee);
		return savedEmployee;
	}
	
	@Override
	public Employee updateEmployee(Long id, Employee employee) {
		
		Optional<Employee> optEmp = employeeRepository.findById(id);
		if(!optEmp.isPresent()) {
			throw new RuntimeException("Employee with the Id "+id+"does not exist");
		}
		
		Employee emp = optEmp.get();
		
		if(employee.getEmpName()!=null) {
			emp.setEmpName(employee.getEmpName());
		}
		if(employee.getGender()!=null) {
			emp.setGender(employee.getGender());
		}
		if(employee.getEmail()!=null) {
			emp.setEmail(employee.getEmail());
		}
		if(employee.getDept()!=null) {
			emp.setDept(employee.getDept());
		}
		if(employee.getAddress()!=null) {
			emp.setAddress(employee.getAddress());
		}
		if(employee.getPhone()!=null) {
			emp.setPhone(employee.getPhone());
		}
		
		employeeRepository.save(emp);
		return employee;
	}
	
	@Override
	public Employee deleteEmployee(Long id) {
		Employee emp = employeeRepository.findById(id).get();
		employeeRepository.deleteById(id);
		return emp;
	}
	
}