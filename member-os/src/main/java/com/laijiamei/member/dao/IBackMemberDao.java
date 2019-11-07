package com.laijiamei.member.dao;

import com.laijiamei.member.entity.Member;
import com.laijiamei.member.entity.vo.MemberSearchResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jiamei.lai（jiamei.lai@ucarinc.com）
 * @version 1.0
 * @description: 后端用户Dao
 * @date 8:55 2019/10/29
 */
@Repository
public interface IBackMemberDao {

    /**
     * 根据id获得后台用户
     * @param id
     * @return
     */
    Member getBackMemberById(Long id);

    /**
     * 登陆
     * @param account
     * @param password
     * @return
     */
    Member backLogin(@Param("account") String account, @Param("password") String password);

    /**
     * 通过账号或者密码查询用户
     * @param account
     * @param phone
     * @return
     */
    List<MemberSearchResult> getBackMemberList(@Param("account") String account, @Param("phone") String phone);

}
