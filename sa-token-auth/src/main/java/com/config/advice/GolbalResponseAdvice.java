package com.config.advice;

import cn.dev33.satoken.util.SaResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/*******************************************
 *
 * 只能拦截到Controller层的异常，且Controller自行try catch的话会无效
 *
 * @author rico.fung
 *
 */
@RestControllerAdvice//(basePackages = { "com.api.v3.tbdemo.controller" })
public class GolbalResponseAdvice implements ResponseBodyAdvice<Object>
{
	@Override
	public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass)
	{
		// 1. 先排除 /v3/api-docs 所有请求
		ServletRequestAttributes attrs =
				(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		if (attrs != null) {
			HttpServletRequest req = attrs.getRequest();
			String path = req.getRequestURI();
			if (path.startsWith("/v3/api-docs")) {
				return false;
			}
		}
		// 2. 再排除已经是 SaResult 的方法
		// response 是 SaResult 类型，或者注释了NotControllerResponseAdvice都不进行包装
		return !methodParameter.getParameterType().isAssignableFrom(SaResult.class);
	}

	@Override
	public Object beforeBodyWrite(Object data, MethodParameter returnType, MediaType mediaType,
								  Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest request, ServerHttpResponse response)
	{
		// String类型不能直接包装
		if (returnType.getGenericParameterType().equals(String.class))
		{
			ObjectMapper objectMapper = new ObjectMapper();
			try
			{
				// 将数据包装在 SaResult 里后转换为json串进行返回
				return objectMapper.writeValueAsString(SaResult.data(data));
			}
			catch (JsonProcessingException e)
			{
				throw new RuntimeException(e.getMessage());
			}
		}
		// 否则直接包装成 SaResult 返回
		return SaResult.data(data);
	}
}
