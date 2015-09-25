package org.akm.ems.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value="testController")
@RequestScoped
public class TestController {

	public String getData() {
		return "Test data";
	}

}
