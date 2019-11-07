package com.laijiamei.member.login.api;

import com.laijiamei.common.Result;
import com.laijiamei.member.login.dto.*;

/**
 * @author jiamei.lai（jiamei.lai@ucarinc.com）
 * @version 1.0
 * @description: 用户登录注册相关
 * @date 10:11 2019/10/25
 */
public interface IMemberLoginService {

    /**
     * 登录
     * @param dto
     * @return
     */
    Result<LoginRe> login(LoginDTO dto);

    /**
     * 注册
     * @param dto
     * @return
     */
    Result register(RegisterDTO dto);

    /**
     * 根据电话号码找回密码
     * @param dto
     * @return
     */
    Result findPasswordByPhone(FindPasswordDTO dto);

    /**
     * 根据id修改密码
     * @param dto
     * @return
     */
    Result updatePasswordById(UpdatePasswordDTO dto);

}
