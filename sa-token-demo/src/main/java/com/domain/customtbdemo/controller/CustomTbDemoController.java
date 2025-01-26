package com.domain.customtbdemo.controller;

import java.util.List;

import cn.dev33.satoken.annotation.SaCheckLogin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.domain.customtbdemo.dto.CustomDto;
import com.domain.customtbdemo.model.data.CustomTbDemoGetListData;
import com.domain.customtbdemo.model.param.CustomTbDemoGetListParam;
import com.domain.customtbdemo.model.param.ParamMapper;
import com.domain.customtbdemo.model.query.CustomTbDemoGetListQuery;
import com.domain.customtbdemo.service.CustomTbDemoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "v3_1-CustomTbDemo")
@RestController(value = "v3_1CustomTbDemoController")
@RequestMapping("/api/v3_1/customtbdemo")
public class CustomTbDemoController
{

	// ---------------------------------------------------------------------------------------
	// //
	// value: 指定请求的实际地址， 比如 /action/info之类
	// method： 指定请求的method类型， GET、POST、PUT、DELETE等
	// consumes： 指定处理请求的提交内容类型（Content-Type），例如application/json, text/html;
	// produces: 指定返回的内容类型，仅当request请求头中的(Accept)类型中包含该指定类型才返回
	// params： 指定request中必须包含某些参数值是，才让该方法处理
	// headers： 指定request中必须包含某些指定的header值，才能让该方法处理请求
	// ---------------------------------------------------------------------------------------
	// //

	@SuppressWarnings("unused")
	private final Logger log = LoggerFactory.getLogger(getClass());	

	@Autowired
	private CustomTbDemoService service;

	@Operation(summary = "列表")
	@SaCheckLogin
	@RequestMapping(value = "/getList", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public CustomDto<List<CustomTbDemoGetListData>> getList(@RequestBody @Validated CustomTbDemoGetListParam param, BindingResult br)
	{
		CustomTbDemoGetListQuery query = ParamMapper.INSTANCE.paramToQuery(param);
		return service.getList(query);
	}

}
