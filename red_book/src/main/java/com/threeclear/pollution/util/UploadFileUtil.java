package com.threeclear.pollution.util;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

/**
 * 上传文件工具类
 * @author syf
 */
public class UploadFileUtil {
    /**
     * 上传图片
     * @param file  文件
     * @param dirPath   文件路径名
     * @return
     */
    public static Map<String, String> uploadImg(MultipartFile file, String dirPath){
        List<String> suffixList = new ArrayList<>();
        suffixList.add(".png");
        suffixList.add(".jpg");
        suffixList.add(".jpeg");
        return upload(file, dirPath, suffixList);
    }

    /**
     * 上传文件（全文件名重复会覆盖）
     * @param file 上传的文件
     * @param dirPath   文件路径名
     * @param suffixList    后缀限制列表(可不传则为无限制)
     * @return
     */
    public static Map<String, String> upload(MultipartFile file, String dirPath, List<String> suffixList){
        return upload(file, dirPath, null, suffixList, true);
    }

    /**
     * 上传文件
     * @param file 上传的文件
     * @param dirPath   文件路径名
     * @param fileName  文件名称(可不传则自动补充为uuid)
     * @param suffixList    后缀限制列表(可不传则为无限制)
     * @param ignoreFileExist   全文件名相同处理方法（true覆盖，false不处理返回异常信息）
     * @return
     */
    public static Map<String, String> upload(MultipartFile file, String dirPath, String fileName, List<String> suffixList, boolean ignoreFileExist){
        String originalFilename = file.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        //格式判断
        if(CollUtil.isNotEmpty(suffixList)){
            boolean formatFit = false;
            for (String suf:suffixList) {
                if(suffix.equals(suf)){
                    formatFit = true;
                    break;
                }
            }
            if(!formatFit){
                return getResultMap(false, "文件格式不匹配");
            }
        }

        File dir = new File(dirPath);
        if(!dir.exists()){
            boolean mkdirSuccess = dir.mkdirs();
            if(!mkdirSuccess){
                return  getResultMap(false, "创建文件路径失败");
            }
        }

        fileName = (StrUtil.isBlank(fileName) ? UUID.randomUUID().toString() : fileName).replace("-","")+suffix;
        //全文件名
        String fullName = dirPath + fileName;
        File newFile = new File(fullName);
        //是否无视重复文件
        if(!ignoreFileExist){
            if(newFile.exists()){
                return getResultMap(false, "文件已存在");
            }
        }
        FileOutputStream fos = null;
        try{
            fos = new FileOutputStream(newFile);
            fos.write(file.getBytes());
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fos.close();
            } catch (IOException e) {
                fos = null;
            }
        }
        return getResultMap(true, fullName);
    }

    private static Map<String, String> getResultMap(boolean success, String msg){
        Map<String, String> resultMap = new HashMap<>();
        if(success){
            resultMap.put("status", "200");
        }else{
            resultMap.put("status", "500");
        }
        resultMap.put("msg", msg);
        return resultMap;
    }
}
