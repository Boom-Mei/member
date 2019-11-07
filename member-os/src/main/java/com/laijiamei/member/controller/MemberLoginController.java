package com.laijiamei.member.controller;

import com.laijiamei.common.Result;
import com.laijiamei.member.login.dto.*;
import com.laijiamei.member.remote.MemberLoginServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author jiamei.lai（jiamei.lai@ucarinc.com）
 * @version 1.0
 * @description: 登陆注册测试
 * @date 9:33 2019/10/26
 */
@RestController
@RequestMapping(value = "/memberLogin")
@Api("登陆注册测试路径")
public class MemberLoginController {

    @Autowired
    private MemberLoginServiceImpl memberLoginService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ApiOperation("登陆")
    public Result<LoginRe> login(@RequestParam("phone") String phone, @RequestParam("password") String password) {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setPhone(phone);
        loginDTO.setPassword(password);
        return memberLoginService.login(loginDTO);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ApiOperation("注册")
    public Result register(@RequestBody RegisterDTO registerDTO) {
        return memberLoginService.register(registerDTO);
    }

    @RequestMapping(value = "/findPsd", method = RequestMethod.POST)
    @ApiOperation("找回密码")
    public Result findPasswordByPhone(@RequestBody FindPasswordDTO findPasswordDTO) {
        return memberLoginService.findPasswordByPhone(findPasswordDTO);
    }

    @RequestMapping(value = "/updatePsd", method = RequestMethod.POST)
    @ApiOperation("修改密码")
    public Result updatePasswordById(@RequestBody UpdatePasswordDTO updatePasswordDTO) {
        return memberLoginService.updatePasswordById(updatePasswordDTO);
    }

}
