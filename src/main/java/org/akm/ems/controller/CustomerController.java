package org.akm.ems.controller;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.akm.ems.domain.Customer;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@Stateless
@Path("customer")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "/customer", description = "Customer rest services")
public class CustomerController {

	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "find customer by id ", notes = "Test notes")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
	@ApiResponse(code = 500, message = "Internal server error") })
	public Customer findCustomer(@ApiParam(value = "Unique identifier to find customer") @PathParam("id") Long id) {
		Customer customer = new Customer();
		customer.setName("Anish");
		customer.setAddress("Nepal");
		return customer;
	}
}
