package org.akm.ems.conf;

import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.akm.ems.controller.CustomerController;
import org.akm.ems.controller.EmployeeController;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;

/**
 * 
 * @author anish
 *
 */
@ApplicationPath("app")
public class AppConfig extends Application {

	
	public AppConfig() {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.2");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("/java-ee-7-sample-project/app");
        beanConfig.setResourcePackage("org.akm.ems");
        beanConfig.setScan(true);
    }
	
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        resources.add(ApiListingResource.class);
        resources.add(SwaggerSerializers.class);
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method. It is automatically
     * populated with all resources defined in the project. If required, comment
     * out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(EmployeeController.class);
        resources.add(CustomerController.class);
    }

}
