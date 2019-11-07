package com.laijiamei.member.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.laijiamei.member.common.BackResult;
import com.laijiamei.member.entity.Member;
import com.laijiamei.member.service.impl.IBackMemberServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jiamei.lai（jiamei.lai@ucarinc.com）
 * @version 1.0
 * @description: 用户Controller
 * @date 11:20 2019/10/17
 */
@RestController
@RequestMapping(value = "/backMember")
@Api("用户Controller")
public class BackMemberController {

    @Autowired
    private IBackMemberServiceImpl backMemberService;

    @RequestMapping(value = "/getBackMemberById", method = RequestMethod.GET)
    @ApiOperation("根据id获得用户")
    public BackResult getBacktMemberById(@RequestParam("id") Long id) {
        return BackResult.success(backMemberService.getBackMemberById(id));
    }

    @RequestMapping(value = "/backLogin", method = RequestMethod.POST)
    @ApiOperation("登陆")
    public BackResult backLogin(HttpServletRequest request,
                                HttpServletResponse response,
                                @RequestBody String jsonString) {
        JSONObject param = JSON.parseObject(jsonString);
        Member member = JSON.parseObject(String.valueOf(param.get("member")), Member.class);
        BackResult backResult = backMemberService.backLogin(member);
        if(backResult.isSuccess()) {
            request.getSession().setAttribute("backMember", member.getAccount());
            Cookie cookie = new Cookie("JSESSIONID", request.getSession().getId());
            cookie.setPath("/");
            response.addCookie(cookie);
        }
        return backResult;
    }

    @RequestMapping(value = "/backLogout", method = RequestMethod.GET)
    @ApiOperation("登出")
    public BackResult backLogout(HttpServletRequest request) {
        request.getSession().removeAttribute("backMember");
        Object o = request.getSession().getAttribute("backMember");
        if(null == o) {
            return BackResult.success("登出成功！");
        } else {
            return BackResult.fail("登出失败！");
        }
    }

    @RequestMapping(value = "/getBackMemberList", method = RequestMethod.GET)
    @ApiOperation("根据账号、手机号查询用户")
    public BackResult getBackMemberList(HttpServletRequest request,
                                        @RequestParam("account") String account,
                                        @RequestParam("phone") String phone) {
        return BackResult.success(backMemberService.getBackMemberList(account, phone));
    }

}
