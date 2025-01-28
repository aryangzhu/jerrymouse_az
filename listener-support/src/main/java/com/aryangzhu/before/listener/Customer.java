package com.aryangzhu.before.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Customer implements Person,ProductObserver{

    private Logger  logger = LoggerFactory.getLogger(Customer.class);
    @Override
    public void onPublished(String name, double price) {
        System.out.println("Customer add new product");
    }

    @Override
    public void onPriceChanged(String name, double price) {
        System.out.println("Customer on price changed");
    }

    @Override
    public void onPublish(Product product) {
        System.out.println("Customer on publish");
    }

    @Override
    public void onPriceChange(Product product) {
        System.out.println("Customer on price change");
    }

    @Override
    public void onEvent(ProductEvent event) {
        logger.info("Admin on event:eventType{}-message{}",event.getEventType().getVale(),event.getMessage());
    }
}
