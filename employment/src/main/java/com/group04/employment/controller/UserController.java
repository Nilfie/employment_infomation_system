package com.group04.employment.controller;


import com.group04.employment.common.CommonResult;
import com.group04.employment.document.DocUser;
import com.group04.employment.entity.User;
import com.group04.employment.service.UserService;
import com.group04.employment.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/employment/usermanage")
    public String index(){
        return "system/usermanage/usermanage";
    }

    @ResponseBody
    @RequestMapping("/employment/getallusers")
    public CommonResult<List<DocUser>> getAllUsers(@RequestParam("limit") int pageSize, @RequestParam("page") int pageNum) {
        List<DocUser> result = userService.getAllUsers(pageNum, pageSize);
        return CommonResult.generateSuccessResult(result.size(), result);
    }

    @ResponseBody
    @RequestMapping("/employment/getallusersBy")
    public CommonResult<List<DocUser>> getAllUsersBy(@ModelAttribute DocUser user, @RequestParam("limit") int pageSize, @RequestParam("page") int pageNum, HttpServletRequest request) throws IOException {
        List<DocUser> result = userService.selectAllUsersBy(user,pageNum, pageSize);
        return CommonResult.generateSuccessResult(result.size(), result);
    }

    @ResponseBody
    @RequestMapping("/employment/getuserbyaccount/{userAccount}")
    public CommonResult<DocUser> getUserByAccount(@PathVariable("userAccount") String userAccount) {
        return CommonResult.generateSuccessResult(1, userService.getUserByAccount(userAccount));
    }

    @ResponseBody
    @RequestMapping("/employment/adduser")
    public CommonResult<Integer> addUser(DocUser user) {
        user.setUserId(UUID.randomUUID().toString());
        user.setUserPwd(MD5Util.getMD5(user.getUserPwd()));
        userService.addUser(user);
        return CommonResult.generateSuccessResult(1, 1);
    }

    @ResponseBody
    @RequestMapping("/employment/updateuser")
    public CommonResult<Integer> updateUser(DocUser user) {
        userService.updateUser(user);
        return CommonResult.generateSuccessResult(1, 1);
    }

    @ResponseBody
    @RequestMapping("/employment/deluser/{userId}")
    public CommonResult<Integer> delInfo(@PathVariable("userId") String userId){
        userService.deleteUser(userId);
        return CommonResult.generateSuccessResult(1, 1);
    }

}
