package com.aryangzhu.before.listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewStore implements ProductObservable {

    private List<ProductObserver> observers = new ArrayList<>();

    private Map<String, Product> products = new HashMap<>();

    @Override
    public void addObserver(ProductObserver observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(ProductObserver observer) {
        this.observers.remove(observer);
    }

    public void changeEvent(Integer code,String message){
        observers.forEach(observer -> observer.onEvent(new ProductEvent(EventEnum.ADD_NEW_PRODUCT,message)));
    }


    public void addNewProduct(String name, double price) {
        Product p = new Product(name, price);
        products.put(p.getName(), p);
        observers.forEach(observer -> observer.onPublish(p));
    }

    public void setProductPrice(String name,double price){
        Product p  = products.get(name);
        p.setPrice(price);
        observers.forEach(observer ->observer.onPriceChange(p));
    }

    public static void main(String[] args) {
        NewStore store = new NewStore();
        store.addObserver(new Customer());
        store.addObserver(new Admin());
        store.changeEvent(0,"add new product");
    }
}
