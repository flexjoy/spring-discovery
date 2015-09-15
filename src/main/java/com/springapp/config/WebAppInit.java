package com.springapp.config;

import com.springapp.config.security.SecurityConfig;
import org.h2.server.web.WebServlet;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.DispatcherType;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import java.util.EnumSet;

/**
 *  Spring application initializing class.
 *
 *  Replaces web.xml file.
 *
 * @author Sergey Cherepanov
 */
public class WebAppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {
                RootConfig.class,
                SecurityConfig.class
        };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { ServletConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    @Override
    protected void registerDispatcherServlet(ServletContext servletContext) {
        super.registerDispatcherServlet(servletContext);
        Servlet servlet = new WebServlet();
        ServletRegistration.Dynamic h2 = servletContext.addServlet("H2Console", servlet);
        h2.setLoadOnStartup(2);
        h2.addMapping("/h2/*");
    }

    @Override
    protected Filter[] getServletFilters() {
        return new Filter[] {new HiddenHttpMethodFilter()};
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        servletContext
                .addFilter("getMethodConvertingFilter", new GetMethodConvertingFilter())
                .addMappingForUrlPatterns(EnumSet.of(DispatcherType.FORWARD), true, "/*");
    }
}
