package com.domain.auth.controller;

import chok2.devwork.pojo.ChokResponse;
import chok2.devwork.pojo.ChokResponseConstants;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.domain.auth.model.request.DoLoginRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth/")
public class AuthController {

    @RequestMapping("doLogin")
    public ChokResponse<Object> doLogin(@RequestBody @Validated DoLoginRequest request) {
        ChokResponse<Object> response = new ChokResponse<Object>();
        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
        if("niko".equals(request.getUsername()) && "a12345678".equals(request.getPassword())) {
            // 第1步，先登录上
            StpUtil.login(10001);
            // 第2步，获取 Token  相关参数
            SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
            // 第3步，返回给前端
            Map<String, Object> data = new HashMap<String, Object>();
            data.put("accessToken", tokenInfo.getTokenValue());
            data.put("refreshToken", tokenInfo.getTokenValue());
            data.put("expires", tokenInfo.getTokenTimeout());
            data.put("username", request.getUsername());
            data.put("roles", "admin");
            response.setData(data);
            return response;
        }
        response.setSuccess(false);
        response.setCode(ChokResponseConstants.ERROR_CODE1);
        response.setMsg("用户名或密码不正确！");
        return response;
    }

    @RequestMapping("isLogin")
    public String isLogin() {
        return "当前会话是否登录：" + StpUtil.isLogin();
    }

}

