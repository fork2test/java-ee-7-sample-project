package org.akm.ems.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.akm.ems.domain.Employee;
import org.akm.ems.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 
 * @author anish
 *
 */
@Stateless
@Path("employee")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "/employee", description = "Employee rest services")
public class EmployeeController extends Application {

	@Inject
	private EmployeeService employeeService;
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "find employee by id ", notes = "Test notes")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "OK"),@ApiResponse(code = 500, message = "Internal server error")})
	public Employee findEmployee(@ApiParam(value = "Unique identifier to find employee") @PathParam("id") Long id) {
		return this.employeeService.findOne(id);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "add/update employee ", notes = "add or update employee")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "OK"),@ApiResponse(code = 500, message = "Internal server error")})
	public Employee save(Employee employee){
		return this.employeeService.save(employee);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "find all employees", notes = "list of all available employees")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "OK"),@ApiResponse(code = 500, message = "Internal server error")})
	public List<Employee> findAll(){
		return this.employeeService.findAll();
	}
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Say Hello World with swagger and java EE 7", notes = "Test notes")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "OK"),@ApiResponse(code = 500, message = "Internal server error")})
	public Response sayHello() {
		JsonObject value = Json.createObjectBuilder().add("firstName", "anish").add("lastName", "manandhar")
				.add("message", "Hi This is sample for swagger integration with java EE 7").build();
		return Response.status(200).entity(value).build();
	}
}
