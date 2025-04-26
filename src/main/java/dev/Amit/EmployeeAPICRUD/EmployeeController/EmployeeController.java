package dev.Amit.EmployeeAPICRUD.EmployeeController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

}
