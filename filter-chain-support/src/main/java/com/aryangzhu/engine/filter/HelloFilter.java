package com.aryangzhu.engine.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Set;

@WebFilter(urlPatterns = "/hello")
public class HelloFilter implements Filter {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    Set<String> names=Set.of("Bob", "Alice", "Tom", "Jerry");

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req= (HttpServletRequest) servletRequest;
        String name = req.getParameter("name");
        logger.info("Check parameter name={}",name);
        if(name!=null && names.contains(name)){
            filterChain.doFilter(servletRequest, servletResponse);
        }else{
            logger.warn("Access denied: name={}",name);
            HttpServletResponse resp= (HttpServletResponse) servletResponse;
            resp.sendError(403,"Forbidden");
        }
    }
}
