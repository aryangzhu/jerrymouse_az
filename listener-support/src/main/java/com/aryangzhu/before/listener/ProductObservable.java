package com.aryangzhu.before.listener;

public interface ProductObservable {

    void addObserver(ProductObserver observer);

    void removeObserver(ProductObserver observer);
}
