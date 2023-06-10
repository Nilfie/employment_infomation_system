package com.group04.employment.controller;

import com.group04.employment.common.CommonResult;
import com.group04.employment.entity.User;
import com.group04.employment.service.UserService;
import com.group04.employment.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    UserService userService;


    @RequestMapping({"/", "/employment"})
    public String index() {
        return "system/login";
    }

    //    logout(HttpServletRequest request, HttpServletResponse response)

    @RequestMapping("/employment/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        userService.logout(request, response);
        return "system/login";
    }

    @RequestMapping("/403")
    public String accessDenied() {

        return "system/403";
    }

}
