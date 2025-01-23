package com.aryangzhu.before.adapter;



public class StartBySingleThread {
    public static void main(String[] args) {
        new Thread(new RunnableAdapter(new MyTask(10L))).start();
    }
}
