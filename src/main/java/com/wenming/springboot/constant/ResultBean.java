package com.wenming.springboot.constant;

public class ResultBean {
	private boolean status = true;

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


	public String getMessage() {
		return resCode.getMessage();
	}


	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
