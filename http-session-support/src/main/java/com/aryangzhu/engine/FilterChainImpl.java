package com.aryangzhu.engine;

import jakarta.servlet.*;

import java.io.IOException;

public class FilterChainImpl implements FilterChain {
    final Filter[] filters;

    final Servlet servlet;

    final int total;

    int index=0;

    public FilterChainImpl(Filter[] filters, Servlet servlet) {
        this.filters = filters;
        this.servlet = servlet;
        this.total = filters.length;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException, ServletException {
        if(index<total){
            int current=index;
            index++;
            filters[current].doFilter(servletRequest,servletResponse,this);
        }else{
            servlet.service(servletRequest,servletResponse);
        }
    }
}
