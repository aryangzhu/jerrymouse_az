package com.aryangzhu.connector;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

public class HttpExchangeAdapter implements HttpExchangeRequest,HttpExchangeResponse{

    final HttpExchange exchange;

    byte[] requestBodyData;

    public HttpExchangeAdapter(HttpExchange exchange) {
        this.exchange = exchange;
    }

    @Override
    public String getRequestMethod() {
        return this.exchange.getRequestMethod();
    }

    @Override
    public URI getRequestURI() {
        return this.exchange.getRequestURI();
    }

    @Override
    public Headers getRequestHeaders() {
        return this.exchange.getRequestHeaders();
    }

    @Override
    public byte[] getRequestBody() throws IOException {
        if(this.requestBodyData==null){
            try(InputStream input = this.exchange.getRequestBody()){
                this.requestBodyData=input.readAllBytes();
            }
        }
        return this.requestBodyData;
    }

    @Override
    public Headers getResponseHeaders() {
        return this.exchange.getResponseHeaders();
    }

    @Override
    public void sendResponseHeaders(int statusCode, long contentLength) throws IOException {
        this.exchange.sendResponseHeaders(statusCode, contentLength);
    }

    @Override
    public OutputStream getResponseBody() {
        return this.exchange.getResponseBody();
    }
}
