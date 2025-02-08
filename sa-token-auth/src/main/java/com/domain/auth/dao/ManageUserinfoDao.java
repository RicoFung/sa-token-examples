package com.domain.auth.dao;


import chok2.devwork.dao.BaseDao;
import jakarta.annotation.Resource;
import org.apache.commons.collections.map.HashedMap;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository(value = "ManageUserinfoDao")
public class ManageUserinfoDao extends BaseDao
{
	@Resource(name = "sqlSessionTemplateMybatis")
	private SqlSession sqlSession;

	@Override
	protected SqlSession getSqlSession()
	{
		return sqlSession;
	}
	
	@Override
	protected String getSqlNamespace()
	{
		return getClass().getName();
	}

	public List<String> queryRoleList(String userid)
	{
		Map<String, String> param = new HashedMap();
		param.put("userid", userid);
		List<String> roleList = this.queryList("queryRoleList", param);
		return roleList;
	}
}
