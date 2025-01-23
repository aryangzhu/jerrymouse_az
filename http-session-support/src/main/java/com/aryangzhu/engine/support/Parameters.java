package com.aryangzhu.engine.support;

import com.aryangzhu.connector.HttpExchangeRequest;
import com.aryangzhu.utils.HttpUtils;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parameters {

    private static final String POST_METHOD="POST";


    final HttpExchangeRequest exchangeRequest;

    public Parameters(HttpExchangeRequest exchangeRequest, Charset charset) {
        this.exchangeRequest = exchangeRequest;
        this.charset = charset;
    }

    Charset charset;

    Map<String,String[]> parameters;

    Map<String,String[]> initParameters(){
        Map<String, List<String>> params = new HashMap<>();
        String query = this.exchangeRequest.getRequestURI().getRawQuery();
        if(query!=null){
            params= HttpUtils.parseQuery(query,charset);
        }
        if(POST_METHOD.equals(this.exchangeRequest.getRequestMethod())){
            String value = HttpUtils.getHeader(this.exchangeRequest.getRequestHeaders(), "Content-Type");
            if(value!=null && value.startsWith("application/x-www-form-urlencoded")){
                String requestBody;
                try {
                    requestBody = new String(this.exchangeRequest.getRequestBody(), charset);
                } catch (IOException e) {
                    throw new UncheckedIOException(e);
                }
                Map<String, List<String>> postParams = HttpUtils.parseQuery(requestBody, charset);
                // merge:
                for (String key : postParams.keySet()) {
                    List<String> postValues = postParams.get(key);
                    List<String> queryValues = params.get(key);
                    if (queryValues == null) {
                        params.put(key, postValues);
                    } else {
                        queryValues.addAll(postValues);
                    }
                }
            }
        }
        if (params.isEmpty()) {
            return Map.of();
        }
        // convert:
        Map<String, String[]> paramsMap = new HashMap<>();
        for (String key : params.keySet()) {
            List<String> values = params.get(key);
            paramsMap.put(key, values.toArray(String[]::new));
        }
        return paramsMap;
    }
}
