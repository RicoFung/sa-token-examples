package com.domain.menu.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

@Schema(description = "AppMenuRemoveRequest 删除入参")
public class AppMenuRemoveRequest implements Serializable
{
	private static final long serialVersionUID = 1L;

	@NotNull(message = "主键Array必传！")
    @Size(min = 1, message = "最少选一条记录！")
	private String[] idArray;

	public String[] getIdArray() 
	{
		return this.idArray;
	}
	public void setIdArray(String[] value) 
	{
		this.idArray = value;
	}
}

