package com.aryangzhu.engine.listener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebListener
public class HelloHttpSessionListener implements HttpSessionListener {

    final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        logger.info(">>> HttpSession created: {}", se.getSession());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        logger.info(">>> HttpSession destroyed: {}", se.getSession());
    }
}
