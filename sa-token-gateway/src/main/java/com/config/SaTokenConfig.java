package com.config;

import chok2.devwork.pojo.ChokResponse;
import chok2.devwork.pojo.ChokResponseConstants;
import cn.dev33.satoken.reactor.context.SaReactorSyncHolder;
import cn.dev33.satoken.reactor.filter.SaReactorFilter;
import cn.dev33.satoken.stp.StpUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ServerWebExchange;


@Configuration(proxyBeanMethods = false)
public class SaTokenConfig {

    private final static ObjectMapper objectMapper = new ObjectMapper();

    @Bean
    public SaReactorFilter saReactorFilter() {
        return new SaReactorFilter()
                // 拦截所有请求
                .addInclude("/**")
                // 不拦截的路径（如登录接口）
                .addExclude("/auth/**")
                .setAuth(obj -> {
                    // 登录校验
                    StpUtil.checkLogin();
                })
                // setAuth方法异常处理
                .setError(e -> {
                    // 设置错误返回格式为JSON
                    ServerWebExchange exchange = SaReactorSyncHolder.getContext();
                    exchange.getResponse().getHeaders().set("Content-Type", "application/json; charset=utf-8");
                    ChokResponse<Object> response = new ChokResponse<Object>();
                    response.setSuccess(false);
                    response.setCode(ChokResponseConstants.ERROR_CODE1);
                    response.setMsg(e.getMessage());
                    try {
                        return objectMapper.writeValueAsString(response);
                    } catch (JsonProcessingException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                ;
    }

}