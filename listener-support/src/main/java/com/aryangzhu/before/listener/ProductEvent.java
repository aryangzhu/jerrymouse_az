package com.aryangzhu.before.listener;

public class ProductEvent {

    private EventEnum eventType;

    private String message;

    public ProductEvent(EventEnum eventType, String message) {
        this.eventType = eventType;
        this.message = message;
    }

    public EventEnum getEventType() {
        return eventType;
    }

    public void setEventType(EventEnum eventType) {
        this.eventType = eventType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
