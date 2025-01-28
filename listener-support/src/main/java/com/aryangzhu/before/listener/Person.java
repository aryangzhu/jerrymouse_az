package com.aryangzhu.before.listener;

public  interface Person {

    void onPublished(String name, double price);

    void onPriceChanged(String name,double price) ;
}
