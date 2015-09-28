package org.akm.ems.controller;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import org.akm.ems.domain.Employee;
import org.akm.ems.service.EmployeeService;

/**
 * 
 * @author anish
 *
 */
@Stateless
@ApplicationPath("/app")
@Path("employee")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeController extends Application {

	@Inject
	private EmployeeService employeeService;
	
	@GET
    @Path("{id}")
    public Employee findEmployee(@PathParam("id") Long id){
        return employeeService.findOne(id);
    }
}
