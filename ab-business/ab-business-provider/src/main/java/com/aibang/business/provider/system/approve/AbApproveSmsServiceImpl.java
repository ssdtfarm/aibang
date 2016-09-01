package com.aibang.business.provider.system.approve;

import java.text.SimpleDateFormat;

import org.springframework.stereotype.Service;

import com.aibang.business.api.system.approve.AbApproveSmsService;
import com.aibang.business.provider.base.ProviderServiceBase;
import com.aibang.framework.utils.page.Page;
import com.aibang.transfer.model.dto.AbApproveSms;
import com.aibang.transfer.model.dto.AbUser;
import com.aibang.transfer.model.vo.AbApproveSmsQuery;
import com.alibaba.dubbo.rpc.RpcException;
 
 
/** 
 * @author 
 * @version 1.0
 * @since 1.0
 */


 
@Service("hjsApproveSmsService")
@SuppressWarnings({"unchecked"})
public class AbApproveSmsServiceImpl  extends ProviderServiceBase<AbApproveSms,Integer> implements AbApproveSmsService {
 
	@Override
	public String getIbatisMapperNamesapce() {
		return "HjsApproveSms";
	}
	
	public AbApproveSms saveOrUpdate(AbApproveSms entity) {
		if(entity.getId() == null) 
			save(entity);
		else 
			update(entity);
		return entity;
	}
	/**
	 * 显示手机验证列表（分页）
	 */
	@SuppressWarnings({"rawtypes"})
	public Page findPage(AbApproveSmsQuery query) {
		try{
			//处理查询时间格式
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			if(query.getVerifyTimeBegin()!=null){
				query.setVerifyTimeBegin(format1.parse(format.format(query.getVerifyTimeBegin())+" 00:00:00"));
			}
			if(query.getVerifyTimeEnd()!=null){
				
				query.setVerifyTimeEnd(format1.parse(format.format(query.getVerifyTimeEnd())+" 23:59:59"));
			}
			return pageQuery("HjsApproveSms.findPage",query);
		}catch(Exception e){
			throw new RpcException(RpcException.UNKNOWN_EXCEPTION,"显示手机验证列表错误",e.getCause());
		}
		
	}

	@Override
	public AbApproveSms saveObj(AbApproveSms model) {
		// TODO Auto-generated method stub
		return null;
	}
	/**   
	 * 根据ID获得手机认证信息
	 * @param id
	 * @return HjsApproveSms
	 * @author zhangyong
	 * @date 2015年9月8日
	 */
    public AbApproveSms getById(Integer id){
    	AbApproveSms hjsApproveSms = null;
    	try {
    		hjsApproveSms = super.getById(id);
		}catch (Exception e) {
			throw new RpcException(RpcException.UNKNOWN_EXCEPTION,"根据ID获得手机认证信息错误",e.getCause());
		}
    	return hjsApproveSms;
    }
    /**
	 * 审核手机认证
	 * @param entity
	 * @return HjsApproveSms
	 * @author zhangyong
	 * @date 2015年9月8日
	 */
	public void auditSms(AbApproveSms entity){
		try {
			super.update(getIbatisMapperNamesapce()+".audit",entity);//修改手机审核状态
			AbUser hjsUser = new AbUser();
			hjsUser.setId(entity.getUserId());
			hjsUser.setPhoneStatus(entity.getStatus());
			hjsUser.setOptId(entity.getVerifyUserid());
			update("HjsUser.auditPhone", hjsUser);//修改用户表手机审核相关状态
		}catch (Exception e) {
			throw new RpcException(RpcException.UNKNOWN_EXCEPTION,"审核手机认证错误",e.getCause());
		}
	}
	 
}