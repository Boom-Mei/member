package com.laijiamei.member.dao;

import com.laijiamei.member.entity.Member;
import com.laijiamei.member.login.dto.FindPasswordDTO;
import com.laijiamei.member.login.dto.LoginDTO;
import com.laijiamei.member.login.dto.UpdatePasswordDTO;
import org.springframework.stereotype.Repository;

/**
 * @author jiamei.lai（jiamei.lai@ucarinc.com）
 * @version 1.0
 * @description: 用户Dao
 * @date 11:18 2019/10/17
 */
@Repository
public interface IFrontMemberDao {

    /**
     * 根据id获得用户
     * @param id
     * @return
     */
    Member getMemberById(Long id);

    /**
     * 根据手机号密码登陆
     * @param dto
     * @return
     */
    Member login(LoginDTO dto);

    /**
     * 注册
     * @param member
     * @return
     */
    Integer register(Member member);

    /**
     * 根据手机号找回密码
     * @param dto
     * @return
     */
    Integer findPasswordByPhone(FindPasswordDTO dto);

    /**
     * 根据Id修改密码
     * @param dto
     * @return
     */
    Integer updatePasswordById(UpdatePasswordDTO dto);

}
