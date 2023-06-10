package com.group04.employment.controller;


import com.group04.employment.common.CommonResult;
import com.group04.employment.document.EmploymentInfo;
import com.group04.employment.service.ChartService;
import com.group04.employment.service.EmploymentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;
import java.util.Map;


@Controller
public class EmploymentStatisticController {
    @Autowired
    EmploymentInfoService employmentInfoService;

    @Autowired
    private ChartService chartService;

    @RequestMapping("/employment/statistic")
    public String index(Model model) {
        getInfos(model, chartService);
        return "system/employmentstatistic/employmentstatistic";
    }

    static void getInfos(Model model, ChartService chartService) {
        List<EmploymentInfo> groupByMajor = chartService.listGroupByMajor();
        List<EmploymentInfo> list2 = chartService.list2();
        List<EmploymentInfo> groupByClass = chartService.listGroupByClass();
        List<EmploymentInfo> groupByStation = chartService.listGroupByStation();
        List<EmploymentInfo> groupByCompany = chartService.listGroupByCompany();

        model.addAttribute("groupByMajor", groupByMajor);
        model.addAttribute("groupByClass", groupByClass);
        model.addAttribute("groupByStation", groupByStation);
        model.addAttribute("groupByCompany", groupByCompany);
        model.addAttribute("totals", list2);
    }

    @ResponseBody
    @RequestMapping("/employment/statistic/{fieldName}")
    public CommonResult<List<Map<String, Long>>> getStatisticData(
            @PathVariable("fieldName") String fieldName,
            @RequestParam("limit") int pageSize,
            @RequestParam("page") int pageNum) throws IOException {

        List<Map<String, Object>> statisticResult = employmentInfoService.getStudentCount(fieldName, pageNum, pageSize);
        return CommonResult.generateSuccessResult(statisticResult.size(), statisticResult);
    }

}
