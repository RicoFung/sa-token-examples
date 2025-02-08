package com.domain.auth.model.entity;

import java.io.Serializable;
/**
 *
 * @author rico
 * @version 1.0
 * @since 1.0
 * */
public class ManageUserinfo implements Serializable
{
	private static final long serialVersionUID = 1l;

	// 主键       db_column: ID 
	private String id;

    // 显示名称       db_column: DISPLAYNAME 
	private String displayname;
    // 组织ID       db_column: CHANNELID 
	private Long channelid;
    // 停用人       db_column: DISABLEBY 
	private String disableby;
    // 修改人       db_column: MODIFYBY 
	private String modifyby;
    // 禁用原因       db_column: DISABLEREASON 
	private String disablereason;
    // 修改时间       db_column: MODIFYTIME 
	private java.util.Date modifytime;
    // 商店ID       db_column: SHOPID 
	private Long shopid;
    // 名称       db_column: NAME 
	private String name;
    // 用户角色       db_column: USERROLE 
	private String userrole;
    // 代码       db_column: CODE 
	private String code;
    // 停用日期       db_column: DISABLEDATE 
	private java.util.Date disabledate;
    // 状态       db_column: STATUS 
	private String status;
    // 使用者语言       db_column: USERLANGUAGE 
	private String userlanguage;
    // 创建渠道       db_column: CREATECHANNELID 
	private Long createchannelid;
    // 创建人       db_column: CREATEBY 
	private String createby;
    // 密码       db_column: PASSWORD 
	private String password;
    // 启用日期       db_column: ENABLEDATE 
	private java.util.Date enabledate;
    // 创建时间       db_column: CREATETIME 
	private java.util.Date createtime;
    // 启用人       db_column: ENABLEBY 
	private String enableby;
    // 备注       db_column: REMARK 
	private String remark;
    // 类型       db_column: TYPE 
	private String type;
    // 商店代码       db_column: SHOPCODE 
	private String shopcode;
    // 员工代码       db_column: STAFFCODE 
	private String staffcode;
    // 供应商id       db_column: SUPPLIERID 
	private Long supplierid;
    // 供应商编码       db_column: SUPPLIERCODE 
	private String suppliercode;
    // 供应商名称       db_column: SUPPLIERNAME 
	private String suppliername;
    // 操作类型 1-登入 2-登出       db_column: USERTYPE 
	private String usertype;
    // loginfailurecount       db_column: LOGINFAILURECOUNT 
	private Long loginfailurecount;
    // 密码有效期       db_column: PASSWORDEXPIREDATE 
	private java.util.Date passwordexpiredate;

	public String getId() 
	{
		return this.id;
	}
	public void setId(String value) 
	{
		this.id = value;
	}
	public String getDisplayname()
	{
		return this.displayname;
	}
	public void setDisplayname(String value)
	{
		this.displayname = value;
	}
	public Long getChannelid()
	{
		return this.channelid;
	}
	public void setChannelid(Long value)
	{
		this.channelid = value;
	}
	public String getDisableby()
	{
		return this.disableby;
	}
	public void setDisableby(String value)
	{
		this.disableby = value;
	}
	public String getModifyby()
	{
		return this.modifyby;
	}
	public void setModifyby(String value)
	{
		this.modifyby = value;
	}
	public String getDisablereason()
	{
		return this.disablereason;
	}
	public void setDisablereason(String value)
	{
		this.disablereason = value;
	}
	public java.util.Date getModifytime() 
	{
		return this.modifytime;
	}
	public void setModifytime(java.util.Date value) 
	{
		this.modifytime = value;
	}
	public Long getShopid()
	{
		return this.shopid;
	}
	public void setShopid(Long value)
	{
		this.shopid = value;
	}
	public String getName()
	{
		return this.name;
	}
	public void setName(String value)
	{
		this.name = value;
	}
	public String getUserrole()
	{
		return this.userrole;
	}
	public void setUserrole(String value)
	{
		this.userrole = value;
	}
	public String getCode()
	{
		return this.code;
	}
	public void setCode(String value)
	{
		this.code = value;
	}
	public java.util.Date getDisabledate() 
	{
		return this.disabledate;
	}
	public void setDisabledate(java.util.Date value) 
	{
		this.disabledate = value;
	}
	public String getStatus()
	{
		return this.status;
	}
	public void setStatus(String value)
	{
		this.status = value;
	}
	public String getUserlanguage()
	{
		return this.userlanguage;
	}
	public void setUserlanguage(String value)
	{
		this.userlanguage = value;
	}
	public Long getCreatechannelid()
	{
		return this.createchannelid;
	}
	public void setCreatechannelid(Long value)
	{
		this.createchannelid = value;
	}
	public String getCreateby()
	{
		return this.createby;
	}
	public void setCreateby(String value)
	{
		this.createby = value;
	}
	public String getPassword()
	{
		return this.password;
	}
	public void setPassword(String value)
	{
		this.password = value;
	}
	public java.util.Date getEnabledate() 
	{
		return this.enabledate;
	}
	public void setEnabledate(java.util.Date value) 
	{
		this.enabledate = value;
	}
	public java.util.Date getCreatetime() 
	{
		return this.createtime;
	}
	public void setCreatetime(java.util.Date value) 
	{
		this.createtime = value;
	}
	public String getEnableby()
	{
		return this.enableby;
	}
	public void setEnableby(String value)
	{
		this.enableby = value;
	}
	public String getRemark()
	{
		return this.remark;
	}
	public void setRemark(String value)
	{
		this.remark = value;
	}
	public String getType()
	{
		return this.type;
	}
	public void setType(String value)
	{
		this.type = value;
	}
	public String getShopcode()
	{
		return this.shopcode;
	}
	public void setShopcode(String value)
	{
		this.shopcode = value;
	}
	public String getStaffcode()
	{
		return this.staffcode;
	}
	public void setStaffcode(String value)
	{
		this.staffcode = value;
	}
	public Long getSupplierid()
	{
		return this.supplierid;
	}
	public void setSupplierid(Long value)
	{
		this.supplierid = value;
	}
	public String getSuppliercode()
	{
		return this.suppliercode;
	}
	public void setSuppliercode(String value)
	{
		this.suppliercode = value;
	}
	public String getSuppliername()
	{
		return this.suppliername;
	}
	public void setSuppliername(String value)
	{
		this.suppliername = value;
	}
	public String getUsertype()
	{
		return this.usertype;
	}
	public void setUsertype(String value)
	{
		this.usertype = value;
	}
	public Long getLoginfailurecount()
	{
		return this.loginfailurecount;
	}
	public void setLoginfailurecount(Long value)
	{
		this.loginfailurecount = value;
	}
	public java.util.Date getPasswordexpiredate() 
	{
		return this.passwordexpiredate;
	}
	public void setPasswordexpiredate(java.util.Date value) 
	{
		this.passwordexpiredate = value;
	}
}

