package com.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig
{
	@Bean
	public OpenAPI openAPI()
	{
		return new OpenAPI()
				.info(new Info()
						.title("EPO-POS-STORE API")
						.description("EPO-POS-STORE API 演示")
						.version("v1.0.0")
						.license(new License().name("Apache 2.0").url("http://springdoc.org"))
				)
				.components(new Components()
						// 定义一个名叫 "sa-token" 的 SecurityScheme
						.addSecuritySchemes("sa-token",
								new io.swagger.v3.oas.models.security.SecurityScheme()
										.type(SecurityScheme.Type.APIKEY)
										.in(SecurityScheme.In.HEADER)
										.name("satoken")
						)
				)
				// 全局生效：所有接口默认都需要这个安全方案
				.addSecurityItem(new SecurityRequirement().addList("sa-token"));
	}
}
