package com.aibang.transfer.model.dto;

import com.aibang.transfer.model.BaseEntity;


public class AbSysUserRole extends BaseEntity implements java.io.Serializable{

	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "HjsSysUserRole";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_ROLE_ID = "roleId";
	public static final String ALIAS_USER_ID = "userId";
	public static final String ALIAS_IS_DEL = "isDel";
	public static final String ALIAS_VERSION = "varsion";
	public static final String ALIAS_CREATE_TIME = "createTime";
	public static final String ALIAS_UPDATE_TIME = "updateTime";
	public static final String ALIAS_DELETE_TIME = "deleteTime";
	
	/**
	 * id       db_column: ID
	 * ID
	 */
	private Integer id;
	/**
	 * userId       db_column: USER_ID
	 * 用户ID
	 */
	private Integer userId;
	/**
	 * roleId       db_column: ROLE_ID
	 * 角色ID
	 */
	private Integer roleId;
	/**
	 * isDel       db_column: IS_DEL
	 * 删除标识 0：未删除 1：删除 默认0
	 */
	private Integer isDel;
	/**
	 * varsion       db_column: VERSION
	 * 版本号
	 */
	private Integer version;
	/**
	 * createTime       db_column: CREATE_TIME
	 * 创建时间
	 */
	private java.util.Date createTime;
	/**
	 * updateTime       db_column: UPDATE_TIME
	 * 修改时间
	 */
	private java.util.Date updateTime;
	/**
	 * deleteTime       db_column: DELETE_TIME
	 * 删除时间
	 */
	private java.util.Date deleteTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Integer getIsDel() {
		return isDel;
	}
	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}
	public java.util.Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	public java.util.Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}
	public java.util.Date getDeleteTime() {
		return deleteTime;
	}
	public void setDeleteTime(java.util.Date deleteTime) {
		this.deleteTime = deleteTime;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	
	
	
}
