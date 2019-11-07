package com.laijiamei.member.entity;

import java.io.Serializable;

/**
 * @author jiamei.lai（jiamei.lai@ucarinc.com）
 * @version 1.0
 * @description: 前端用户实体类
 * @date 11:21 2019/10/17
 */
public class Member implements Serializable {

    private static final long serialVersionUID = -2184293589447402434L;

    private Long id;

    private String name;

    private String account;

    private String password;

    private String phone;

    /**
     * 性别，0男，1女
     */
    private Integer sex;

    private String email;

    private String imgUrl;

    private Long createEmp;

    private String createTime;

    private Long modifyEmp;

    private String modifyTime;

    private String remark;

    /**
     * 是否被删除，0未被删除，1已删除
     */
    private Integer isDelete;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Long getCreateEmp() {
        return createEmp;
    }

    public void setCreateEmp(Long createEmp) {
        this.createEmp = createEmp;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Long getModifyEmp() {
        return modifyEmp;
    }

    public void setModifyEmp(Long modifyEmp) {
        this.modifyEmp = modifyEmp;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", sex=" + sex +
                ", email='" + email + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", creatEmp=" + createEmp +
                ", creatTime='" + createTime + '\'' +
                ", modifyEmp=" + modifyEmp +
                ", modifyTime='" + modifyTime + '\'' +
                ", remark='" + remark + '\'' +
                ", remake='" + isDelete + '\'' +
                '}';
    }

}
