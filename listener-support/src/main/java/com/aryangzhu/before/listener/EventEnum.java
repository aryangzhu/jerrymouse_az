package com.aryangzhu.before.listener;

public enum EventEnum {
    ADD_NEW_PRODUCT(0,"new product"),
    CHANGE_PRICE(1,"change price");


    private Integer code;

    private String vale;

    EventEnum(Integer code, String vale) {
        this.code = code;
        this.vale = vale;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getVale() {
        return vale;
    }

    public void setVale(String vale) {
        this.vale = vale;
    }

    public String getValeByCode(Integer code) {
        for (EventEnum eventEnum : EventEnum.values()) {
            if (eventEnum.getCode().equals(code)) {
                return eventEnum.getVale();
            }
        }
        return "UNKNOWN";
    }
}
