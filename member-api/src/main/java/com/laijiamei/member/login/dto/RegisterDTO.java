package com.laijiamei.member.login.dto;

import java.io.Serializable;

/**
 * @author jiamei.lai（jiamei.lai@ucarinc.com）
 * @version 1.0
 * @description: 注册
 * @date 11:21 2019/10/25
 */
public class RegisterDTO implements Serializable {

    private static final long serialVersionUID = 6762885377439780543L;

    private String phone;

    private String password;

    private String messageCode;

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

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    @Override
    public String toString() {
        return "RegisterDTO{" +
                "phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", password='" + messageCode + '\'' +
                '}';
    }

}
