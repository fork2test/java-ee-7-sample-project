package org.akm.ems.controller;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.akm.ems.domain.Customer;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 
 * @author anish
 *
 */
@Stateless
@Path("customer")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "/customer")
public class CustomerController {

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "get sample customer data", notes = "Test notes", response = Customer.class)
	@ApiResponses(value = {@ApiResponse(code = 200, message = "OK"),@ApiResponse(code = 500, message = "Internal server error")})
	public Customer getSampleCustomer() {
		Customer customer = new Customer();
		customer.setName("Anish");
		customer.setAddress("Nepal");
		return customer;
	}
}
