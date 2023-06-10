package com.group04.employment.controller;


import com.group04.employment.common.CommonResult;
import com.group04.employment.document.EmploymentInfo;
import com.group04.employment.service.EmploymentInfoService;
import org.apache.tomcat.jni.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class EmploymentInfoController {
    @Autowired
    EmploymentInfoService employmentInfoService;

    @RequestMapping({"/employment/index", "/employment/employmentinfo"})
    public String index(){
        return "system/employmentinfo/employmentinfo";
    }

    @ResponseBody
    @RequestMapping("/employment/getallinfo")
    public CommonResult<List<EmploymentInfo>> getAllInfo(@RequestParam("limit") int pageSize, @RequestParam("page") int pageNum){
        List<EmploymentInfo> infoList = employmentInfoService.getAllEmploymentInfo(pageNum, pageSize);
        CommonResult<List<EmploymentInfo>> rtInfoResult = CommonResult.generateSuccessResult(infoList.size(), infoList);
        return rtInfoResult;
    }

    @ResponseBody
    @RequestMapping("/employment/getinfo/{q}")
    public CommonResult<List<EmploymentInfo>> getinfo(@PathVariable("q") String q, @RequestParam("limit") int pageSize, @RequestParam("page") int pageNum) throws IOException {
        List<EmploymentInfo> infoList = employmentInfoService.getEmploymentInfo(q, pageNum, pageSize);
        CommonResult<List<EmploymentInfo>> rtInfoResult = CommonResult.generateSuccessResult(infoList.size(), infoList);
        return rtInfoResult;
    }

    @ResponseBody
    @RequestMapping("/employment/addinfo")
    public CommonResult<Integer> addInfo(EmploymentInfo info){
        info.setInformationId(UUID.randomUUID().toString());
        employmentInfoService.addEmploymentInfo(info);
        return CommonResult.generateSuccessResult(1, 1);
    }

    @ResponseBody
    @RequestMapping("/employment/updateinfo")
    public CommonResult<Integer> updateInfo(EmploymentInfo info){
        employmentInfoService.updateEmploymentInfo(info);
        return CommonResult.generateSuccessResult(1, 1);
    }

    @ResponseBody
    @RequestMapping("/employment/delinfo/{infoId}")
    public CommonResult<Integer> delInfo(@PathVariable("infoId") String infoId){
        employmentInfoService.deleteEmploymentInfo(infoId);
        return CommonResult.generateSuccessResult(1, 1);
    }

}
