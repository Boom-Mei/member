package com.laijiamei.member.common;

import org.springframework.util.StringUtils;

import java.io.Serializable;

/**
 * @author jiamei.lai（jiamei.lai@ucarinc.com）
 * @version 1.0
 * @description: 返回后台系统结果类
 * @date 17:45 2019/10/17
 */
public class BackResult implements Serializable {

    private static final long serialVersionUID = 3010680817045258889L;

    public static final String DEFAULT_ERROR_MESSAGE = "系统操作过程中出现错误,请重试！";

    private static final String EXCEPTION_FLAG = "Exception";

    private boolean success;

    private String message;

    private Object data;

    public static BackResult success() {
        return success(null);
    }

    public static BackResult success(String message) {
        return new BackResult(true, message, null);
    }

    public static BackResult success(Object data) {
        return new BackResult(true, null, data);
    }

    public static BackResult success(String message, Object data) {
        return new BackResult(true, message, data);
    }

    public static BackResult fail() {
        return fail("操作失败请重试！");
    }

    public static BackResult fail(String message) {
        if (StringUtils.isEmpty(message) || message.indexOf(EXCEPTION_FLAG) > 0) {
            message = DEFAULT_ERROR_MESSAGE;
        }
        return new BackResult(false, message, null);
    }

    public BackResult(boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }

}
