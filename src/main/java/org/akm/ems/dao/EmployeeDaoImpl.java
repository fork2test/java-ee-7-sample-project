package org.akm.ems.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.akm.ems.domain.Employee;

/**
 * 
 * @author anish
 *
 */
@Stateless
public class EmployeeDaoImpl implements EmployeeDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	public Employee save(Employee t) {
		if(t.getId().equals(0L)){
			this.entityManager.persist(t);
		}else{
			t = this.entityManager.merge(t);
		}
		return t;
	}

	public List<Employee> findAll() {
		return null;
	}

	public Employee findOne(Long pk) {
		return this.entityManager.find(Employee.class, pk);
	}

	public List<Employee> saveAll(List<Employee> ts) {
		return null;
	}

}
