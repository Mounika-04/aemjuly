package com.aem.community.core.models;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.jcr.Node;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.Required;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

import org.apache.sling.models.annotations.injectorspecific.ResourcePath;

import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class,

		defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TestModel {
	@Inject
	private String bookname;

	@Inject
	private String booksubject;

	@Inject
	private String publishyear;
	@Inject
	@Named("sling:resourceType")
	@Optional
	String slingResourceType;
	@Inject
	String path;

	@Inject
	@Default(values = "/content/mypage")
	@Required
	String pagePath;
	@Inject
	List<Resource> bookdetailswithmap;
	@Inject
	@Named("sling:resourceType")
	String resourceType;
	@ChildResource(name = "bookdetailswithmap")
	Resource child;
	@ValueMapValue
	String title;
	@ResourcePath(name = "path")
	Resource socialResource;

	public String getBookname() {
		return bookname;
	}

	public String getBooksubject() {
		return booksubject;
	}

	public String getPublishyear() {
		return publishyear;
	}

	public String getPath() {
		return path;
	}

	public String getSlingResourceType() {
		return slingResourceType;
	}

	public String getPagePath() {
		return pagePath;

	}

	public int getSize() {
		return bookdetailswithmap.size();
	}

	public String getResourceType() {
		return resourceType;
	}

	public String getChildpath() {
		return child.getPath();
	}

	public String getTitle() {
		return title;
	}

	public Resource getSocialResource() {
		return socialResource;

	}

}
