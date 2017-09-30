package com.chinaopensource.apiserver.common.exception;

/**
 * 数据库存在异常
 */
public class HasException extends BaseException{

	private static final long serialVersionUID = 1L;

	public HasException() {
		super();
	}
	
	public HasException(String message) {
        super(message+"的值已经存在");
    }
}
