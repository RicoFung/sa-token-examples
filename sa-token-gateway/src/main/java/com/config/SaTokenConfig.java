package com.config;

import cn.dev33.satoken.reactor.filter.SaReactorFilter;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration(proxyBeanMethods = false)
public class SaTokenConfig
{
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Bean
    public SaReactorFilter saReactorFilter()
    {
        return new SaReactorFilter()
                // 拦截所有请求
                .addInclude("/**")
                // 不拦截的路径（如登录接口）
                .addExclude(
                        "/auth/**",                 // 登录/注销接口
                        "/swagger-ui.html",         // Swagger UI 页面
                        "/swagger-ui/**",           // UI 静态资源
                        "/v3/api-docs/**",          // OpenAPI JSON/YAML
                        "/webjars/**"               // webjars 资源（如果有的话）
                )
                .setAuth(obj ->
                {
                    // 登录校验
                    StpUtil.checkLogin();
                })
                // setAuth方法异常处理
                .setError(e ->
                {
                    log.error("<== {}", e.getMessage());
                    return SaResult.error(e.getMessage());
                })
                ;
    }

}