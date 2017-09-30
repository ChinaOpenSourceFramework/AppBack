package com.chinaopensource.apiserver.common.exception;

/**
 *  数据库不存在异常
 */
public class NoHasException extends BaseException{

	private static final long serialVersionUID = 1L;

	public NoHasException() {
	}
	
	public NoHasException(String message){
		super(message+"的值不存在");
	}
}
