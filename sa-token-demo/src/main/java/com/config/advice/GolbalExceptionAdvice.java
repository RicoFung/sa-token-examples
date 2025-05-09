package com.config.advice;

import cn.dev33.satoken.util.SaResult;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/*******************************************
 *
 * 只能拦截到Controller层的异常，且Controller自行try catch的话会无效
 * @author niko.fung
 *
 */
@RestControllerAdvice//(basePackages = {"com.api.v3.customtbdemo.controller"})
public class GolbalExceptionAdvice
{
	private final Logger log = LoggerFactory.getLogger(getClass());

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public SaResult defaultErrorHandler(HttpServletRequest req, Exception e)
	{
		log.error("{}", e);
		return SaResult.error(e.toString());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	public SaResult validationExceptions(MethodArgumentNotValidException e)
	{
		Map<String, String> errors = new HashMap<>();
		e.getBindingResult().getAllErrors().forEach((error) ->
		{
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		log.error("{}", errors.values().toString());
		return SaResult.error(errors.values().toString());
	}
}
