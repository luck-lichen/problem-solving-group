package com.threeclear.pollution.util;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import com.google.common.collect.Maps;
import com.hikvision.artemis.sdk.ArtemisHttpUtil;
import com.hikvision.artemis.sdk.config.ArtemisConfig;
import com.hikvision.artemis.sdk.constant.Constants;
import com.threeclear.pollution.entity.hiki.CamerasInfo;
import com.threeclear.pollution.entity.hiki.CamerasNodeInfo;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 海康流媒体工具类
 * Created by Administrator on 2021/8/21.
 */
@Component
public class HikvisionUtil {
    //@Autowired
    //private HikisionOkhttpUtils hikisionOkhttpUtils;

    public HikvisionUtil() {
        setStation(0);
    }

    public String getPreviewURLs(String cameraCode) {
        return getPreviewURLs(cameraCode, 1, "hls", 1, "streamform=rtp");
    }

    /***
     * 获取流媒体地址
     * @param cameraCode 摄像头code
     * @return
     */
    public String getPreviewURLs(String cameraCode, int streamType, String protocol, int transmode, String expand) {
        ArtemisConfig.host = "10.122.88.239:443";// 代理API网关nginx服务器ip端口 乡镇站
        ArtemisConfig.appKey = "27071795";// 秘钥appkey
        ArtemisConfig.appSecret = "dF2uLYe1JtG5uoSqirps";

        final String getSecurityApi = "/artemis/api/video/v1/cameras/previewURLs";
        Map path = Maps.newHashMap();
        path.put("https://", getSecurityApi);
        Constants.DEFAULT_TIMEOUT = 20000;
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("cameraIndexCode", cameraCode);
        jsonBody.put("streamType", streamType);
        jsonBody.put("protocol", protocol);
        jsonBody.put("transmode", transmode);
        jsonBody.put("expand", expand);
        String body = jsonBody.toJSONString();
       String result = ArtemisHttpUtil.doPostStringArtemis(path, body, null, null, "application/json", null);
  //      String result = hikisionOkhttpUtils.doPostStringArtemis("https", getSecurityApi, body, null, null, "application/json", null);
        //将内网IP替换成公网IP
//        if (StringUtils.isNotBlank(result)) {
//            result = result.replaceAll("192.168.1.95", "61.155.197.83").replace("10.122.96.48","222.223.141.65");
//        }
        return result;
    }


    /***
     * 获取流媒体地址
     * @return
     */
    public String doApi(String api, String body) {
        ArtemisConfig.host = "10.122.88.239:443";// 代理API网关nginx服务器ip端口 乡镇站
        ArtemisConfig.appKey = "27071795";// 秘钥appkey
        ArtemisConfig.appSecret = "dF2uLYe1JtG5uoSqirps";
        Map path = Maps.newHashMap();
        path.put("https://", api);
        Constants.DEFAULT_TIMEOUT = 20000;
        if (StringUtils.isBlank(body)) {
            body = null;
        }
        String result = "";
       result = ArtemisHttpUtil.doPostStringArtemis(path, body, null, null, "application/json", null);
    //    result = hikisionOkhttpUtils.doPostStringArtemis("https", api, body, null, null, "application/json", null);
        return result;
    }


    private LoadingCache<String, List<CamerasInfo>> camerasCache = Caffeine.newBuilder().maximumSize(1).expireAfterWrite(5, TimeUnit.HOURS).build(this::getCamerasCache);

    public List<CamerasInfo> getCameras() {
        return camerasCache.get("new");
    }

