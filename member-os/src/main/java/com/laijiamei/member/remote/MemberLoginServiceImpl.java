package com.laijiamei.member.remote;

import com.alibaba.dubbo.config.annotation.Service;
import com.laijiamei.common.Result;
import com.laijiamei.member.common.FrontResult;
import com.laijiamei.member.dao.IFrontMemberDao;
import com.laijiamei.member.entity.Member;
import com.laijiamei.member.login.api.IMemberLoginService;
import com.laijiamei.member.login.dto.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author jiamei.lai（jiamei.lai@ucarinc.com）
 * @version 1.0
 * @description: 登录注册实现类
 * @date 16:38 2019/10/25
 */
@Component
@Service(interfaceClass = IMemberLoginService.class)
public class MemberLoginServiceImpl implements IMemberLoginService {

    @Autowired
    private IFrontMemberDao memberDao;

    @Override
    public Result<LoginRe> login(LoginDTO dto) {
        LoginRe loginRe = new LoginRe();
        Member member = memberDao.login(dto);
        if(member != null) {
            BeanUtils.copyProperties(member, loginRe);
            return FrontResult.success(loginRe, "登录成功！");
        } else {
            return FrontResult.fail("手机号密码错误！");
        }
    }

    @Override
    public Result register(RegisterDTO dto) {
        Member member = new Member();
        member.setPhone(dto.getPhone());
        member.setPassword(dto.getPassword());
        // 数据库表设计了phone-is_delete的唯一索引，如果手机号重复会出现异常
        try {
            memberDao.register(member);
            return FrontResult.success("注册成功！");
        } catch (Exception e) {
            return FrontResult.fail("该手机号已被注册！");
        }
    }

    @Override
    public Result findPasswordByPhone(FindPasswordDTO dto) {
        // todo: 给手机号发一个短信，返回一个验证码：messageCode
        String messageCode = "";
        if(!dto.getMessageCode().equals(messageCode)) {
            return FrontResult.fail("验证码错误！");
        } else {
            if(memberDao.findPasswordByPhone(dto) > 0) {
                return FrontResult.success("密码修改成功！");
            } else {
                return FrontResult.fail("该手机号未注册！");
            }
        }
    }

    @Override
    public Result updatePasswordById(UpdatePasswordDTO dto) {
        if(!dto.getNewPassword().equals(dto.getConfirmPassword())) {
            return FrontResult.fail("确认密码和新密码不一致！");
        } else {
            if(memberDao.updatePasswordById(dto) > 0) {
                return FrontResult.success("密码修改成功！");
            } else {
                return FrontResult.fail("原密码输入错误！");
            }
        }
    }

}
