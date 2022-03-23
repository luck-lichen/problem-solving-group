package com.threeclear.pollution.entity.hiki;

import lombok.Data;

import java.util.List;

/**
 * 获取组织树
 *
 * @author guojing
 * @date 2022/1/11 11:13
 */
@Data
public class TreeDevicesOrgPojo {
    /**
     * 组织信息
     */
    private List<Department> departments;

    @Data
    public static class Department {
        private String code;
        private String parentCode;
        private String name;
        private String orgType;
        private String modifyTime;
        private String deparmentsCount;
        private String domainId;
        private List<Device> device;
        private List<Channel> channel;

        @Data
        public static class Device {
            private String id;
            private String sort;
        }

        @Data
        public static class Channel{
            private String id;
            private String sort;
        }
    }

}
