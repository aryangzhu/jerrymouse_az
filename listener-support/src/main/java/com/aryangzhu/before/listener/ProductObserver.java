package com.aryangzhu.before.listener;

public interface ProductObserver{

    void onPublish(Product product);

    void onPriceChange(Product product);

    void onEvent(ProductEvent event);
}
