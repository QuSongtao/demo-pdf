/*
 * 版权所有 © 成都太阳高科技有限责任公司
 * http://www.suncd.com
 */
package com.suncd.demopdf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

/**
 * 功能：XXXX
 *
 * @author qust
 * @version 1.0 2018/2/23 9:44
 */
@RestController
@RequestMapping("/pdf")
public class PdfCreateController {
    /*@Autowired
    @Qualifier("fkConfig")
    private Configuration configuration;*/
    @Autowired
    private FreeMarkerConfigurer configurer;

    @RequestMapping(value = "/c",method = RequestMethod.GET)
    public String cPdf(){
        /*try{

            String outputFile = "d:\\sample.pdf";
            Map<String,Object> variables = new HashMap<>();
            variables.put("title","hello cgx啊!");
            String htmlStr = "";//PdfUtils.generateDoc(configurer,"pdfIndex.ftl", variables);
            OutputStream out = new FileOutputStream(outputFile);
            PdfUtils.generate(htmlStr, out);
            out.flush();
            out.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }*/
        return "cgx";
    }

}
