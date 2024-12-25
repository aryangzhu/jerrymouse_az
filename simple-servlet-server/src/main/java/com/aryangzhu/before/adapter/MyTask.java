package com.aryangzhu.before.adapter;

import java.util.concurrent.Callable;

public class MyTask<V> implements Callable {
    private long num;

    public MyTask(long num) {
        this.num = num;
    }

    @Override
    public V call() throws Exception {
        long r=0;
        for(long i=1;i<=num;i++) {
            r+=i;
        }
        System.out.println("Result:"+r);
        return null;
    }
}
