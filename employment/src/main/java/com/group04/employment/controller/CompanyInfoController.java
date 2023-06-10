package com.group04.employment.controller;

import com.group04.employment.document.EmploymentInfo;
import com.group04.employment.entity.CompanyInfo;
import com.group04.employment.service.CompanyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * @author Nilfie
 * @version 1.0
 * @date 2023/6/6 21:29
 */
@Controller
public class CompanyInfoController {
    @Autowired
    private CompanyInfoService companyInfoService;

    @RequestMapping("employment/studentchart")
    public String test(Model model) {
//        List<Map<CompanyInfo, EmploymentInfo>> infoList = companyInfoService.selectAll();
//        model.addAttribute("infoList", infoList);
        return "system/studentchart/studentinfochart";
    }

}
