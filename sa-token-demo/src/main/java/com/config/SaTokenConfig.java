package com.config;

import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.filter.SaServletFilter;
import cn.dev33.satoken.same.SaSameUtil;
import cn.dev33.satoken.util.SaResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Sa-Token 权限认证 配置类
 */
@Configuration
public class SaTokenConfig
{
    private final Logger log = LoggerFactory.getLogger(getClass());

    // 注册 Sa-Token 全局过滤器
    @Bean
    public SaServletFilter getSaServletFilter()
    {
        return new SaServletFilter()
                .addInclude("/**")
                .addExclude("/favicon.ico",
                        "/v3/api-docs/**",
                        "/swagger-ui.html",
                        "/swagger-ui/**",
                        "/swagger-resources/**",
                        "/webjars/**",
                        "/doc.html")   // 如果你用的是 Knife4j 或者自定义 doc.html
                .setAuth(obj ->
                {
                    // 校验 Same-Token 身份凭证     —— 以下两句代码可简化为：SaSameUtil.checkCurrentRequestToken();
                    String token = SaHolder.getRequest().getHeader(SaSameUtil.SAME_TOKEN);
                    SaSameUtil.checkToken(token);
                })
                .setError(e ->
                {
                    log.error("<== {}", e.getMessage());
                    return SaResult.error(e.getMessage());
                })
                ;
    }
}

