package com.aibang.business.provider.user.user;

import org.springframework.stereotype.Service;

import com.aibang.business.api.user.user.UsersLogService;
import com.aibang.business.provider.base.ProviderServiceBase;
import com.aibang.framework.utils.page.Page;
import com.aibang.transfer.model.dto.HjsUsersLog;
import com.aibang.transfer.model.vo.HjsUsersLogQuery;
import com.alibaba.dubbo.rpc.RpcException;
 
 
/**
 * 会员日志
 * @author zhangyong    
 * @date 2015年9月16日
 */
@Service("usersLogService")
@SuppressWarnings({"unchecked"})
public class UsersLogServiceImpl  extends ProviderServiceBase<HjsUsersLog,Integer> implements UsersLogService {
 
	@Override
	public String getIbatisMapperNamesapce() {
		return "HjsUsersLog";
	}
	
	public HjsUsersLog saveOrUpdate(HjsUsersLog entity) {
		if(entity.getId() == null) 
			save(entity);
		else 
			update(entity);
		return entity;
	}
	@SuppressWarnings({"rawtypes"})
	public Page findPage(HjsUsersLogQuery query) {
		return pageQuery("HjsUsersLog.findPage",query);
	}

	/**
	 * 保存会员日志
	 * @param model
	 * @return HjsUsersLog
	 * @author zhangyong
	 * @date 2015年9月15日
	 */
	@Override
	public HjsUsersLog saveObj(HjsUsersLog model) {
		try {
			super.save(model);
		}catch (Exception e) {
			throw new RpcException(RpcException.UNKNOWN_EXCEPTION,"保存会员日志信息错误",e.getCause());
		}
		return model;
	}
	
	 
}