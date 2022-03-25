package com.example.demo;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.AbstractView;

import net.sf.jett.transform.ExcelTransformer;

public class JettView extends AbstractView {
    private String templatePath;
    private String exportFileName;

    public JettView(String templatePath, String exportFileName) {
        this.templatePath = templatePath;
        if (exportFileName != null) {
            try {
                exportFileName = URLEncoder.encode(exportFileName, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        this.exportFileName = exportFileName;
        setContentType("application/vnd.ms-excel");
        // setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    }

    @Override
    protected void renderMergedOutputModel(Map<String, Object> map, HttpServletRequest request, HttpServletResponse response) throws Exception {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(templatePath)) {
            response.setContentType(getContentType());
            response.setHeader("content-disposition", "attachment;filename=" + exportFileName + ".xlsx");
            ServletOutputStream os = response.getOutputStream();
            Workbook workbook = new ExcelTransformer().transform(is, map);
            workbook.write(os);
            os.close();
        }
    }
    
}
