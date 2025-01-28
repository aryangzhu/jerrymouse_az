package com.aryangzhu.utils;

import jakarta.servlet.Filter;
import jakarta.servlet.Servlet;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class AnnoUtils {

    public static String getServletName(Class<? extends Servlet> clazz){
        WebServlet annotation = clazz.getAnnotation(WebServlet.class);
        if(annotation!=null && !annotation.name().isEmpty()){
            return annotation.name();
        }
        return defaultNameByClass(clazz);
    }

    public static String getFilterName(Class<? extends Filter> clazz){
        WebServlet annotation = clazz.getAnnotation(WebServlet.class);
        if(annotation!=null && !annotation.name().isEmpty()){
            return annotation.name();
        }
        return defaultNameByClass(clazz);
    }

    public static Map<String,String> getServletInitParams(Class<? extends Servlet> clazz){
        WebServlet annotation = clazz.getAnnotation(WebServlet.class);
        if(annotation==null){
            return Map.of();
        }
        return initParamToMap(annotation.initParams());
    }

    public static Map<String,String> getFilterInitParams(Class<? extends Filter> clazz){
        WebServlet annotation = clazz.getAnnotation(WebServlet.class);
        if(annotation==null){
            return Map.of();
        }
        return initParamToMap(annotation.initParams());
    }

    public static String[] getServletUrlPatterns(Class<? extends Servlet> clazz){
        WebServlet annotation = clazz.getAnnotation(WebServlet.class);
        if(annotation==null){
            return new String[0];
        }
        return arraysToSet(annotation.value(),annotation.urlPatterns()).toArray(String[]::new );
    }

    public static String[] getFilterUrlPatterns(Class<? extends Filter> clazz) {
        WebFilter w = clazz.getAnnotation(WebFilter.class);
        if (w == null) {
            return new String[0];
        }
        return arraysToSet(w.value(), w.urlPatterns()).toArray(String[]::new);
    }


    private static String defaultNameByClass(Class<?> clazz){
        String name = clazz.getSimpleName();
        name=Character.toLowerCase(name.charAt(0))+name.substring(1);
        return name;
    }

    private static Map<String,String> initParamToMap(WebInitParam[] params){
        return Arrays.stream(params).collect(Collectors.toMap(p->p.name(),p->p.value()));
    }

    private static Set<String> arraysToSet(String[] arr1,String[] arr2){
        Set<String> set = arraysToSet(arr1);
        set.addAll(arraysToSet(arr2));
        return set;
    }

    private static Set<String> arraysToSet(String[] arr1){
        Set<String> set = new LinkedHashSet<>();
        for(String s:arr1){
            set.add(s);
        }
        return set;
    }
}
