package dev.Amit.EmployeeAPICRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.Amit.EmployeeAPICRUD.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	

}
