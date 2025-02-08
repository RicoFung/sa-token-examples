package com.domain.menu.controller;

import chok2.devwork.BaseRestController;
import chok2.devwork.pojo.ChokResponse;
import com.domain.menu.model.ModelMapper;
import com.domain.menu.model.param.AppMenuCreateParam;
import com.domain.menu.model.param.AppMenuModifyParam;
import com.domain.menu.model.param.AppMenuQueryListParam;
import com.domain.menu.model.param.AppMenuQueryOneParam;
import com.domain.menu.model.request.*;
import com.domain.menu.model.result.AppMenuResult;
import com.domain.menu.service.AppMenuService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.node.ArrayNode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "-AppMenu")
@RestController(value = "AppMenuController")
@RequestMapping("/api/menu")
public class AppMenuController extends BaseRestController
{
	// --------------------------------------------------------------------------------------- //
	// value: 指定请求的实际地址， 比如 /action/info之类
	// method： 指定请求的method类型， GET、POST、PUT、DELETE等
	// consumes： 指定处理请求的提交内容类型（Content-Type），例如application/json, text/html;
	// produces: 指定返回的内容类型，仅当request请求头中的(Accept)类型中包含该指定类型才返回
	// requests： 指定request中必须包含某些参数值是，才让该方法处理
	// headers： 指定request中必须包含某些指定的header值，才能让该方法处理请求
	// --------------------------------------------------------------------------------------- //

	@SuppressWarnings("unused")
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private AppMenuService service;

	@Operation(summary = "新增")
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ChokResponse<Object> create(@RequestBody @Validated AppMenuCreateRequest request)
	{
		AppMenuCreateParam param = ModelMapper.INSTANCE.requestToParam(request);
		return service.create(param);
	}

	@Operation(summary = "删除")
	@RequestMapping(value = "/remove", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ChokResponse<Object> remove(@RequestBody @Validated AppMenuRemoveRequest request)
	{
         return service.remove(request.getIdArray());
	}

	@Operation(summary = "修改")
	@RequestMapping(value = "/modify", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ChokResponse<Object> modify(@RequestBody @Validated AppMenuModifyRequest request)
	{
		AppMenuModifyParam param = ModelMapper.INSTANCE.requestToParam(request);
		return service.modify(param);
	}

	@Operation(summary = "明细")
	@RequestMapping(value = "/queryOne", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ChokResponse<AppMenuResult> queryOne(@RequestBody @Validated AppMenuQueryOneRequest request)
	{
		AppMenuQueryOneParam param = ModelMapper.INSTANCE.requestToParam(request);
		return service.queryOne(param);
	}

	@Operation(summary = "列表")
	@RequestMapping(value = "/queryList", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ChokResponse<ArrayNode> queryList(@RequestBody @Validated AppMenuQueryListRequest request) throws JsonProcessingException {
		AppMenuQueryListParam param = ModelMapper.INSTANCE.requestToParam(request);
		return service.queryList(param);
	}

	@Operation(summary = "路由列表")
	@RequestMapping(value = "/queryRoutes", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ChokResponse<ArrayNode> queryRoutes(@RequestBody @Validated AppMenuQueryListRequest request) throws JsonProcessingException {
		AppMenuQueryListParam param = ModelMapper.INSTANCE.requestToParam(request);
		return service.queryRoutes(param);
	}
}
