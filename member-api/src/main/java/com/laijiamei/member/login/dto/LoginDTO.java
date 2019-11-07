package com.laijiamei.member.login.dto;

import java.io.Serializable;

/**
 * @author jiamei.lai（jiamei.lai@ucarinc.com）
 * @version 1.0
 * @description: 登录dto
 * @date 10:16 2019/10/25
 */
public class LoginDTO implements Serializable {

    private static final long serialVersionUID = 6552767044273913670L;

    private String phone;

    private String password;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginDTO{" +
                "phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
