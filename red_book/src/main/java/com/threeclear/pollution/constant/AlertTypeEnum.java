package com.threeclear.pollution.constant;

/**
 * 报警类型枚举
 *
 * @author syf
 */
public enum AlertTypeEnum {
    EXCEED_LIMIT(0, "pm10超标报警"),
    CONCENTRATION(1, "日浓度超标报警"),
    DUST(2, "小时浓度超标报警"),
    ERROR(3, "日排放量超标报警"),
    EXCEED_LIMIT_ALL(4, "浓度异常报警"),
    OUTPUT_PS_EXCEED_LIMIT(5, "排放量异常报警");
    private Integer code;
    private String name;

    private AlertTypeEnum() {
    }

    private AlertTypeEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getCode() {
        return code;
    }
    public static String getValue(String code) {
        for (AlertTypeEnum value : values()) {
            if (value.getCode().equals(code)){
                return value.getName();
            }
        }
        return null;
    }

    /**
     *根据表明，超标异常类型获取报警类型码
     * @param tableName 数据表名
     * @param standardType 报警标准类型(1-超标，2-异常)
     * @return
     */
    public static Integer getCodeBytableStandard(String tableName, Integer standardType){
        if(standardType.equals(1)){
            if(AirDataTableConstant.WR_DATA_DAY_AIR.equals(tableName)){
                return CONCENTRATION.getCode();
            }else if(AirDataTableConstant.WR_DATA_HOUR_AIR.equals(tableName)){
                return DUST.getCode();
            }
        }else if(standardType.equals(2)){
            if(AirDataTableConstant.WR_DATA_DAY_AIR.equals(tableName)){
                return null;
            }else if(AirDataTableConstant.WR_DATA_HOUR_AIR.equals(tableName)){
                return EXCEED_LIMIT_ALL.getCode();
            }
        }
        return null;
    }
}
