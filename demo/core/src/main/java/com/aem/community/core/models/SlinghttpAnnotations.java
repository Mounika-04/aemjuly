package com.aem.community.core.models;

import javax.inject.Inject;


import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;


@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class SlinghttpAnnotations {
	@Inject
	private String firstName;
	
	
	public String getFirstName() {
		return firstName;
		
	}

     
	    	
	
}
