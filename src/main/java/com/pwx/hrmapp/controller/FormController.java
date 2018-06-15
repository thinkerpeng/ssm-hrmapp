package com.pwx.hrmapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 动态页面跳转控制器
 * Created by peng on 2018/6/10.
 */
@Controller
public class FormController extends HrmController {

    @RequestMapping(value = "/{formName}")
    public String loginForm(@PathVariable String formName, HttpServletRequest request){
        // 动态跳转页面
        LOGGER.info("formName: {}", formName);
        return formName;
    }
}
