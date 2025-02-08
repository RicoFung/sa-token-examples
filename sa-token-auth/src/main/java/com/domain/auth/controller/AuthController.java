package com.domain.auth.controller;

import chok2.devwork.pojo.ChokResponse;
import cn.dev33.satoken.stp.StpUtil;
import com.domain.auth.model.request.DoLoginRequest;
import com.domain.auth.service.ManageUserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/auth/")
public class AuthController
{
    @Autowired
    private ManageUserinfoService service;

    @RequestMapping("doLogin")
    public ChokResponse<Object> doLogin(@RequestBody @Validated DoLoginRequest request) throws UnsupportedEncodingException, NoSuchAlgorithmException
    {
        ChokResponse<Object> response = new ChokResponse<Object>();
        response = service.doLogin(request.getUsername(), request.getPassword());
        return response;
    }

    @RequestMapping("isLogin")
    public String isLogin() {
        return "当前会话是否登录：" + StpUtil.isLogin();
    }

    @RequestMapping("doLogout")
    public ChokResponse<Object> doLogout()
    {
        StpUtil.logout();
        return new ChokResponse<Object>();
    }

}

