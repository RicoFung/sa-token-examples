package com.domain.auth.service;

import chok2.devwork.pojo.ChokResponse;
import chok2.devwork.pojo.ChokResponseConstants;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.date.DateUtil;
import com.domain.auth.dao.ManageUserinfoDao;
import com.domain.auth.model.param.ManageUserinfoQueryOneParam;
import com.domain.auth.model.result.ManageUserinfoResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "ManageUserinfoService")
public class ManageUserinfoService
{
	@SuppressWarnings("unused")
	private final static Logger logger = LoggerFactory.getLogger(ManageUserinfoService.class);
	
	@Autowired
	private ManageUserinfoDao dao;

	public ChokResponse<Object> doLogin(String username, String password) throws UnsupportedEncodingException, NoSuchAlgorithmException
	{
		ChokResponse<Object> response = new ChokResponse<Object>();

		ManageUserinfoQueryOneParam param = new ManageUserinfoQueryOneParam();
		ManageUserinfoQueryOneParam.DynamicWhere where = new ManageUserinfoQueryOneParam.DynamicWhere();
		where.setCode(username);
		param.setDynamicWhere(where);
		param.setDynamicColumns(new String[] {"id", "code", "name", "password", "createtime"});

		ManageUserinfoResult user = dao.queryOne(param);
		if (!ObjectUtils.isEmpty(user))
		{
			String dbPassword = user.getPassword();
			String doPassword = encryptBASE64(getEncryptMD5Bytes(password + DateUtil.format(user.getCreatetime(), "yyyyMMdd")));
			logger.debug("【dbPassword】:{}, 【doPassword】:{}", dbPassword, doPassword);
			if (dbPassword.equals(doPassword))
			{
				// 1，先登录上
				StpUtil.login(user.getId());
				// 2，获取 Token  相关参数
				SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
				// 3， 获取 Role
				List<String> roleList = dao.queryRoleList(user.getId());
				String[] roleArray = roleList.toArray(String[]::new);
				// 4，返回给前端
				Map<String, Object> data = new HashMap<String, Object>();
				data.put("accessToken", tokenInfo.getTokenValue());
				data.put("refreshToken", tokenInfo.getTokenValue());
				tokenInfo.setTokenTimeout(10); // 手动修改 token 过期时间
				long expires = System.currentTimeMillis() + tokenInfo.getTokenTimeout() * 1000; // 前端时间戳单位用毫秒计算，所以需要 * 1000
				data.put("expires", expires);
				data.put("username", username);
				data.put("roles", roleArray);
				response.setData(data);
			}
			else
			{
				response.setSuccess(false);
				response.setCode(ChokResponseConstants.ERROR_CODE1);
				response.setMsg("密码错误！");
			}
		}
		else
		{
			response.setSuccess(false);
			response.setCode(ChokResponseConstants.ERROR_CODE1);
			response.setMsg("用户不存在！");
		}

		return response;
	}

	/**
	 * MD5加密
	 *
	 * @param input
	 * @return
	 */
	private byte[] getEncryptMD5Bytes(String input) throws UnsupportedEncodingException, NoSuchAlgorithmException
	{
		byte[] inputBytes = null;
		inputBytes = input.getBytes("UTF-8");

		MessageDigest messageDigest = null;
		messageDigest = MessageDigest.getInstance("MD5");

		messageDigest.update(inputBytes);
		return messageDigest.digest();
	}

	private String encryptBASE64(byte[] key)
	{
		return Base64.getEncoder().encodeToString(key);
	}
}
