package org.akm.ems.controller;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import org.akm.ems.domain.Employee;

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

	@PersistenceContext
    private EntityManager entityManager;
	
	@GET
    @Path("{id}")
    public Employee getPerson(@PathParam("id") Long id){
        return entityManager.find(Employee.class, id);
    }
}
