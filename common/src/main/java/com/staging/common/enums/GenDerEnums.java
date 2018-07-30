package com.staging.common.enums;

public enum GenDerEnums {

    BOY(1,"男"),
    GIRL(0,"女");

    private Integer code;

    private String value;

    GenDerEnums(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public Integer getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
