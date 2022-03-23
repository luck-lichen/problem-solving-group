package com.threeclear.pollution.util;

/**
 *油气回收状态对应关系
 */
public class ContrastingRelationsUtil {

    public static String contrastingRelations(String value) {
        if(value != null){
            switch (value) {
                case "0": return "正常";
                case "1": return "预警";
                case "2": return "报警";
                case "N": return "无效";
            }
        }
        return null;
    }
}
