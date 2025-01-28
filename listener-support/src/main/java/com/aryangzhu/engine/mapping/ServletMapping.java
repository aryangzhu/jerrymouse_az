package com.aryangzhu.engine.mapping;

import jakarta.servlet.Servlet;

public class ServletMapping extends AbstractMapping{

    public final Servlet servlet;

    public ServletMapping(String url, Servlet servlet) {
        super(url);
        this.servlet = servlet;
    }
}
