package com.threeclear.pollution.entity.hiki;

import lombok.Data;

import java.util.List;

/**
 * @author guojing
 * @date 2022/1/11 11:27
 */
@Data
public class LiveUrlDto {
    private List<HlsBeanXo> hlsBeanXoList;

    @Data
    public static class HlsBeanXo {
        /**
         * 设备编号
         */
        private String devicecode;

        /**
         * 通道序号
         * 如果ipc在nvr中，只需要输入对应的通道号就行
         */
        private String chnSeq;

        /**
         * 码流类型
         * 1-主码流，2-辅码流;3-三码流
         */
        private String streamType;

    }
}
