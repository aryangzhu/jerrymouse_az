package com.aryangzhu.engine.support;

import java.util.Collections;
import java.util.Map;

public class LazyMap<V> {

    private Map<String,V> map=null;

    protected V get(String name){
        if(this.map==null){
            return null;
        }
        return this.map.get(name);
    }

    protected boolean containsKey(String name){
        if(this.map==null){
            return false;
        }
        return this.map.containsKey(name);
    }

    protected V put(String name,V value){
        if(this.map==null){
            this.map=new java.util.HashMap<>();
        }
        return this.map.put(name, value);
    }

    protected Map<String,V> map(){
        if(this.map==null){
            return Map.of();
        }
        return Collections.unmodifiableMap(this.map);
    }
}
