package com.study.gs4.exceptions;

/**
 * @Description: TODO(描述类的作用)
 * @author xiewm
 * @date 2017年11月30日 下午2:57:07
 * 
 */

public class StorageException extends RuntimeException {

	public StorageException(String message) {
		super(message);
	}

	public StorageException(String message, Throwable cause) {
		super(message, cause);
	}
}
