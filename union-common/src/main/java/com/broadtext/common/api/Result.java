package com.broadtext.common.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * 接口返回对象
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    /**
     * 业务异常
     */
    public static final String   DEFAULT_FAILED_CODE = "9998";
    /**
     * 系统性异常
     */
    public static final String DEFAULT_FAULT_CODE = "9999";

    /**
     * 异常
     */
    public static final String DEFAULT_EXCEPTION_CODE = "500";

    public static final String DEFAULT_FAILED_MSG = "系统异常";
    /**
     * 正常
     */
    public static final String DEFAULT_SUCCESS_CODE = "200";
    
    /**
     * 接口成功
     */
    public static final Boolean DEFAULT_SUCCESS_STATUS = Boolean.TRUE;
    
    /**
     * 登录异常token失效
     */
    public static final String TOKEN_IS_NULL_CODE = "10000";
    /**
     * 服务异常msg
     */
    public static final String DEFAULT_FAULT_MSG = "服务器异常";
    
    /**
     * 成功还是失败
     */
    private Boolean success;

    /**
     * 错误返回时的错误码
     */
    private String code;

    /**
     * 错误返回时的错误信息
     */
    private String msg;


    /**
     *  status为SC_OK时的JSON字符串
     */
    private T data;

    /**
     *  status为SC_OK时的JSON字符串
     */
    private T content;

    private Map<String,String> ext;

    /**
     * 构造函数(成功返回时使用)
     *
     * @param object 支持转换JSON格式的Java对象
     */
    public Result(T object) {
    	this.success=DEFAULT_SUCCESS_STATUS;
        this.code = DEFAULT_SUCCESS_CODE;
        this.msg = "";
        this.data = object;
    }
    /**
     * 构造函数(成功返回描述和数据时使用)
     *
     * @param object 支持转换JSON格式的Java对象
     */
    public Result(T object, String msg) {
    	this.success=DEFAULT_SUCCESS_STATUS;
        this.code = DEFAULT_SUCCESS_CODE;
        this.msg = msg;
        this.data = object;
    }
    /**
     * 构造函数(失败返回时使用)
     *
     * @param code
     * @param msg
     */
    public Result(String code, String msg) {
    	this.success=Boolean.FALSE;
        this.code = code;
        this.msg = msg;
        this.data = null;
    }

    /**
     * 构造函数(失败返回时使用)
     * @param code
     * @param msg
     * @param ext
     */
    public Result(String code, String msg,Map<String,String> ext) {
        this.success=Boolean.FALSE;
        this.code = code;
        this.msg = msg;
        this.ext = ext;
    }

    /**
     * 构造函数(失败返回时使用)
     * @param code
     * @param msg
     */
    public Result(T data,String code, String msg) {
        this.success=Boolean.FALSE;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> Result<T> ok() {
        return new Result<T>(null);
    }

    public static <T> Result<T> ok(T data) {
        return new Result<T>(data);
    }

    public static <T> Result<T> ok(T data, String msg) {
        return new Result<T>(data,msg);
    }

    public static <T> Result<T> failed(String msg) {

        return new Result<T>(DEFAULT_FAILED_CODE, msg);
    }

    public static <T> Result<T> okContent(T content) {
        Result<T> result = new Result<T>();
        result.setCode("0");
        result.setContent(content);
        return result;
    }


    public static <T> Result<T> failed(String code, String msg) {

        return new Result<T>(code, msg);
    }

    public static <T> Result<T> fault(String msg) {
        return new Result<T>(DEFAULT_FAULT_CODE, msg);
    }

    public static <T> Result<T> fault(String code, String msg) {
        return new Result<T>(code, msg);
    }

    public boolean isSuccess() {
        return DEFAULT_SUCCESS_CODE.equals(code);
    }

    @Override
    public String toString() {
        return "Result{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
