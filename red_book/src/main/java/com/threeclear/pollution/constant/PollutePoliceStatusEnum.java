package com.threeclear.pollution.constant;

/**
 * 报警状态编码枚举类
 *
 * @author lianghaibin
 * @create 2022/1/13 11:21
 */
public enum PollutePoliceStatusEnum {
    REMOVE("0","待处置"),
    ACCEPT("1","待受理"),
    DISPOSALING("2","处置中"),
    REVIEW("3","审核中"),
    TRANSFERRED("4","已办结"),
    DISPOSAL("5","已解除");
    /**
     * 编码
     */
    private String code;
    /**
     * 名称
     */
    private String name;

    private PollutePoliceStatusEnum(){}
    private PollutePoliceStatusEnum(String code,String name){
        this.code = code;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
    }
