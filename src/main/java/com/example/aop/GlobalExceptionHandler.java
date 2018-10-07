package com.example.aop;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;


@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(value=Exception.class)//配置所有异常处理
	public ModelAndView defaultExceptionHandler(Exception e,HttpServletResponse response) {
		Map map=new HashMap();
		int code=response.getStatus();
		map.put("code", code);
		map.put("msg",e.getMessage());
		return new ModelAndView("error",map);
	}

}
