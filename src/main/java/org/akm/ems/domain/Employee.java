package org.akm.ems.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @author anish
 *
 */
@Entity
@ApiModel(value = "Employee", description = "employee domain object")
public class Employee implements Serializable {

	private static final long serialVersionUID = -2449687964123610862L;
	
	public Employee(){}
	
	public Employee(Long id, String name, String address) {
		super();
		this.setId(id);
		this.setName(name);
		this.setAddress(address);
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id")
    @SequenceGenerator(name = "id", sequenceName = "id")
	private Long id;
	
	private String name;
	
	private String address;

	@ApiModelProperty(value = "Unique identifier of an employee")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ApiModelProperty(value = "Name of an employee")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@ApiModelProperty(value = "current address of an employee", notes = "please donot provide special characters")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address + "]";
	}

}
