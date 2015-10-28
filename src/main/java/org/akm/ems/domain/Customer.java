package org.akm.ems.domain;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @author anish
 *
 */
@ApiModel(value = "Customer", description = "customer domain object")
public class Customer implements Serializable {

	private static final long serialVersionUID = -1069991654834779827L;

	private Long id;
	private String name;
	private String address;
	private String contactNumber;

	@ApiModelProperty(value = "Unique identifier of an customer")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ApiModelProperty(value = "customer name field")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ApiModelProperty(value = "customer address value")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@ApiModelProperty(value = "customer contact number")
	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

}
