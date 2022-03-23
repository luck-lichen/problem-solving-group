package com.threeclear.pollution.constant;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 查询参数列表
 * @author syf
 */
public enum ChartFactorEnum {
    DUST("a34013", "烟尘"),
    SO2("a21026", "二氧化硫"),
    NO("a21002", "氮氧化物"),
    CO("a21005", "一氧化碳");
    private String code;
    private String name;
    private ChartFactorEnum(){}
    private ChartFactorEnum(String code,String name){
        this.code = code;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    /**
     * 查询所有因子编码
     * @return
     */
    public static List<String> getCodes(){
        List<String> codeList = new ArrayList<>();
        for (ChartFactorEnum enums:values()) {
            codeList.add(enums.getCode());
        }
        return codeList;
    }

    /**
     * 查询所有尹梓明
     * @return
     */
    public static List<String> getNames(){
        List<String> nameList = new ArrayList<>();
        for (ChartFactorEnum enums:values()) {
            nameList.add(enums.getName());
        }
        return nameList;
    }

    /**
     * 根据code获取name
     * @param code
     * @return
     */
    public static String getNameByCode(String code){
        for (ChartFactorEnum enums:values()) {
            if(enums.getCode().equals(code)){
                return enums.getName();
            }
        }
        return null;
    }
}