    /***
     * 获取所有摄像头信息
     * @return
     */
    private List<CamerasInfo> getCamerasCache(String key) {
        ArtemisConfig.host = "10.122.88.239:443";// 代理API网关nginx服务器ip端口 乡镇站
        ArtemisConfig.appKey = "27071795";// 秘钥appkey
        ArtemisConfig.appSecret = "dF2uLYe1JtG5uoSqirps";
        List<CamerasInfo> camerasInfos = Lists.newArrayList();
        final String getSecurityApi = "/artemis/api/resource/v1/cameras";
        Map path = Maps.newHashMap();
        path.put("https://", getSecurityApi);
        Constants.DEFAULT_TIMEOUT = 50000;
        int total = 0;
        int current = 0;
        int page = 1;
        while (current < total || page == 1) {
            JSONObject jsonBody = new JSONObject();
            jsonBody.put("pageNo", page);
            jsonBody.put("pageSize", 100);
            String body = jsonBody.toJSONString();
            String result = ArtemisHttpUtil.doPostStringArtemis(path, body, null, null, "application/json", null);
          //  String result = hikisionOkhttpUtils.doPostStringArtemis("https", getSecurityApi, body, null, null, "application/json", null);
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                JsonNode jsonNode = objectMapper.readTree(result);
                if ("0".equals(jsonNode.get("code").asText())) {
                    JsonNode data = jsonNode.get("data");
                    if (page == 1) {
                        total = data.get("total").asInt();
                    }
                    JsonNode list = data.get("list");
                    ObjectReader objectReader = objectMapper.readerFor(new TypeReference<List<CamerasInfo>>() {
                    });
                    List<CamerasInfo> infos = objectReader.readValue(list);
                    current += infos.size();
                    camerasInfos.addAll(infos);
                }
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
            page++;
        }

        return camerasInfos;
    }

    private LoadingCache<String, List<CamerasNodeInfo>> camerasNodeCache = Caffeine.newBuilder().maximumSize(1).expireAfterWrite(5, TimeUnit.HOURS).build(this::getAllNodesCache);

    public List<CamerasNodeInfo> getAllNodes() {
        return camerasNodeCache.get("now");
    }


    /***
     * 获取所有区域信息
     * @return
     */
    private List<CamerasNodeInfo> getAllNodesCache(String key) {
        ArtemisConfig.host = "10.122.88.239:443";// 代理API网关nginx服务器ip端口 乡镇站
        ArtemisConfig.appKey = "27071795";// 秘钥appkey
        ArtemisConfig.appSecret = "dF2uLYe1JtG5uoSqirps";
        List<CamerasNodeInfo> camerasNodeInfos = Lists.newArrayList();
        final String getSecurityApi = "/artemis/api/irds/v2/region/nodesByParams";
        Map path = Maps.newHashMap();
        path.put("https://", getSecurityApi);
        Constants.DEFAULT_TIMEOUT = 50000;
        int total = 0;
        int current = 0;
        int page = 1;
        while (current < total || page == 1) {
            JSONObject jsonBody = new JSONObject();
            jsonBody.put("resourceType", "region");
            jsonBody.put("isSubRegion", true);
            jsonBody.put("pageNo", page);
            jsonBody.put("pageSize", 500);
            jsonBody.put("cascadeFlag", 0);
            String body = jsonBody.toJSONString();
          String result = ArtemisHttpUtil.doPostStringArtemis(path, body, null, null, "application/json", null);
        //    String result = hikisionOkhttpUtils.doPostStringArtemis("https", getSecurityApi, body, null, null, "application/json", null);
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                JsonNode jsonNode = objectMapper.readTree(result);
                if ("0".equals(jsonNode.get("code").asText())) {
                    JsonNode data = jsonNode.get("data");
                    if (page == 1) {
                        total = data.get("total").asInt();
                    }
                    JsonNode list = data.get("list");
                    ObjectReader objectReader = objectMapper.readerFor(new TypeReference<List<CamerasNodeInfo>>() {
                    });
                    List<CamerasNodeInfo> infos = objectReader.readValue(list);
                    current += infos.size();
                    camerasNodeInfos.addAll(infos);
                }
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
            page++;
        }
        return camerasNodeInfos;
    }

    //抓图
    public String getManualCapture(String cameraCode) {
        final String getSecurityApi = "/artemis/api/video/v1/manualCapture";
        Map path = Maps.newHashMap();
        path.put("https://", getSecurityApi);
        Constants.DEFAULT_TIMEOUT = 50000;
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("cameraIndexCode", cameraCode);
        String body = jsonBody.toJSONString();
        String result = ArtemisHttpUtil.doPostStringArtemis(path, body, null, null, "application/json", null);
       // String result = hikisionOkhttpUtils.doPostStringArtemis("https", getSecurityApi, body, null, null, "application/json", null);
        System.out.println(result);
        return result;
    }

    /**
     * 设置要获取的站点
     *
     * @param id
     */
    private void setStation(Integer id) {
        switch (id) {
            default:// 海康网关
                ArtemisConfig.host = "10.122.88.239:443";// 代理API网关nginx服务器ip端口 乡镇站
                ArtemisConfig.appKey = "27071795";// 秘钥appkey
                ArtemisConfig.appSecret = "dF2uLYe1JtG5uoSqirps";
                break;
        }
    }
}


