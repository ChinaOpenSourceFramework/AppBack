package com.chinaopensource.apiserver.common.exception;

/**
 * 自定义异常的基类，所以定义的异常都必须继承
 */
public class BaseException extends Exception{

	private static final long serialVersionUID = 1L;

	public BaseException() {
		super();
	}
	
	public BaseException(String message) {
		 super(message);
	}

}
