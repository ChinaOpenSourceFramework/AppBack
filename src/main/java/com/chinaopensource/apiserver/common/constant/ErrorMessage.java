package com.chinaopensource.apiserver.common.constant;

import com.chinaopensource.apiserver.common.controller.BaseResponse;

/**
 * 定义错误信息
 */
public enum ErrorMessage {

	/**
	 * 0 表示成功，非0表示失败
	 */
	OK("成功",0),

	/**
	 * 错误信息
	 */
	ERR_SYS_LOGIN_PASSWORD("用户名或密码错误",1);

	private String message;
	private int code;

	private ErrorMessage(String message,int code) {
		this.message=message;
		this.code=code;
	}

	// 返回错误信息
    public static String getMessage(int code,Object... args) {
        for (ErrorMessage e : ErrorMessage.values()) {  
            if (e.getCode() == code) {  
                return String.format(e.message,args);
            }  
        }  
        return null;  
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

}
