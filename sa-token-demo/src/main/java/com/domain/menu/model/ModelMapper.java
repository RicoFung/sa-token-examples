package com.domain.menu.model;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.domain.menu.model.param.AppMenuCreateParam;
import com.domain.menu.model.param.AppMenuModifyParam;
import com.domain.menu.model.param.AppMenuQueryListParam;
import com.domain.menu.model.param.AppMenuQueryOneParam;
import com.domain.menu.model.request.AppMenuCreateRequest;
import com.domain.menu.model.request.AppMenuModifyRequest;
import com.domain.menu.model.request.AppMenuQueryListRequest;
import com.domain.menu.model.request.AppMenuQueryOneRequest;

@Mapper
public interface ModelMapper
{
	ModelMapper INSTANCE = Mappers.getMapper( ModelMapper.class );
	
	@Mapping(target = "id", ignore = true)
	AppMenuCreateParam requestToParam(AppMenuCreateRequest request);
	
	AppMenuModifyParam requestToParam(AppMenuModifyRequest request);
	
	AppMenuQueryOneParam requestToParam(AppMenuQueryOneRequest request);
	
	AppMenuQueryListParam requestToParam(AppMenuQueryListRequest request);
	
}
