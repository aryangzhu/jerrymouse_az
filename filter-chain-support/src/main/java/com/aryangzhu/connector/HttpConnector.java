package com.aryangzhu.connector;

import com.aryangzhu.engine.HttpServletRequestImpl;
import com.aryangzhu.engine.HttpServletResponseImpl;
import com.aryangzhu.engine.ServletContextImpl;
import com.aryangzhu.engine.servlet.HelloServlet;
import com.aryangzhu.engine.servlet.IndexServlet;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.time.Duration;
import java.util.List;

public class HttpConnector implements AutoCloseable, HttpHandler {

    final Logger logger = LoggerFactory.getLogger(getClass());

    final ServletContextImpl servletContext;
    final HttpServer httpServer;
    final Duration stopDelay = Duration.ofSeconds(5);

    public HttpConnector() throws IOException {
        this.servletContext = new ServletContextImpl();
        this.servletContext.initialize(List.of(IndexServlet.class, HelloServlet.class));
        // start http server:
        String host = "0.0.0.0";
        int port = 8080;
        this.httpServer = HttpServer.create(new InetSocketAddress(host, port), 0, "/", this);
        this.httpServer.start();
        logger.info("jerrymouse http server started at {}:{}...", host, port);
    }

    @Override
    public void close() {
        this.httpServer.stop(3);
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        var adapter = new HttpExchangeAdapter(exchange);
        var request = new HttpServletRequestImpl(adapter);
        var response = new HttpServletResponseImpl(adapter);
        // process:
        try {
            this.servletContext.process(request, response);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

//    void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String name = request.getParameter("name");
//        String html = "<h1>Hello, " + (name == null ? "world" : name) + ".</h1>";
//        response.setContentType("text/html");
//        PrintWriter pw = response.getWriter();
//        pw.write(html);
//        pw.close();
//    }
}
