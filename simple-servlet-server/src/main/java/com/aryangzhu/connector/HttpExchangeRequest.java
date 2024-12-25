package com.aryangzhu.connector;

import java.net.URI;

public interface HttpExchangeRequest {
    String  getRequestMethod();

    URI getRequestURI();

}
