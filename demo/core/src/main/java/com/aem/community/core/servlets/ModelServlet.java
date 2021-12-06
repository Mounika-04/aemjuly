/*
 *  Copyright 2015 Adobe Systems Incorporated
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.aem.community.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.servlets.HttpConstants;

import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.models.factory.ModelFactory;
import org.apache.sling.api.resource.ValueMap;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.aem.community.core.models.TestModel;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;


@Component(service=Servlet.class,
           property={
                   Constants.SERVICE_DESCRIPTION + "=Simple Demo Servlet",
                   "sling.servlet.methods=" + HttpConstants.METHOD_GET,
                   "sling.servlet.paths="+ "/bin/servlet",
                   "sling.servlet.extensions=" + "txt"
           })
public class ModelServlet extends SlingSafeMethodsServlet {

    private static final long serialVersionUID = 1L;
    @Reference
    ModelFactory modelFactory;
    @Override
    protected void doGet(final SlingHttpServletRequest req,
            final SlingHttpServletResponse resp) throws ServletException, IOException {
         resp.getWriter().print("hi servlet");
         Resource resource = req.getResourceResolver().getResource("/content/mynewpage/mypage/jcr:content/parsys/childnode");

         TestModel test = modelFactory.createModel(resource, TestModel.class);
         resp.getWriter().println(test.getResourceType());
         resp.getWriter().println(modelFactory.canCreateFromAdaptable(resource, TestModel.class));
         resp.getWriter().println(modelFactory.canCreateFromAdaptable(req, TestModel.class));
    }
}
