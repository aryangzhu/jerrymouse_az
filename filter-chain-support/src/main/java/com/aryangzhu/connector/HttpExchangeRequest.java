package com.aryangzhu.connector;

import com.sun.net.httpserver.Headers;

import java.io.IOException;
import java.net.URI;

public interface HttpExchangeRequest {
    String  getRequestMethod();

    URI getRequestURI();

    Headers getRequestHeaders();

    byte[] getRequestBody() throws IOException;

}
