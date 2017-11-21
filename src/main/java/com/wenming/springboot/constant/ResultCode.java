package com.wenming.springboot.constant;

public enum ResultCode {
	SUCCESS(200, "ok"), SYSTEM_ERROR(500, "系统异常,请联系管理员"), PARAMETER_ERROR(10101, "参数错误"),USERNAME_OR_PASSWORD_ERROR(10102,"用户名或密码错误");

	private int code;
	private String message;

	private ResultCode(int code, String message) {
		this.code = code;
		this.message = message;
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

}
