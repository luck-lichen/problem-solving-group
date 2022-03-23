package com.threeclear.pollution.util;

import cn.hutool.core.date.DatePattern;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 下载文件工具类
 * @author syf
 */
public class DownloadFileUtil {
    /**
     * 多文件压缩下载
     * @param response
     * @param fileNames
     * @param filePaths
     */
    public static void downloadFileByPaths(HttpServletResponse response, String fileNames, String filePaths, String tempPath) {
        String [] names = fileNames.split(",");
        String [] paths = filePaths.split(",");
        //存放--服务器上zip文件的目录
        String directory = tempPath;
        File directoryFile=new File(directory);
        if(!directoryFile.isDirectory() && !directoryFile.exists()){
            directoryFile.mkdirs();
        }
        //设置最终输出zip文件的目录+文件名
        SimpleDateFormat formatter  = new SimpleDateFormat(DatePattern.NORM_DATETIME_PATTERN);
        String zipFileName = formatter.format(new Date())+".zip";
        String strZipPath = directory+"/"+zipFileName;

        ZipOutputStream zipStream = null;
        FileInputStream zipSource = null;
        BufferedInputStream bufferStream = null;
        File zipFile = new File(strZipPath);
        try{
            //构造最终压缩包的输出流
            zipStream = new ZipOutputStream(new FileOutputStream(zipFile));
            for (int i = 0; i<paths.length ;i++){
                //解码获取真实路径与文件名
                String realFileName = java.net.URLDecoder.decode(names[i],"UTF-8");
                String realFilePath = java.net.URLDecoder.decode(paths[i],"UTF-8");
                File file = new File(realFilePath);
                //TODO:未对文件不存在时进行操作，后期优化。
                if(file.exists())
                {
                    //将需要压缩的文件格式化为输入流
                    zipSource = new FileInputStream(file);
                    /**
                     * 压缩条目不是具体独立的文件，而是压缩包文件列表中的列表项，称为条目，就像索引一样这里的name就是文件名,
                     * 文件名和之前的重复就会导致文件被覆盖
                     */
                    //在压缩目录中文件的名字
                    ZipEntry zipEntry = new ZipEntry(realFileName);
                    //定位该压缩条目位置，开始写入文件到压缩包中
                    zipStream.putNextEntry(zipEntry);
                    bufferStream = new BufferedInputStream(zipSource, 1024 * 10);
                    int read = 0;
                    byte[] buf = new byte[1024 * 10];
                    while((read = bufferStream.read(buf, 0, 1024 * 10)) != -1)
                    {
                        zipStream.write(buf, 0, read);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭流
            try {
                if(null != bufferStream) {
                    bufferStream.close();
                }
                if(null != zipStream){
                    zipStream.flush();
                    zipStream.close();
                }
                if(null != zipSource) {
                    zipSource.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //判断系统压缩文件是否存在：true-把该压缩文件通过流输出给客户端后删除该压缩文件  false-未处理
        if(zipFile.exists()){
            downloadFileByPath(response, strZipPath, zipFileName);
            zipFile.delete();
        }
    }

    private static void downloadFileByPath(HttpServletResponse res, String filePath, String fileName){
        File file = new File(filePath);
        res.setCharacterEncoding("UTF-8");
        res.setHeader("content-type", "application/octet-stream;charset=UTF-8");
        res.setContentType("application/octet-stream;charset=UTF-8");
        //加上设置大小下载下来的.xlsx文件打开时才不会报“Excel 已完成文件级验证和修复。此工作簿的某些部分可能已被修复或丢弃”
        res.addHeader("Content-Length", String.valueOf(file.length()));
        try {
            res.setHeader("Content-Disposition", "attachment;filename=" + java.net.URLEncoder.encode(fileName.trim(), "UTF-8"));
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            os = res.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(file));
            int i = bis.read(buff);
            while (i != -1) {
                os.write(buff, 0, buff.length);
                os.flush();
                i = bis.read(buff);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
