package com.chinaopensource.apiserver.common.controller;

import com.alibaba.fastjson.JSON;
import com.chinaopensource.apiserver.common.constant.ErrorMessage;

/**
 * 返回json数据的基本格式
 */
public class BaseResponse {

	// 返回错误码
	private int code;
	// 返回错误信息
	private String message;
	// 返回数据
	private Object data;


	private BaseResponse() {
	}

	private BaseResponse(int code ) {
		this.code=code;
	}

	private BaseResponse(int code , String message) {
		this.code=code;
		this.message=message;
	}

	public BaseResponse(int code, String message, Object data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}

	//转换成json
	public String toJson(){
		return JSON.toJSONString(this);
	}

	//返回正确的json结果，有数据
	public static String getSuccessJson(Object data){
		return new BaseResponse(0,"成功",data).toJson();
	}
	//返回正确的json结果，无数据
	public static String getSuccessJson(){
		return getSuccessJson(null);
	}

	//返回错误的json结果
	public static String getErrorJson(int code,Object... args) {
		for (ErrorMessage e : ErrorMessage.values()) {
			if (e.getCode() == code) {
				return  new BaseResponse(code,String.format(e.getMessage(),args)).toJson();
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "BaseResponse{" +
				"code=" + code +
				", message='" + message + '\'' +
				", data=" + data +
				'}';
	}
}
