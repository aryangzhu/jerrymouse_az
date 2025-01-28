package com.aryangzhu.before.listener;

import java.util.HashMap;
import java.util.Map;

public class OldStore {

    Customer customer;

    Admin admin;

    public OldStore() {
        intialize();
    }

    private void intialize() {
        customer=new Customer();
        admin=new Admin();
    }

    private Map<String,Product> products=new HashMap<>();

    public void addNewProduct(String name, double price) {
        Product product=new Product(name, price);
        products.put(name, product);
        customer.onPublished(name, price);
        admin.onPublished(name, price);
    }

    public void onPriceChanged(String name, double price) {
        Product product=products.get(name);
        product.setPrice(price);
        customer.onPriceChanged(name, price);
        admin.onPriceChanged(name, price);
    }

    public static void main(String[] args) {
        OldStore store=new OldStore();
        store.addNewProduct("apple", 10.0);
        store.onPriceChanged("apple", 11.0);
    }
}
