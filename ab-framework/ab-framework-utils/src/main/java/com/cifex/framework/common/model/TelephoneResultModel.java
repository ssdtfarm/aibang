package com.cifex.framework.common.model;

import java.io.Serializable;
import java.util.List;

import com.cifex.framework.utils.page.Page;
import com.alibaba.fastjson.JSON;

public class TelephoneResultModel<M> implements
		Serializable {

	private static final long serialVersionUID = -2228934832665210390L;
	/**
	 * 实体s
	 */
	private M master;
	/**
	 * 提示消息
	 */
	private String msg;
	/**
	 * 成功/失败 0，1
	 */
	private String state = "0";
	/**
	 * 实体列表形式
	 */
	private List<M> masterList;

	private Page<M> page;
	/**
	 * 成功推荐的人数
	 */
   private String successNum;
   /**
	 * 推荐失败的人数
	 */
   private String failureNum;
 
     
   
   
   

	public String getFailureNum() {
	return failureNum;
}

public void setFailureNum(String failureNum) {
	this.failureNum = failureNum;
}

	public String getSuccessNum() {
		return successNum;
	}

	public void setSuccessNum(String successNum) {
		this.successNum = successNum;
	}

	public M getMaster() {
		return master;
	}

	public void setMaster(M master) {
		this.master = master;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	/**
	 * 转换Json格式-JsonViewModel 对象
	 * 
	 * @return
	 */
	public String toJsonString() {
		return JSON.toJSON(this).toString();
	}

	/***
	 * 转换Json格式=实体对象 master
	 * 
	 * @return
	 */
	public String masterToJsonString() {
		return JSON.toJSON(this.master).toString();
	}

	/**
	 * 转换Json格式=实体对象列表 masterList
	 * 
	 * @return
	 */
	public String masterListToJsonString() {
		return JSON.toJSON(this.masterList).toString();
	}

	/**
	 * @Title: masterPageToJsonString
	 * @Description: 返回Page JSON
	 * @param @return
	 * @return String
	 * @throws
	 */
	public String masterPageToJsonString() {
		return JSON.toJSON(this.page).toString();
	}

	public List<M> getMasterList() {
		return masterList;
	}

	public void setMasterList(List<M> masterList) {
		this.masterList = masterList;
	}

	public Page<M> getPage() {
		return page;
	}

	public void setPage(Page<M> page) {
		this.page = page;
	}

	

}
