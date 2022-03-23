package com.threeclear.pollution.constant;

/**
 * @author lianghaibin
 * @create 2022/2/3 17:30
 */
public enum SortEnum {
    ASC(true,"正序"),
    DESC(false,"倒序");
    /**
     * 编码
     */
    private boolean code;
    /**
     * 名称
     */
    private String name;

    private SortEnum(boolean code,String name){
        this.code = code;
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public boolean getCode() {
        return code;
    }
}
