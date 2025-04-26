package dev.Amit.EmployeeAPICRUD.entity;



import org.hibernate.annotations.OptimisticLock;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long empid;
	
	@Column(name = "emp_name")
	private String empName;

	@Column(name = "emp_salary")
	private Float empSalary;

	@Column(name = "emp_age")
	private int empAge;

	@Column(name = "emp_city")
	private String empCity;

	public Long getEmpid() {
		return empid;
	}

	public void setEmpid(Long empid) {
		this.empid = empid;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Float getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(Float empSalary) {
		this.empSalary = empSalary;
	}

	public int getEmpAge() {
		return empAge;
	}

	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}

	public String getEmpCity() {
		return empCity;
	}

	public void setEmpCity(String empCity) {
		this.empCity = empCity;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empName=" + empName + ", empSalary=" + empSalary + ", empAge=" + empAge
				+ ", empCity=" + empCity + "]";
	}

	public Employee(Long empid, String empName, Float empSalary, int empAge, String empCity) {
		super();
		this.empid = empid;
		this.empName = empName;
		this.empSalary = empSalary;
		this.empAge = empAge;
		this.empCity = empCity;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
