package com.wenming.springboot.constant;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@ExceptionHandler(value = Exception.class)
	public ResultBean defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
		logger.error(e.getMessage());
		return new ResultBean(ResultCode.SYSTEM_ERROR);
	}

}
