package com.laijiamei.member.service;

import com.laijiamei.member.common.BackResult;
import com.laijiamei.member.entity.Member;
import com.laijiamei.member.entity.vo.MemberSearchResult;

import java.util.List;

/**
 * @author jiamei.lai（jiamei.lai@ucarinc.com）
 * @version 1.0
 * @description: 用户Service
 * @date 11:19 2019/10/17
 */
public interface IBackMemberService {

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    Member getBackMemberById(Long id);

    /**
     * 根据账号密码登陆
     * @param member
     * @return
     */
    BackResult backLogin(Member member);

    /**
     * 通过账号或者密码查询用户
     * @param account
     * @param phone
     * @return
     */
    List<MemberSearchResult> getBackMemberList(String account, String phone);

}
