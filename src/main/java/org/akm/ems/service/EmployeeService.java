package org.akm.ems.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import org.akm.ems.api.GenericApi;
import org.akm.ems.domain.Employee;

/**
 * 
 * @author anish
 *
 */
@Stateless
public class EmployeeService {

	private static List<Employee> employees = new ArrayList<Employee>();
	
	static{
		employees.add(new Employee(1l,"Anish krishna Manandhar", "Kathmandu,Nepal"));
		employees.add(new Employee(2l,"Kailash Raj Bijaynanda", "Kathmandu,Nepal"));
		employees.add(new Employee(3l,"Sudhir Shrestha", "Lalitpur,Nepal"));
		employees.add(new Employee(4l,"Ujwal Dhamala", "Bhaktapur,Nepal"));
	}
	
	public Employee save(Employee t) {
		if(t.getId().equals(null))
			t = this.add(t);
		else
			t = this.update(t);
		return t;
	}
	
	private Employee add(Employee employee){
		employee.setId(Long.valueOf(employees.size())+ 1l);
		employees.add(employee);
		return employee;
	}
	
	private Employee update(Employee t){
		Employee emp = this.findOne(t.getId());
		if(null == emp)
			return this.add(t);
		else{
			emp.setAddress(t.getAddress());
			emp.setName(t.getName());
			return emp;
		}
	}

	public List<Employee> findAll() {
		return employees;
	}

	public Employee findOne(Long pk) {
		for(Employee employee : employees){
			if(employee.getId().equals(pk))
				return employee;
		}
		return null;
	}

	public List<Employee> saveAll(List<Employee> ts) {
		employees.addAll(ts);
		return employees;
	}

}
