package com.aryangzhu.connector;

import com.sun.net.httpserver.Headers;

import java.io.IOException;
import java.io.OutputStream;

public interface HttpExchangeResponse {

    Headers getResponseHeaders();

    void sendResponseHeaders(int statusCode, long contentLength) throws IOException;

    OutputStream getResponseBody();
}
