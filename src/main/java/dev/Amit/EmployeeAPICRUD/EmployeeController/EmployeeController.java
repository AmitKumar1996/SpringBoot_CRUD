package dev.Amit.EmployeeAPICRUD.EmployeeController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.Amit.EmployeeAPICRUD.entity.Employee;
import dev.Amit.EmployeeAPICRUD.repository.EmployeeRepository;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@PostMapping("/employee")
	public Employee createNewEmployee(@RequestBody Employee employee) {
		
		System.out.println(employee);
		
		employeeRepository.save(employee);
		return employee;
	}
	
	@GetMapping("/employee")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		
		List<Employee> empList= new ArrayList<>();
		
		employeeRepository.findAll().forEach(empList::add);
		return new ResponseEntity<List<Employee>>(empList, HttpStatus.OK);
		
	} 
	
	@GetMapping("/employee/{empid}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable long empid){
		
		// interview question 
		Optional<Employee> emp= employeeRepository.findById(empid);
		
		if(emp.isPresent()) {
			return new ResponseEntity<Employee>(emp.get(), HttpStatus.FOUND);
		}
		else {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	@PutMapping("/employee/{empid}")
	public String updateEmployeeById(@PathVariable long empid, @RequestBody Employee employee) {
		// Interview Question 
	Optional<Employee> emp=	employeeRepository.findById(empid);
	if(emp.isPresent()) {
		Employee existEmp=emp.get();
		existEmp.setEmpAge(employee.getEmpAge());
		existEmp.setEmpCity(employee.getEmpCity());
//		existEmp.setEmpid(employee.getEmpid());
		existEmp.setEmpName(employee.getEmpName());
		existEmp.setEmpSalary(employee.getEmpSalary());
		employeeRepository.save(existEmp);
		return "Employee Details against Id "+ empid+" updated";
		
		
	}
	else {
		return "Employee Details does not exist for "+ empid;
		}
	}
	
	
	@DeleteMapping("/employee/{empId}")
	public String deleteById(@PathVariable long empId ) {
	Optional<Employee> deleteEmp=	employeeRepository.findById(empId);
	if(deleteEmp.isPresent()) {
		Employee delete = deleteEmp.get();
	      employeeRepository.delete(delete);
	      return "Employee is deleted "+empId;
	}
	else {
		return empId+" is not found in DB";
		
	}
		
	}
	
	// my way
//	@DeleteMapping("/employee")
//	public String deleteAllEmp() {
//		
//		employeeRepository.deleteAll();
//		
//		
//		return "All Employee is deleted";
//		
//	}
	
	@DeleteMapping("/employee")
	public ResponseEntity<String> deleteAllEmp() {
	    employeeRepository.deleteAll();
	    return ResponseEntity.ok("All Employees have been deleted");
	}


}
