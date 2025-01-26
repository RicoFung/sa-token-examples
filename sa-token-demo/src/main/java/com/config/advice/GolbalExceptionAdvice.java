package com.config.advice;

import java.util.HashMap;
import java.util.Map;


import chok2.devwork.pojo.ChokResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import chok2.devwork.pojo.ChokResponseConstants;

/*******************************************
 * 
 * 只能拦截到Controller层的异常，且Controller自行try catch的话会无效
 * @author rico.fung
 *
 */
@RestControllerAdvice//(basePackages = {"com.api.v3.customtbdemo.controller"})
public class GolbalExceptionAdvice
{
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public ChokResponse<Object> defaultErrorHandler(HttpServletRequest req, Exception e)
	{
		ChokResponse<Object> dto = new ChokResponse<Object>();
		dto.setSuccess(false);
		dto.setCode(ChokResponseConstants.ERROR_CODE1);
		dto.setMsg(e.toString());
		log.error("{}", e);
		return dto;
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	public ChokResponse<Object> validationExceptions(MethodArgumentNotValidException e)
	{
		Map<String, String> errors = new HashMap<>();
		e.getBindingResult().getAllErrors().forEach((error) ->
		{
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		ChokResponse<Object> dto = new ChokResponse<Object>();
		dto.setSuccess(false);
		dto.setCode(ChokResponseConstants.ERROR_CODE1);
		dto.setMsg(errors.values().toString());
		log.error("{}", errors.values().toString());
		return dto;
	}
}
