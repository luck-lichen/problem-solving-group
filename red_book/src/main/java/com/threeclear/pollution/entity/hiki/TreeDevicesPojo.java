package com.threeclear.pollution.entity.hiki;

import lombok.Data;

import java.util.List;

/**
 * 获取设备树
 * @author guojing
 * @date 2022/1/11 10:37
 */
@Data
public class TreeDevicesPojo {

    /**
     * 设备列表
     */
    private List<Device> devices;

    @Data
    public static class Device{
        private String code;
        private String name;
        private String category;
        private String type;
        private String model;
        private String status;
        private String offlineReason;
        private String protocol;
        private String manufacturer;
        private String deviceIp;
        private String devicePort;
        private String proxyIp;
        private String proxyPort;
        private String userName;
        private String password;
        private String loginType;
        private String orgCode;
        private String unitEnable;
        private String buildingEnable;
        private String domainId;
        private String modifyTime;
        private String sipId;
        private String sipPwd;
        private String bindingConfirmVtoDeviceCodes;
        private String softwareVersion;
        private String hardwareVersion;
        private String callNumber;
        private String sn;
        private List<Unit> units;

        @Data
        public static class Unit{
            private String unitType;
            private String unitSeq;
            private String assistStream;
            private String zeroChnEncode;
            private String ssServiceId;
            private String sn;
            private String ptsServiceId;
            private String streamType;
            private String decodeMode;
            private String streamMode;
            private String conbineStatus;
            private String thirdPartyControl;
            private String voiceServerIp;
            private String voiceServerPort;
            private String voiceStatusPort;
            private String voiceClientIp;
            private String dynCode;
            private String dynName;
            private String dynType;
            private String fingerPrintAuth;
            private String cardAuth;
            private String faceAuth;
            private String userIsolate;
            private String unlockModes;
            private List<Channel> channels;

            @Data
            public static class Channel{
                private String channelCode;
                private String channelName;
                private String channelSeq;
                private String status;
                private String sn;
                private String gpsX;
                private String gpsY;
                private String mapId;
                private String cameraType;
                private String channelType;
                private String channelSubtype;
                private String remoteType;
                private String cameraFunctions;
                private String multicastIp;
                private String multicastPort;
                private String ipcIp;
                private String recordType;
                private String forPeopleCount;
                private String maxSplitNum;
                private String interfaceType;
                private String alarmType;
                private String alarmLevel;
                private String signalType;
                private String accessType;
                private String posType;
                private String posModel;
                private String dynCode;
                private String faceFunctions;
                private String keyCode;
                private String db33Code;
                private String intelliState;
                private String faceAnalyseType;
                private String videoSource;
                private String targetDetection;
                private String capability;
                private String domainId;
            }
        }
    }
}
