package com.domain.menu.service;

import chok2.devwork.pojo.ChokResponse;
import com.domain.menu.dao.AppMenuDao;
import com.domain.menu.model.entity.AppMenu;
import com.domain.menu.model.param.AppMenuQueryListParam;
import com.domain.menu.model.param.AppMenuQueryOneParam;
import com.domain.menu.model.result.AppMenuResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//@CacheConfig(cacheNames = {"CACHE_AppMenu"})
@Service(value = "AppMenuService")
public class AppMenuService
{
	@SuppressWarnings("unused")
	private final static Logger logger = LoggerFactory.getLogger(AppMenuService.class);

	private final static ObjectMapper objMapper = new ObjectMapper();
	
	@Autowired
	private AppMenuDao dao;

//	@Caching(evict = { @CacheEvict(allEntries = true) })
	public ChokResponse<Object> create(AppMenu entity)
	{
		dao.create(entity);
		return new ChokResponse<Object>();
	}

//	@Caching(evict = { @CacheEvict(allEntries = true) })
	public ChokResponse<Object> remove(String[] ids)
	{
		dao.remove(ids);
		return new ChokResponse<Object>();
	}

//	@Caching(evict = { @CacheEvict(value = {"CACHE_AppMenu"}, allEntries = true) })
	public ChokResponse<Object> modify(AppMenu entity)
	{
		dao.modify(entity);
		return new ChokResponse<Object>();
	}	

//	@Cacheable(key = "#param")
	public ChokResponse<AppMenuResult> queryOne(AppMenuQueryOneParam param) 
	{
		AppMenuResult result = dao.queryOne(param);
		return new ChokResponse<AppMenuResult>(result);
	}

	public ChokResponse<ArrayNode> queryList(AppMenuQueryListParam param) throws JsonProcessingException {
		List<AppMenuResult> result = dao.queryList(param);
		List<ObjectNode> menuTableList = new ArrayList<ObjectNode>();
		menuTableList = this.convertToTableList(result);
		ArrayNode menuArrayNode = buildMenu(menuTableList, 0l);
		return new ChokResponse<ArrayNode>(menuArrayNode);
	}

//	@Cacheable(key = "#param")
	public ChokResponse<ArrayNode> queryRoutes(AppMenuQueryListParam param) throws JsonProcessingException {
		List<AppMenuResult> result = dao.queryList(param);
		List<ObjectNode> menuNodeList = new ArrayList<ObjectNode>();
		menuNodeList = this.convertToNodeList(result);
		ArrayNode menuArrayNode = buildMenu(menuNodeList, 0l);
		return new ChokResponse<ArrayNode>(menuArrayNode);
	}

	private ArrayNode buildMenu(List<ObjectNode> menuNodeList, Long pid) throws JsonProcessingException
	{
		ArrayNode menuArrayNode = objMapper.createArrayNode();

		if (menuNodeList == null || menuNodeList.size() == 0 || pid < 0)
			return null;

		for(ObjectNode menuNode : menuNodeList)
		{
			Long parentId = Long.valueOf(menuNode.get("parentId").toString());

			if (parentId.equals(pid))
			{
				menuArrayNode.addPOJO(menuNode);

				Long menuId = Long.valueOf(menuNode.get("id").toString());

				ArrayNode children = buildMenu(menuNodeList, menuId);
				if (children.size() > 0)
				{  // Only add "children" if it's non-empty
					menuNode.set("children", children);
				}
			}
		}
		return menuArrayNode;
	}

	private List<ObjectNode> convertToNodeList(List<AppMenuResult> menuList)
	{
		List<ObjectNode> menuNodeList = menuList.stream().map(menu ->
		{
			// init node
			ObjectNode menuNode = objMapper.createObjectNode();
			menuNode.put("id", menu.getId());
			menuNode.put("parentId", menu.getPid());
			menuNode.put("path", menu.getPath());
			menuNode.put("name", menu.getName());
			if (!ObjectUtils.isEmpty(menu.getComponent()))
			{
				menuNode.put("component", menu.getComponent());
			}
			// meta
			ObjectNode metaNode = objMapper.createObjectNode();
			metaNode.put("icon", menu.getMetaicon());
			metaNode.put("title", menu.getMetatitle());

			ArrayNode metarolesNode = objMapper.createArrayNode();
			String[] metaroles = menu.getMetaroles().split(",");
			for (String metarole : metaroles)
			{
				metarolesNode.add(metarole);  // 将每个字符串添加到 ArrayNode
			}
			metaNode.set("roles", metarolesNode);

			ArrayNode metaauthsNode = objMapper.createArrayNode();
			String[] metaauths = menu.getMetaauths().split(",");
			for (String metaauth : metaauths)
			{
				metaauthsNode.add(metaauth);  // 将每个字符串添加到 ArrayNode
			}
			metaNode.set("auths", metaauthsNode);

			menuNode.putPOJO("meta", metaNode);
			return menuNode;
		}).collect(Collectors.toList());
		return menuNodeList;
	}

	private List<ObjectNode> convertToTableList(List<AppMenuResult> menuList)
	{
		List<ObjectNode> menuNodeList = menuList.stream().map(menu ->
		{
			// init node
			ObjectNode menuNode = objMapper.createObjectNode();
			menuNode.put("id", menu.getId());
			menuNode.put("parentId", menu.getPid());
			menuNode.put("path", menu.getPath());
			menuNode.put("name", menu.getName());
			menuNode.put("component", menu.getComponent());

			// meta
			menuNode.put("metaicon", menu.getMetaicon());
			menuNode.put("metatitle", menu.getMetatitle());
			menuNode.put("metaroles", menu.getMetaroles());
			menuNode.put("metaauths", menu.getMetaauths());

			return menuNode;
		}).collect(Collectors.toList());
		return menuNodeList;
	}
}
