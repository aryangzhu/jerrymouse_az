package com.aryangzhu.connector;

import com.sun.net.httpserver.Headers;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

public class HttpExchangeAdapter implements HttpExchangeRequest,HttpExchangeResponse{
    @Override
    public String getRequestMethod() {
        return null;
    }

    @Override
    public URI getRequestURI() {
        return null;
    }

    @Override
    public Headers getResponseHeaders() {
        return null;
    }

    @Override
    public void sendResponseHeaders(int statusCode, long contentLength) throws IOException {

    }

    @Override
    public OutputStream getResponseBody() {
        return null;
    }
}
