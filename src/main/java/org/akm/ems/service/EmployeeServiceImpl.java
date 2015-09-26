package org.akm.ems.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.akm.ems.dao.EmployeeDao;
import org.akm.ems.domain.Employee;

/**
 * 
 * @author anish
 *
 */
@Stateless
public class EmployeeServiceImpl implements EmployeeService{

	@Inject
	private EmployeeDao employeeDao;
	
	public Employee save(Employee t) {
		return this.employeeDao.save(t);
	}

	public List<Employee> findAll() {
		return this.employeeDao.findAll();
	}

	public Employee findOne(Long pk) {
		return this.employeeDao.findOne(pk);
	}

	public List<Employee> saveAll(List<Employee> ts) {
		return this.employeeDao.saveAll(ts);
	}

}
