package com.example.demo;

import java.util.Map;

import net.sf.jett.transform.ExcelTransformer;

public class ExcelUtil {

    /**
     * 生成Excel文件
     * @param templateFileName
     * @param targetFileName
     * @param map
     */
    public static void generateExcel(String templateFileName, String targetFileName, Map<String, Object> map) {
        ExcelTransformer transformer = new ExcelTransformer();
        try {
            transformer.transform(templateFileName, targetFileName, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
