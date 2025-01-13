package com.aryangzhu.engine;

import jakarta.servlet.*;

import java.util.*;

public class ServletRegistrationImpl implements ServletRegistration.Dynamic {

    final ServletContext servletContext;

    final String name;

    final Servlet servlet;

    final List<String> urlPatterns=new ArrayList<>(4);

    boolean initialized=false;

    public ServletRegistrationImpl(ServletContext servletContext, String name, Servlet servlet) {
        this.servletContext = servletContext;
        this.name = name;
        this.servlet = servlet;
    }

    public ServletConfig getServletConfig(){
        return new ServletConfig() {
            @Override
            public String getServletName() {
                return ServletRegistrationImpl.this.name;
            }

            @Override
            public ServletContext getServletContext() {
                return ServletRegistrationImpl.this.servletContext;
            }

            @Override
            public String getInitParameter(String name) {
                return null;
            }

            @Override
            public Enumeration<String> getInitParameterNames() {
                return null;
            }
        };
    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getClassName() {
        return servlet.getClass().getName();
    }

    @Override
    public Set<String> addMapping(String... urlPatterns) {
        if (urlPatterns == null || urlPatterns.length == 0) {
            throw new IllegalArgumentException("Missing urlPatterns.");
        }
        for (String urlPattern : urlPatterns) {
            this.urlPatterns.add(urlPattern);
        }
        return Set.of();
    }

    @Override
    public Collection<String> getMappings() {
        return this.urlPatterns;
    }


    @Override
    public void setLoadOnStartup(int i) {

    }

    @Override
    public Set<String> setServletSecurity(ServletSecurityElement servletSecurityElement) {
        return null;
    }

    @Override
    public void setMultipartConfig(MultipartConfigElement multipartConfigElement) {

    }

    @Override
    public void setRunAsRole(String s) {

    }

    @Override
    public void setAsyncSupported(boolean b) {

    }



    @Override
    public String getRunAsRole() {
        return null;
    }


    @Override
    public boolean setInitParameter(String s, String s1) {
        return false;
    }

    @Override
    public String getInitParameter(String s) {
        return null;
    }

    @Override
    public Set<String> setInitParameters(Map<String, String> map) {
        return null;
    }

    @Override
    public Map<String, String> getInitParameters() {
        return null;
    }
}
