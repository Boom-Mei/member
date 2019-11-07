package com.laijiamei.member.common;

import com.laijiamei.common.Result;

import java.io.Serializable;

/**
 * @author jiamei.lai（jiamei.lai@ucarinc.com）
 * @version 1.0
 * @description: 返回前端系统结果类
 * @date 17:08 2019/10/25
 */
public class FrontResult implements Serializable {

    private static final long serialVersionUID = 3292323646746830013L;

    public static <T> Result<T> success(String msg) {
        Result<T> result = new Result<T>();
        result.setMsg(msg);
        result.setCode("200");
        return result;
    }

    public static <T> Result<T> success(T re) {
        Result<T> result = new Result<T>();
        result.setRe(re);
        result.setMsg("操作成功");
        result.setCode("200");
        return result;
    }

    public static <T> Result<T> success(T re, String msg) {
        Result<T> result = new Result<T>();
        result.setRe(re);
        result.setMsg(msg);
        result.setCode("200");
        return result;
    }

    public static <T> Result<T> success(T re, String msg, String code) {
        Result<T> result = new Result<T>();
        result.setRe(re);
        result.setMsg(msg);
        result.setCode(code);
        return result;
    }

    public static <T> Result<T> fail() {
        Result<T> result = new Result<T>();
        result.setMsg("操作失败");
        result.setCode("900");
        return result;
    }

    public static <T> Result<T> fail(String msg) {
        Result<T> result = new Result<T>();
        result.setMsg(msg);
        result.setCode("900");
        return result;
    }

    public static <T> Result<T> fail(String msg, String code) {
        Result<T> result = new Result<T>();
        result.setMsg(msg);
        result.setCode(code);
        return result;
    }

}
