package com.domain.menu.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

@Schema(description = "AppMenuModifyRequest 修改入参")
public class AppMenuModifyRequest implements Serializable
{
	private static final long serialVersionUID = 1L;

	// 主键       db_column: ID 
	@Schema(title = "主键", example = "")
	@NotNull(message = "主键必传！")
	@NotBlank(message = "主键不能为空！")
	private String id;
	
    // 路由路径       db_column: PATH 
    @Schema(title = "路由路径", example = "")
	//	@NotNull(message = "path(路由路径)必传！")
	private String path;
    // 路由名称（必须唯一并且和当前路由component字段对应的页面里用defineOptions包起来的name保持一致）       db_column: NAME 
    @Schema(title = "路由名称（必须唯一并且和当前路由component字段对应的页面里用defineOptions包起来的name保持一致）", example = "")
	//	@NotNull(message = "name(路由名称（必须唯一并且和当前路由component字段对应的页面里用defineOptions包起来的name保持一致）)必传！")
	private String name;
    // 路由重定向       db_column: REDIRECT 
    @Schema(title = "路由重定向", example = "")
	//	@NotNull(message = "redirect(路由重定向)必传！")
	private String redirect;
    // 按需加载需要展示的页面       db_column: COMPONENT 
    @Schema(title = "按需加载需要展示的页面", example = "")
	//	@NotNull(message = "component(按需加载需要展示的页面)必传！")
	private String component;
    // 菜单名称（兼容国际化、非国际化，如果用国际化的写法就必须在根目录的locales文件夹下对应添加）       db_column: METATITLE 
    @Schema(title = "菜单名称（兼容国际化、非国际化，如果用国际化的写法就必须在根目录的locales文件夹下对应添加）", example = "")
	//	@NotNull(message = "metatitle(菜单名称（兼容国际化、非国际化，如果用国际化的写法就必须在根目录的locales文件夹下对应添加）)必传！")
	private String metatitle;
    // 菜单图标       db_column: METAICON 
    @Schema(title = "菜单图标", example = "")
	//	@NotNull(message = "metaicon(菜单图标)必传！")
	private String metaicon;
    // 菜单名称右侧的额外图标       db_column: METAEXTRAICON 
    @Schema(title = "菜单名称右侧的额外图标", example = "")
	//	@NotNull(message = "metaextraicon(菜单名称右侧的额外图标)必传！")
	private String metaextraicon;
    // 是否显示该菜单       db_column: METASHOWLINK 
    @Schema(title = "是否显示该菜单", example = "")
	//	@NotNull(message = "metashowlink(是否显示该菜单)必传！")
	private Boolean metashowlink;
    // 是否显示父级菜单       db_column: METASHOWPARENT 
    @Schema(title = "是否显示父级菜单", example = "")
	//	@NotNull(message = "metashowparent(是否显示父级菜单)必传！")
	private Boolean metashowparent;
    // 页面级别权限设置       db_column: METAROLES 
    @Schema(title = "页面级别权限设置", example = "")
	//	@NotNull(message = "metaroles(页面级别权限设置)必传！")
	private String metaroles;
    // 按钮级别权限设置       db_column: METAAUTHS 
    @Schema(title = "按钮级别权限设置", example = "")
	//	@NotNull(message = "metaauths(按钮级别权限设置)必传！")
	private String metaauths;
    // 是否缓存该路由页面（开启后，会保存该页面的整体状态，刷新后会清空状态）       db_column: METAKEEPALIVE 
    @Schema(title = "是否缓存该路由页面（开启后，会保存该页面的整体状态，刷新后会清空状态）", example = "")
	//	@NotNull(message = "metakeepalive(是否缓存该路由页面（开启后，会保存该页面的整体状态，刷新后会清空状态）)必传！")
	private Boolean metakeepalive;
    // 需要内嵌的iframe链接地址       db_column: METAFRAMESRC 
    @Schema(title = "需要内嵌的iframe链接地址", example = "")
	//	@NotNull(message = "metaframesrc(需要内嵌的iframe链接地址)必传！")
	private String metaframesrc;
    // 内嵌的iframe页面是否开启首次加载动画       db_column: METAFRAMELOADING 
    @Schema(title = "内嵌的iframe页面是否开启首次加载动画", example = "")
	//	@NotNull(message = "metaframeloading(内嵌的iframe页面是否开启首次加载动画)必传！")
	private Boolean metaframeloading;
    // 当前页面动画，这里是第一种模式，比如 name: "fade" 更具体看后面链接 https://cn.vuejs.org/api/built-in-components.html#transition       db_column: TRANSITIONNAME 
    @Schema(title = "当前页面动画", example = "")
	//	@NotNull(message = "transitionname(当前页面动画，这里是第一种模式，比如 name: "fade" 更具体看后面链接 https://cn.vuejs.org/api/built-in-components.html#transition)必传！")
	private String transitionname;
    // 当前页面进场动画，这里是第二种模式，比如 enterTransition: "animate__fadeInLeft"       db_column: TRANSITIONENTER 
    @Schema(title = "当前页面进场动画", example = "")
	//	@NotNull(message = "transitionenter(当前页面进场动画，这里是第二种模式，比如 enterTransition: "animate__fadeInLeft")必传！")
	private String transitionenter;
    // 当前页面离场动画，这里是第二种模式，比如 leaveTransition: "animate__fadeOutRight"       db_column: TRANSITIONLEAVE 
    @Schema(title = "当前页面离场动画", example = "")
	//	@NotNull(message = "transitionleave(当前页面离场动画，这里是第二种模式，比如 leaveTransition: "animate__fadeOutRight")必传！")
	private String transitionleave;
    // 当前菜单名称或自定义信息禁止添加到标签页       db_column: HIDDENTAG 
    @Schema(title = "当前菜单名称或自定义信息禁止添加到标签页", example = "")
	//	@NotNull(message = "hiddentag(当前菜单名称或自定义信息禁止添加到标签页)必传！")
	private Boolean hiddentag;
    // 显示在标签页的最大数量，需满足后面的条件：不显示在菜单中的路由并且是通过query或params传参模式打开的页面。在完整版全局搜dynamicLevel即可查看代码演示       db_column: DYNAMICLEVEL 
    @Schema(title = "显示在标签页的最大数量，需满足后面的条件：不显示在菜单中的路由并且是通过query或params传参模式打开的页面。在完整版全局搜dynamicLevel即可查看代码演示", example = "")
	//	@NotNull(message = "dynamiclevel(显示在标签页的最大数量，需满足后面的条件：不显示在菜单中的路由并且是通过query或params传参模式打开的页面。在完整版全局搜dynamicLevel即可查看代码演示)必传！")
	private Integer dynamiclevel;
    // 将某个菜单激活（主要用于通过query或params传参的路由，当它们通过配置showLink: false后不在菜单中显示，就不会有任何菜单高亮，而通过设置activePath指定激活菜单即可获得高亮，activePath为指定激活菜单的path）       db_column: ACTIVEPATH 
    @Schema(title = "将某个菜单激活（主要用于通过query或params传参的路由，当它们通过配置showLink: false后不在菜单中显示，就不会有任何菜单高亮，而通过设置activePath指定激活菜单即可获得高亮，activePath为指定激活菜单的path）", example = "")
	//	@NotNull(message = "activepath(将某个菜单激活（主要用于通过query或params传参的路由，当它们通过配置showLink: false后不在菜单中显示，就不会有任何菜单高亮，而通过设置activePath指定激活菜单即可获得高亮，activePath为指定激活菜单的path）)必传！")
	private String activepath;
    // 父级主键       db_column: PID 
    @Schema(title = "父级主键", example = "")
	//	@NotNull(message = "pid(父级主键)必传！")
	private Long pid;

	public String getId() 
	{
		return this.id;
	}
	public void setId(String value) 
	{
		this.id = value;
	}
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
}

