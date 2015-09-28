package org.akm.ems.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.akm.ems.domain.Employee;
import org.akm.ems.service.EmployeeService;

/**
 * 
 * @author anish
 *
 */
@Named(value="testController")
@RequestScoped
public class TestController {

	@Inject
	private EmployeeService employeeService;
	
	
	private Employee employee = new Employee();
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String findEmployee(){
		System.out.println("Employee is " + employee);
		this.employee = this.employeeService.findOne(employee.getId());
        return "employee.xhtml";
    }
	
	public String getData(){
		return "Test value from test controller";
	}
	
}
