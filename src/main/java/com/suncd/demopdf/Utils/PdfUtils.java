/*
 * 版权所有 © 成都太阳高科技有限责任公司
 * http://www.suncd.com
 */
package com.suncd.demopdf.Utils;

import com.lowagie.text.pdf.BaseFont;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.w3c.dom.Document;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * 功能：pdf处理工具类
 *
 * @author qust
 * @version 1.0 2018/2/23 17:21
 */
public class PdfUtils {
    private PdfUtils() {
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(PdfUtils.class);

    /**
     * 按模板和参数生成html字符串,再转换为flying-saucer识别的Document
     *
     * @param templateName freemarker模板名称
     * @param variables    freemarker模板参数
     * @return Document
     */
    private static Document generateDoc(FreeMarkerConfigurer configurer, String templateName, Map<String, Object> variables)  {
        Template tp;
        try {
            tp = configurer.getConfiguration().getTemplate(templateName);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
            return null;
        }

        StringWriter stringWriter = new StringWriter();
        try(BufferedWriter writer = new BufferedWriter(stringWriter)) {
            try {
                tp.process(variables, writer);
                writer.flush();
            } catch (TemplateException e) {
                LOGGER.error("模板不存在或者路径错误", e);
            } catch (IOException e) {
                LOGGER.error("IO异常", e);
            }
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            return builder.parse(new ByteArrayInputStream(stringWriter.toString().getBytes()));
        }catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            return null;
        }
    }

    /**
     * 核心: 根据freemarker模板生成pdf文档
     *
     * @param configurer   freemarker配置
     * @param templateName freemarker模板名称
     * @param out          输出流
     * @param listVars     freemarker模板参数
     * @throws Exception 模板无法找到、模板语法错误、IO异常
     */
    private static void generateAll(FreeMarkerConfigurer configurer, String templateName, OutputStream out, List<Map<String, Object>> listVars) throws Exception {
        if (CollectionUtils.isEmpty(listVars)) {
            LOGGER.warn("警告:freemarker模板参数为空!");
            return;
        }

        ITextRenderer renderer = new ITextRenderer();
        Document doc = generateDoc(configurer, templateName, listVars.get(0));
        renderer.setDocument(doc, null);
        //设置字符集(宋体),此处必须与模板中的<body style="font-family: SimSun">一致,区分大小写,不能写成汉字"宋体"
        ITextFontResolver fontResolver = renderer.getFontResolver();
        fontResolver.addFont("simsun.ttc", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        //展现和输出pdf
        renderer.layout();
        renderer.createPDF(out, false);

        //根据参数集个数循环调用模板,追加到同一个pdf文档中
        //(注意:此处从1开始,因为第0是创建pdf,从1往后则向pdf中追加内容)
        for (int i = 1; i < listVars.size(); i++) {
            Document docAppend = generateDoc(configurer, templateName, listVars.get(i));
            renderer.setDocument(docAppend, null);
            renderer.layout();
            renderer.writeNextDocument(); //写下一个pdf页面
        }
        renderer.finishPDF(); //完成pdf写入
    }

    /**
     * pdf下载
     *
     * @param configurer   freemarker配置
     * @param templateName freemarker模板名称(带后缀.ftl)
     * @param listVars     模板参数集
     * @param response     HttpServletResponse
     * @param fileName     下载文件名称(带文件扩展名后缀)
     */
    public static void download(FreeMarkerConfigurer configurer, String templateName, List<Map<String, Object>> listVars, HttpServletResponse response, String fileName) {
        // 设置编码、文件ContentType类型、文件头、下载文件名
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        try {
            response.setHeader("Content-Disposition", "attachment;fileName=" +
                    new String(fileName.getBytes("gb2312"), "ISO8859-1"));
        } catch (UnsupportedEncodingException e) {
            LOGGER.error(e.getMessage(), e);
        }
        try (ServletOutputStream out = response.getOutputStream()) {
            generateAll(configurer, templateName, out, listVars);
            out.flush();
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    /**
     * pdf预览
     *
     * @param configurer   freemarker配置
     * @param templateName freemarker模板名称(带后缀.ftl)
     * @param listVars     模板参数集
     * @param response     HttpServletResponse
     */
    public static void preview(FreeMarkerConfigurer configurer, String templateName, List<Map<String, Object>> listVars, HttpServletResponse response) {
        try (ServletOutputStream out = response.getOutputStream()) {
            generateAll(configurer, templateName, out, listVars);
            out.flush();
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}
