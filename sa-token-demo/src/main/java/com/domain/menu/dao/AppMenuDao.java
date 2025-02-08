package com.domain.menu.dao;

import chok2.devwork.dao.BaseDao;
import jakarta.annotation.Resource;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository(value = "AppMenuDao")
public class AppMenuDao extends BaseDao
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
}
