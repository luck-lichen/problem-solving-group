package com.threeclear.pollution.util;

import com.alibaba.excel.EasyExcel;
import com.threeclear.baseweb.util.HttpServletResponseUtil;
import com.threeclear.baseweb.vo.ServerResponse;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * easyExcel导出工具类
 * @author syf
 */
public class EasyExcelUtil {

    /**
     * 阿里的下载excle
     *
     * @param response
     * @param fileName 文件名称
     * @param head     数据类的类型
     * @param data     数据集合
     */
    public static void download(HttpServletResponse response, String fileName, Class head, List data) {
        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        try {
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf-8");
            // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
            fileName = URLEncoder.encode(fileName, "UTF-8");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xls");
            // 这里需要设置关闭流(在阿里的示例中做了我做了更改)
            EasyExcel.write(response.getOutputStream(), head)
                    .autoCloseStream(Boolean.TRUE).sheet("sheet")
                    .doWrite(data);
        } catch (Exception e) {
            response.reset();
            try {
                HttpServletResponseUtil.send(response, ServerResponse.createByErrorMessage("下载文件失败"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
