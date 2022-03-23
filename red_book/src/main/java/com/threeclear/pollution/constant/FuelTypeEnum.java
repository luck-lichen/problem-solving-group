package com.threeclear.pollution.constant;

public enum FuelTypeEnum {
    QI_YOU("A", "汽油"),
    CHAI_YOU("B", "柴油"),
    DIAN("C", "电"),
    HUN_HE_YOU("D", "混合油"),
    TIAN_RAN_QI("E", "天然气"),
    YE_TIAN_RAN_QI("F", "液化石油气"),
    JIA("L", "甲醇"),
    YI("M", "乙醇"),
    TAI_YANG("N", "太阳能"),
    HUN_HE("O", "混合动力"),
    NULL("Y", "无"),
    OTHER("Z", "其他");

    private String code;
    private String name;
    
    FuelTypeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
    public static String getValue(String code) {
        for (FuelTypeEnum value : values()) {
            if (value.getCode().equals(code)){
                return value.getName();
            }
        }
        return code;
    }
}
