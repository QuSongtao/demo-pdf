/*
 * 版权所有 © 成都太阳高科技有限责任公司
 * http://www.suncd.com
 */
package com.suncd.demopdf.controller;

import com.suncd.demopdf.Utils.PdfUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 功能：XXXX
 *
 * @author qust
 * @version 1.0 2018/2/23 9:35
 */
@Controller
@RequestMapping(value = "/pdf")
public class PdfController {
    @Autowired
    private FreeMarkerConfigurer configurer;

    @RequestMapping(value = "/hello")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("pdfIndex");
//        modelAndView.setViewName("com\\suncd\\demopdf\\template\\pdfIndex");
        modelAndView.addObject("title", "cgx1113");
        return modelAndView;
    }

    @RequestMapping(value = "/preview", method = RequestMethod.GET)
    public void preview(HttpServletRequest request, HttpServletResponse response) {
        List<Map<String,Object>> listVars = new ArrayList<>();
        Map<String,Object> variables = new HashMap<>();
        variables.put("title","hello hcgx sos啊!");
        listVars.add(variables);
        PdfUtils.preview(configurer,"pdfIndex.ftl",listVars,response);
    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public void download(HttpServletRequest request, HttpServletResponse response) {
        List<Map<String,Object>> listVars = new ArrayList<>();
        Map<String,Object> variables = new HashMap<>();
        variables.put("title","hcgxsos啊!");
        listVars.add(variables);
        PdfUtils.download(configurer,"pdfIndex.ftl",listVars,response,"测试中文.pdf");
    }
}
