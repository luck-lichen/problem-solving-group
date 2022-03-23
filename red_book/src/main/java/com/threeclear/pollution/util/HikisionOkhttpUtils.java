//package com.threeclear.pollution.util;
//
//import com.google.common.collect.Maps;
//import com.hikvision.artemis.sdk.config.ArtemisConfig;
//import com.hikvision.artemis.sdk.util.MessageDigestUtil;
//import com.hikvision.artemis.sdk.util.SignUtil;
//import okhttp3.*;
//import okio.BufferedSink;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//import java.net.MalformedURLException;
//import java.net.URLDecoder;
//import java.nio.charset.StandardCharsets;
//import java.util.*;
//
///**
// * 海康流媒体工具类
// * Created by Administrator on 2021/8/21.
// */
//@Component
//public class HikisionOkhttpUtils {
//    @Autowired
//    private OkHttpClient okHttpClient;
//
//    public String doPostStringArtemis(String scheme, String path, String body, Map<String, String> querys, String accept, String contentType, Map<String, String> header) {
//
//        try {
//            Map<String, String> headerMap = Maps.newLinkedHashMap();
//            if (StringUtils.isNotBlank(accept)) {
//                headerMap.put("Accept", accept);
//            } else {
//                headerMap.put("Accept", "*/*");
//            }
//
//            if (StringUtils.isNotBlank(contentType)) {
//                headerMap.put("Content-Type", contentType);
//            } else {
//                headerMap.put("Content-Type", "application/text;charset=UTF-8");
//            }
//
//            if (header != null) {
//                headerMap.putAll(header);
//            }
//            String url = HttpUrl.parse(scheme + "://" + ArtemisConfig.host + path)
//                    .newBuilder()
//                    .build()
//                    .toString();
//
//
//            Request.Builder build = new Request.Builder();
//            Headers.Builder headerBuilder = new Headers.Builder();
//            Map<String, String> headers = initHeader(path, body, querys, headerMap);
//            Iterator<Map.Entry<String, String>> iterator = headers.entrySet().iterator();
//            while (iterator.hasNext()) {
//                Map.Entry<String, String> next = iterator.next();
//                headerBuilder.add(next.getKey(), MessageDigestUtil.utf8ToIso88591(next.getValue()));
//            }
//            Request request = build.url(url)
//                    .headers(headerBuilder.build())
//                    .post(new RequestBody() {
//                        @Override
//                        public MediaType contentType() {
//                            return null;
//                        }
//
//                        @Override
//                        public void writeTo(BufferedSink sink) throws IOException {
//                            sink.write(body.getBytes(StandardCharsets.UTF_8));
//                        }
//                    })
//                    .build();
//            Response execute = okHttpClient.newCall(request).execute();
//            String json = execute.body() != null ? execute.body().string() : "";
//            return json;
//        } catch (IOException e) {
//            return "";
//        }
//    }
//
//    private Map<String, String> initHeader(String path, String body, Map<String, String> querys, Map<String, String> headers) throws MalformedURLException {
//        String contentType = headers.get("Content-Type");
//        if ("application/x-www-form-urlencoded;charset=UTF-8".equals(contentType)) {
//            Map<String, String> paramMap = strToMap(body);
//            String modelDatas = (String) paramMap.get("modelDatas");
//            if (StringUtils.isNotBlank(modelDatas)) {
//                paramMap.put("modelDatas", URLDecoder.decode(modelDatas));
//            }
//
//            headers = initialBasicHeader("POST", path, headers, querys, paramMap, null, ArtemisConfig.appKey, ArtemisConfig.appSecret);
//        } else {
//            headers = initialBasicHeader("POST", path, headers, querys, (Map) null, null, ArtemisConfig.appKey, ArtemisConfig.appSecret);
//        }
//
//
//        return headers;
//    }
//
//    private static Map<String, String> initialBasicHeader(String method, String path, Map<String, String> headers, Map<String, String> querys, Map<String, String> bodys, List<String> signHeaderPrefixList, String appKey, String appSecret) throws MalformedURLException {
//        if (headers == null) {
//            headers = new HashMap();
//        }
//
//        ((Map) headers).put("x-ca-timestamp", String.valueOf((new Date()).getTime()));
//        ((Map) headers).put("x-ca-nonce", UUID.randomUUID().toString());
//        ((Map) headers).put("x-ca-key", appKey);
//        ((Map) headers).put("x-ca-signature", SignUtil.sign(appSecret, method, path, (Map) headers, querys, bodys, signHeaderPrefixList));
//        return (Map) headers;
//    }
//
//    private static Map<String, String> strToMap(String str) {
//        HashMap map = new HashMap();
//
//        try {
//            String[] params = str.split("&");
//            String[] var3 = params;
//            int var4 = params.length;
//
//            for (int var5 = 0; var5 < var4; ++var5) {
//                String param = var3[var5];
//                String[] a = param.split("=");
//                map.put(a[0], a[1]);
//            }
//
//            return map;
//        } catch (Exception var8) {
//            throw new RuntimeException(var8);
//        }
//    }
//}
//
//
