package com.aibang.business.provider.system.user;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.aibang.business.api.system.user.HjsUsersBlackService;
import com.aibang.business.provider.base.ProviderServiceBase;
import com.aibang.framework.utils.page.Page;
import com.aibang.transfer.model.dto.HjsUsersBlack;
import com.aibang.transfer.model.vo.HjsUsersBlackQuery;
import com.alibaba.dubbo.rpc.RpcException;
 
 
/** 
 * @author 
 * @version 1.0
 * @since 1.0
 */


 
@Service("hjsUsersBlackService")
@SuppressWarnings({"unchecked"})
public class HjsUsersBlackServiceImpl  extends ProviderServiceBase<HjsUsersBlack,Integer> implements HjsUsersBlackService {
 
	@Override
	public String getIbatisMapperNamesapce() {
		return "HjsUsersBlack";
	}
	
	public HjsUsersBlack saveOrUpdate(HjsUsersBlack entity) {
		if(entity.getId() == null) 
			save(entity);
		else 
			update(entity);
		return entity;
	}
	@SuppressWarnings({"rawtypes"})
	public Page findPage(HjsUsersBlackQuery query) {
		Page<HjsUsersBlack> infoPage=null;
		try {
			//处理查询时间格式
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			if(query.getCreateTimeBegin()!=null){
				query.setCreateTimeBegin(format1.parse(format.format(query.getCreateTimeBegin())+" 00:00:00"));
			}
			if(query.getCreateTimeEnd()!=null){
				
				query.setCreateTimeEnd(format1.parse(format.format(query.getCreateTimeEnd())+" 23:59:59"));
			}
			infoPage = pageQuery("HjsUsersBlack.findPage",query);
		}catch (Exception e) {
			throw new RpcException(RpcException.UNKNOWN_EXCEPTION,"后台得到受限用户信息列表（分页）错误",e.getCause());
		}
		return infoPage;
	}

	@Override
	public HjsUsersBlack saveObj(HjsUsersBlack model) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 通过用户账户ID得到账户黑名单信息
	 * @param baseId
	 * @return HjsUsersBlack
	 * @author zhangyong
	 * @date 2015年11月2日
	 */
	public HjsUsersBlack getByBaseId(Integer baseId){
		HjsUsersBlack usersBlack = null;
		try {
			HjsUsersBlackQuery query = new HjsUsersBlackQuery();
			query.setUserId(baseId);
			usersBlack = (HjsUsersBlack)findForObject(getIbatisMapperNamesapce()+".getByBaseId", query);
		}catch (Exception e) {
			throw new RpcException(RpcException.UNKNOWN_EXCEPTION,"通过用户账户ID得到账户黑名单信息错误",e.getCause());
		}
		return usersBlack;
	}
	
	/**
	 * 添加受限会员
	 * @param baseids 添加受限账户的ID
	 * @param charge 限制返佣 0不限1限制
	 * @param limiteTender 限制投资 0不限1限制
	 * @return HjsUsersBlack
	 * @author zhangyong
	 * @date 2015年11月3日
	 */
	public void addBlack(String baseids,Integer charge,Integer limiteTender,String ip,Integer optId){
		try {
			HjsUsersBlack usersBlack = new HjsUsersBlack();
			usersBlack.setCharge(charge);
			usersBlack.setLimiteTender(limiteTender);
			usersBlack.setCreateTime(new Date());
			usersBlack.setOptId(optId);
			usersBlack.setCreateIp(ip);
			if(baseids!=null&&!baseids.equals("")){
				String[] ids= baseids.split(",");
				for(String id:ids){
					HjsUsersBlackQuery query = new HjsUsersBlackQuery();
					query.setUserId(Integer.parseInt(id));
					HjsUsersBlack black = (HjsUsersBlack)findForObject("HjsUsersBlack.getByBaseId", query);
					if(black==null){
						usersBlack.setUserId(Integer.parseInt(id));
						save(usersBlack);
					}
					
				}
			}
			
		}catch (Exception e) {
			throw new RpcException(RpcException.UNKNOWN_EXCEPTION,"添加受限会员错误",e.getCause());
		}
	}
	/**
	 * 修改受限会员
	 * @param ids 修改受限ID
	 * @param charge 限制返佣 0不限1限制
	 * @param limiteTender 限制投资 0不限1限制
	 * void
	 * @author zhangyong
	 * @date 2015年11月3日
	 */
	public void editBlack(String ids,Integer charge,Integer limiteTender,Integer optId){
		try {
			HjsUsersBlack usersBlack = new HjsUsersBlack();
			usersBlack.setCharge(charge);
			usersBlack.setLimiteTender(limiteTender);
			usersBlack.setCreateTime(new Date());
			usersBlack.setOptId(optId);
			if(ids!=null&&!ids.equals("")){
				String[] uids= ids.split(",");
				for(String id:uids){
					usersBlack.setId(Integer.parseInt(id));
					update("HjsUsersBlack.editBlack",usersBlack);
				}
			}
			
		}catch (Exception e) {
			throw new RpcException(RpcException.UNKNOWN_EXCEPTION,"修改受限会员错误",e.getCause());
		}
	}
	
	/**
	 * 删除受限会员
	 * @param ids void
	 * @author zhangyong
	 * @date 2015年11月3日
	 */
	public void delBlack(String ids){
		try {

			if(ids!=null&&!ids.equals("")){
				String[] uids= ids.split(",");
				for(String id:uids){
					deleteById(Integer.parseInt(id));
				}
			}
			
		}catch (Exception e) {
			throw new RpcException(RpcException.UNKNOWN_EXCEPTION,"修改受限会员错误",e.getCause());
		}
	}
	 
}
