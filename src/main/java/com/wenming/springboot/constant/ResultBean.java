package com.wenming.springboot.constant;

public class ResultBean {
	private boolean status = true;

	private int resultCode;

	private String message;

	private Object data;

	private ResultCode resCode;

	public ResultBean() {

	}

	public ResultBean(ResultCode resultCode) {
		resCode = resultCode;
		this.status = true;
	}

	public ResultBean(boolean status, ResultCode resultCode) {
		resCode = resultCode;
		this.status = status;
	}

	public ResultBean(Object data) {
		this.data = data;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getResultCode() {
		return resCode.getCode();
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public String getMessage() {
		return resCode.getMessage();
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
}
