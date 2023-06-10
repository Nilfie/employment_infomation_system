package com.group04.employment.controller;


import com.group04.employment.common.CommonResult;
import com.group04.employment.entity.Recruit;
import com.group04.employment.service.RecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;
import java.util.UUID;
/**
 * @author Nilfie
 * @version 1.0
 * @date 2023/5/8 14:28
 */

@Controller
@RequestMapping("/recruit")
public class RecruitInfoController {

    @Autowired
    RecruitService recruitService;

    @RequestMapping({"/", "/index", "/recruitInfo"})
    public String index() {
        return "system/recruit/recruitInfo";
    }

//    /rUsermanage

    @RequestMapping("/updateRUser")
    public String userManage() {
        return "system/recruit/updateRUser";
    }

    @ResponseBody
    @RequestMapping("/getAllRecruit")
    public CommonResult<List<Recruit>> getAllInfo() {
        List<Recruit> infoList = recruitService.getAllRecruit(0, 1);
        System.out.println(infoList.toString());
        CommonResult<List<Recruit>> rtInfoResult = CommonResult.generateSuccessResult(infoList.size(), infoList);
        return rtInfoResult;
    }

//    @ResponseBody
//    @RequestMapping("/getinfo/{q}")
//    public CommonResult<List<EmploymentInfo>> getinfo(@PathVariable("q") String q, @RequestParam("limit") int pageSize, @RequestParam("page") int pageNum) throws IOException {
//        List<EmploymentInfo> infoList = employmentInfoService.getEmploymentInfo(q, pageNum, pageSize);
//        CommonResult<List<EmploymentInfo>> rtInfoResult = CommonResult.generateSuccessResult(infoList.size(), infoList);
//        return rtInfoResult;
//    }

    @ResponseBody
    @RequestMapping("/addRecruit")
    public CommonResult<Integer> addInfo(Recruit info) {
        info.setRecruitId(UUID.randomUUID().toString());
        recruitService.addRecruitInfo(info);
        return CommonResult.generateSuccessResult(1, 1);
    }

    @ResponseBody
    @RequestMapping("/updateRecruit")
    public CommonResult<Integer> updateInfo(Recruit info) {
        recruitService.updateRecruitInfo(info);
        return CommonResult.generateSuccessResult(1, 1);
    }

    @ResponseBody
    @RequestMapping("/delRecruit/{recruitId}")
    public CommonResult<Integer> delInfo(@PathVariable("infoId") String infoId) {
        recruitService.deleteRecruitInfo(infoId);
        return CommonResult.generateSuccessResult(1, 1);
    }

}
