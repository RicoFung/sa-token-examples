package com.domain.menu.model.param;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class AppMenuQueryListParam implements Serializable
{
	private static final long serialVersionUID = 1L;

	// ********************************************************************************************
	// 1.默认参数
	// ********************************************************************************************

	private String[] dynamicColumns;
	
	private List<Map<String, Object>> dynamicOrder;
	
	private DynamicWhere dynamicWhere;

	private Integer page;

	private Integer pagesize;

	// ********************************************************************************************
	// 2.表单参数
	// ********************************************************************************************
	
	public static class DynamicWhere implements Serializable
	{
		private static final long serialVersionUID = 1L;
		
	    // 路由路径       db_column: PATH 
		private String path;
	    // 路由名称（必须唯一并且和当前路由component字段对应的页面里用defineOptions包起来的name保持一致）       db_column: NAME 
		private String name;
	    // 路由重定向       db_column: REDIRECT 
		private String redirect;
	    // 按需加载需要展示的页面       db_column: COMPONENT 
		private String component;
	    // 菜单名称（兼容国际化、非国际化，如果用国际化的写法就必须在根目录的locales文件夹下对应添加）       db_column: METATITLE 
		private String metatitle;
	    // 菜单图标       db_column: METAICON 
		private String metaicon;
	    // 菜单名称右侧的额外图标       db_column: METAEXTRAICON 
		private String metaextraicon;
	    // 是否显示该菜单       db_column: METASHOWLINK 
		private Boolean metashowlink;
	    // 是否显示父级菜单       db_column: METASHOWPARENT 
		private Boolean metashowparent;
	    // 页面级别权限设置       db_column: METAROLES 
		private String metaroles;
	    // 按钮级别权限设置       db_column: METAAUTHS 
		private String metaauths;
	    // 是否缓存该路由页面（开启后，会保存该页面的整体状态，刷新后会清空状态）       db_column: METAKEEPALIVE 
		private Boolean metakeepalive;
	    // 需要内嵌的iframe链接地址       db_column: METAFRAMESRC 
		private String metaframesrc;
	    // 内嵌的iframe页面是否开启首次加载动画       db_column: METAFRAMELOADING 
		private Boolean metaframeloading;
	    // 当前页面动画，这里是第一种模式，比如 name: "fade" 更具体看后面链接 https://cn.vuejs.org/api/built-in-components.html#transition       db_column: TRANSITIONNAME 
		private String transitionname;
	    // 当前页面进场动画，这里是第二种模式，比如 enterTransition: "animate__fadeInLeft"       db_column: TRANSITIONENTER 
		private String transitionenter;
	    // 当前页面离场动画，这里是第二种模式，比如 leaveTransition: "animate__fadeOutRight"       db_column: TRANSITIONLEAVE 
		private String transitionleave;
	    // 当前菜单名称或自定义信息禁止添加到标签页       db_column: HIDDENTAG 
		private Boolean hiddentag;
	    // 显示在标签页的最大数量，需满足后面的条件：不显示在菜单中的路由并且是通过query或params传参模式打开的页面。在完整版全局搜dynamicLevel即可查看代码演示       db_column: DYNAMICLEVEL 
		private Integer dynamiclevel;
	    // 将某个菜单激活（主要用于通过query或params传参的路由，当它们通过配置showLink: false后不在菜单中显示，就不会有任何菜单高亮，而通过设置activePath指定激活菜单即可获得高亮，activePath为指定激活菜单的path）       db_column: ACTIVEPATH 
		private String activepath;
	    // 父级主键       db_column: PID 
		private Long pid;
		
		// 主键       db_column: ID 
		private String[] idArray;
		
		public String getPath() 
		{
			return this.path;
		}
		public void setPath(String value) 
		{
			this.path = value;
		}
		public String getName() 
		{
			return this.name;
		}
		public void setName(String value) 
		{
			this.name = value;
		}
		public String getRedirect() 
		{
			return this.redirect;
		}
		public void setRedirect(String value) 
		{
			this.redirect = value;
		}
		public String getComponent() 
		{
			return this.component;
		}
		public void setComponent(String value) 
		{
			this.component = value;
		}
		public String getMetatitle() 
		{
			return this.metatitle;
		}
		public void setMetatitle(String value) 
		{
			this.metatitle = value;
		}
		public String getMetaicon() 
		{
			return this.metaicon;
		}
		public void setMetaicon(String value) 
		{
			this.metaicon = value;
		}
		public String getMetaextraicon() 
		{
			return this.metaextraicon;
		}
		public void setMetaextraicon(String value) 
		{
			this.metaextraicon = value;
		}
		public Boolean getMetashowlink() 
		{
			return this.metashowlink;
		}
		public void setMetashowlink(Boolean value) 
		{
			this.metashowlink = value;
		}
		public Boolean getMetashowparent() 
		{
			return this.metashowparent;
		}
		public void setMetashowparent(Boolean value) 
		{
			this.metashowparent = value;
		}
		public String getMetaroles()
		{
			return this.metaroles;
		}
		public void setMetaroles(String value)
		{
			this.metaroles = value;
		}
		public String getMetaauths()
		{
			return this.metaauths;
		}
		public void setMetaauths(String value)
		{
			this.metaauths = value;
		}
		public Boolean getMetakeepalive() 
		{
			return this.metakeepalive;
		}
		public void setMetakeepalive(Boolean value) 
		{
			this.metakeepalive = value;
		}
		public String getMetaframesrc() 
		{
			return this.metaframesrc;
		}
		public void setMetaframesrc(String value) 
		{
			this.metaframesrc = value;
		}
		public Boolean getMetaframeloading() 
		{
			return this.metaframeloading;
		}
		public void setMetaframeloading(Boolean value) 
		{
			this.metaframeloading = value;
		}
		public String getTransitionname() 
		{
			return this.transitionname;
		}
		public void setTransitionname(String value) 
		{
			this.transitionname = value;
		}
		public String getTransitionenter() 
		{
			return this.transitionenter;
		}
		public void setTransitionenter(String value) 
		{
			this.transitionenter = value;
		}
		public String getTransitionleave() 
		{
			return this.transitionleave;
		}
		public void setTransitionleave(String value) 
		{
			this.transitionleave = value;
		}
		public Boolean getHiddentag() 
		{
			return this.hiddentag;
		}
		public void setHiddentag(Boolean value) 
		{
			this.hiddentag = value;
		}
		public Integer getDynamiclevel() 
		{
			return this.dynamiclevel;
		}
		public void setDynamiclevel(Integer value) 
		{
			this.dynamiclevel = value;
		}
		public String getActivepath() 
		{
			return this.activepath;
		}
		public void setActivepath(String value) 
		{
			this.activepath = value;
		}
		public Long getPid() 
		{
			return this.pid;
		}
		public void setPid(Long value) 
		{
			this.pid = value;
		}
	
		public String[] getIdArray() 
		{
			return this.idArray;
		}
		public void setIdArray(String[] value) 
		{
			this.idArray = value;
		}

		@Override
		public String toString()
		{
			return "DynamicWhere [" + 
					"path=" + path
					+ ", name=" + name
					+ ", redirect=" + redirect
					+ ", component=" + component
					+ ", metatitle=" + metatitle
					+ ", metaicon=" + metaicon
					+ ", metaextraicon=" + metaextraicon
					+ ", metashowlink=" + metashowlink
					+ ", metashowparent=" + metashowparent
					+ ", metaroles=" + metaroles
					+ ", metaauths=" + metaauths
					+ ", metakeepalive=" + metakeepalive
					+ ", metaframesrc=" + metaframesrc
					+ ", metaframeloading=" + metaframeloading
					+ ", transitionname=" + transitionname
					+ ", transitionenter=" + transitionenter
					+ ", transitionleave=" + transitionleave
					+ ", hiddentag=" + hiddentag
					+ ", dynamiclevel=" + dynamiclevel
					+ ", activepath=" + activepath
					+ ", pid=" + pid
					+ ", idArray=" + Arrays.toString(idArray)
					+ "]";
		}
	}
	
	public String[] getDynamicColumns()
	{
		return dynamicColumns;
	}
	
	public void setDynamicColumns(String[] dynamicColumns)
	{
		this.dynamicColumns = dynamicColumns;
	}
	
	public List<Map<String, Object>> getDynamicOrder()
	{
		return dynamicOrder;
	}
	
	public void setDynamicOrder(List<Map<String, Object>> dynamicOrder)
	{
		this.dynamicOrder = dynamicOrder;
	}
	
	public DynamicWhere getDynamicWhere()
	{
		return dynamicWhere;
	}

	public void setDynamicWhere(DynamicWhere dynamicWhere)
	{
		this.dynamicWhere = dynamicWhere;
	}
	
	public Integer getPage()
	{
		return page;
	}

	public void setPage(Integer page)
	{
		this.page = page;
	}

	public Integer getPagesize()
	{
		return pagesize;
	}

	public void setPagesize(Integer pagesize)
	{
		this.pagesize = pagesize;
	}

	@Override
	public String toString()
	{
		return "AppMenuQueryListParam [dynamicColumns=" + Arrays.toString(dynamicColumns) + ", dynamicOrder="
				+ dynamicOrder + ", dynamicWhere=" + dynamicWhere.toString() + ", page=" + page + ", pagesize=" + pagesize + "]";
	}
}
