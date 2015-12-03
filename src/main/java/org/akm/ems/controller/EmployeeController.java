package org.akm.ems.controller;

import java.util.List;

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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.akm.ems.domain.Employee;
import org.akm.ems.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.AuthorizationScope;

/**
 * 
 * @author anish
 *
 */
@Stateless
@Path("employee")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "/employee", description = "Employee rest service", consumes = "application/json", produces = "application/json")
public class EmployeeController extends Application {

	@Inject
	private EmployeeService employeeService;
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "find employee by id ", notes = "Test notes")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "OK"),
						   @ApiResponse(code = 500, message = "Internal server error"),
						   @ApiResponse(code = 404, message = "No employee found with given id")
	})
	@ApiParam(value = "Unique identifier to find employee")
	@Authorization(scopes = @AuthorizationScope(description = "test", scope = "test"), value = "test")
	public Employee findEmployee(@PathParam("id") Long id) {
		return this.employeeService.findOne(id);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "add/update employee ", notes = "add or update employee", authorizations = { @Authorization(value="private") })
	@ApiResponses(value = {@ApiResponse(code = 200, message = "OK"),@ApiResponse(code = 500, message = "Internal server error")})
	@Path("/save")
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
	@Path("v1/info")
	@ApiOperation(value = "Say Hello World with swagger and java EE 7", notes = "Test notes")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "OK"),@ApiResponse(code = 500, message = "Internal server error")})
	public Response sayHello() {
		JsonObject value = Json.createObjectBuilder().add("firstName", "anish").add("lastName", "manandhar")
				.add("message", "Hi This is sample for swagger integration with java EE 7").build();
		return Response.status(200).entity(value).build();
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Finds list of employee by username and address", notes = "")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "OK"),
							@ApiResponse(code = 500, message = "Internal server error"),
							@ApiResponse(code= 404, message = "No employee found with given user name and address")})
	/*@ApiImplicitParams({
	    @ApiImplicitParam(name = "username", value = "User name", required = false, dataType = "String", paramType = "query"),
	    @ApiImplicitParam(name = "address", value = "Address", required = false, dataType = "String", paramType = "query")
	  })*/
	public List<Employee> findByParams(@QueryParam("username") String name,  @QueryParam("address") String address) {
		return this.employeeService.findAll();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("v2/info")
	@ApiOperation(value = "Say Hello World with swagger and java EE 7 version two", notes = "Test notes Some changes has been made in this v2 version")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "OK"),@ApiResponse(code = 500, message = "Internal server error")})
	public Response sayHelloV2() {
		JsonObject value = Json.createObjectBuilder().add("firstName", "ujjwal").add("lastName", "dhamala")
				.add("message", "Hi This is sample for swagger integration with java EE 7").build();
		return Response.status(200).entity(value).build();
	}
	
	
	
	/*@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	@ApiOperation(value = "Finds employee by unique id", notes = "Test notes")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "OK"),
							@ApiResponse(code = 500, message = "Internal server error"),
							@ApiResponse(code= 404, message = "No employee found with given id")})
	@ApiImplicitParams({
	    @ApiImplicitParam(name = "id", value = "User ID", required = true, dataType = "long", paramType = "path")
	  })
	@ApiParam(name = "id", value = "User ID", required = true)
	public Employee findById(@PathParam("id") Long id){
		return this.employeeService.findOne(id);
	}*/
	
}
