package com.threeclear.pollution.constant;

/**
 * 报警状态枚举
 *
 * @author syf
 */
public enum AlertStatusEnum {
    PRE_HANDLE("0", "待受理"),
    HANDLING("1", "处置中"),
    REVIEWING("2", "审核中"),
    COMPLETED("3", "已办结");
    private String code;
    private String name;

    private AlertStatusEnum() {
    }

    private AlertStatusEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static String getValue(String code) {
        for (AlertStatusEnum value : values()) {
            if (value.getCode().equals(code)) {
                return value.getName();
            }
        }
        return null;
    }
}
