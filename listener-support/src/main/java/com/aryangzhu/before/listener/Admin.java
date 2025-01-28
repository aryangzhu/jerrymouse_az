package com.aryangzhu.before.listener;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Admin implements Person,ProductObserver{

    Logger logger = LoggerFactory.getLogger(Admin.class);
    @Override
    public void onPublished(String name, double price) {
        System.out.println("Admin add new product");
    }

    @Override
    public void onPriceChanged(String name, double price) {
        System.out.println("Admin on price changed");
    }

    @Override
    public void onPublish(Product product) {
        System.out.println("Admin on publish");
    }

    @Override
    public void onPriceChange(Product product) {
        System.out.println("Admin on price change");
    }

    @Override
    public void onEvent(ProductEvent event) {
        logger.info("Admin on event:eventType{}-message{}",event.getEventType().getVale(),event.getMessage());
    }
}
