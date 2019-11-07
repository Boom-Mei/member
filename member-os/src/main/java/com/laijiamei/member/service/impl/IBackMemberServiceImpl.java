package com.laijiamei.member.service.impl;

import com.github.pagehelper.PageHelper;
import com.laijiamei.member.common.BackResult;
import com.laijiamei.member.dao.IBackMemberDao;
import com.laijiamei.member.entity.Member;
import com.laijiamei.member.entity.vo.MemberSearchResult;
import com.laijiamei.member.service.IBackMemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jiamei.lai（jiamei.lai@ucarinc.com）
 * @version 1.0
 * @description: 用户ServiceImpl
 * @date 11:19 2019/10/17
 */
@Service
public class IBackMemberServiceImpl implements IBackMemberService {

    private static final Logger logger = LoggerFactory.getLogger(IBackMemberServiceImpl.class);

    @Autowired
    private IBackMemberDao backMemberDao;

    @Override
    public Member getBackMemberById(Long id) {
        logger.info("调用getMemberById方法，id：{}", id);
        // 使用PageHelper.startPager实现对下一语句的分页
        PageHelper.startPage(1, 1);
        return backMemberDao.getBackMemberById(id);
    }

    /**
     * 用redis做缓存来查询
     * @param
     * @return
     */
//    @Override
//    @Cacheable(value = "member", key = "#id")
//    public Member getMemberById(Long id) {
//        logger.info("调用getMemberById方法，id：{}", id);
//        return IMemberDao.getMemberById(id);
//    }

    @Override
    public BackResult backLogin(Member member) {
        logger.info("调用login方法，account：{}，password：{}", member.getAccount(), member.getPassword());
        if(backMemberDao.backLogin(member.getAccount(), member.getPassword()) == null) {
            return BackResult.fail("账号密码错误！");
        } else {
            // todo: 返回增加token
            return BackResult.success("登陆成功！");
        }
    }

    @Override
    public List<MemberSearchResult> getBackMemberList(String account, String phone) {
        logger.info("调用getMemberById方法，account：{}, phone: {}", account, phone);
        return backMemberDao.getBackMemberList(account, phone);
    }

}
