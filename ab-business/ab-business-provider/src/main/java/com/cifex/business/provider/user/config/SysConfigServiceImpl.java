package com.cifex.business.provider.user.config;

import com.alibaba.dubbo.rpc.RpcException;
import com.cifex.business.api.user.config.SysConfigService;
import com.cifex.business.provider.base.ProviderServiceBase;
import com.cifex.framework.utils.page.Page;
import com.cifex.transfer.model.dto.HjsSysConfig;
import com.cifex.transfer.model.vo.HjsSysConfigQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * 配置服务相关操作
 *  
 * @author zhangyong    
 * @date 2015年8月25日
 */
@Service("sysConfigService")
@SuppressWarnings({ "unchecked" })
public class SysConfigServiceImpl extends
		ProviderServiceBase<HjsSysConfig, Integer> implements
		SysConfigService {

	@Override
	public String getIbatisMapperNamesapce() {
		return "HjsSysConfig";
	}
	/**
	 * 添加或修改配置信息
	 *
	 * @param entity
	 * @return HjsSysConfig
	 * @author zhangyong
	 * @date 2015年8月25日
	 */
	public HjsSysConfig saveOrUpdate(HjsSysConfig entity) {
		if (entity.getId() == null)
			save(entity);
		else
			update(entity);
		return entity;
	}

	/**
	 * 分页获得配置信息
	 *
	 * @param query
	 * @return Page
	 * @author zhangyong
	 * @date 2015年8月25日
	 */
	@SuppressWarnings("rawtypes")
	public Page findPage(HjsSysConfigQuery query) {
		Page page = new Page();
		try {
			page = pageQuery("HjsSysConfig.findPage", query);
		} catch (Exception e) {
			throw new RpcException(RpcException.UNKNOWN_EXCEPTION,
					"分页显示配置信息错误", e.getCause());
		}
		return page;
	}
	/**
	 * 通过Pcode获得配置信息
	 *
	 * @param param
	 * @return HjsSysConfig
	 * @author zhangyong
	 * @date 2015年8月25日
	 */
	public HjsSysConfig getByPcode(String v) {
		HjsSysConfig config = new HjsSysConfig();
		try {
			config = (HjsSysConfig) getSqlSessionTemplate().selectOne(
					"HjsSysConfig.getByPcode", v);
		} catch (Exception e) {
			throw new RpcException(RpcException.UNKNOWN_EXCEPTION,
					"通过父级编码_当前编号获得配置信息错误", e.getCause());
		}
		return config;
	}
	
	/**
	 * 修改配置信息	
	 *  
	 * @param model void
	 * @author zhangyong
	 * @date 2015年8月25日
	 */
	public void update(HjsSysConfig model) {
		try {
			super.update(model);
		} catch (Exception e) {
			throw new RpcException(RpcException.UNKNOWN_EXCEPTION, "更新配置错误",
					e.getCause());
		}
	}

	/**
     * 通过ID删除配置信息
     *  
     * @param id void
     * @author zhangyong
     * @date 2015年8月25日
     */
	public void deleteById(Integer id) {
		try {
			super.deleteById(id);
		} catch (Exception e) {
			throw new RpcException(RpcException.UNKNOWN_EXCEPTION, "删除配置错误",
					e.getCause());
		}
	}

	/**
     * 逻辑删除配置信息
     *  
     * @param model void
     * @author zhangyong
     * @date 2015年8月25日
     */
	public void remove(HjsSysConfig model) {
		try {
			super.remove(model);
		} catch (Exception e) {
			throw new RpcException(RpcException.UNKNOWN_EXCEPTION,
					"逻辑删除配置错误", e.getCause());
		}
	}
	
	/**
     * 通过id获取配置信息  
     *  
     * @param id
     * @return HjsSysConfig
     * @author zhangyong
     * @date 2015年8月25日
     */
	public HjsSysConfig getById(Integer id) {
		HjsSysConfig config = new HjsSysConfig();
		try {
			config = super.getById(id);
		} catch (Exception e) {
			throw new RpcException(RpcException.UNKNOWN_EXCEPTION,
					"根据ID得到配置错误", e.getCause());
		}
		return config;
	}

	/**
     * 获得所有配置信息
     *  
     * @return List<HjsSysConfig>
     * @author zhangyong
     * @date 2015年8月25日
     */
	public List<HjsSysConfig> findAll() {
		List<HjsSysConfig> configList = new ArrayList<HjsSysConfig>();
		try {
			configList = super.findAll();
		} catch (Exception e) {
			throw new RpcException(RpcException.UNKNOWN_EXCEPTION,
					"查询所有配置列表错误", e.getCause());
		}
		return configList;
	}
	/**
	 * 配置唯一性
	 *  
	 * @param entity
	 * @param uniquePropertyNames
	 * @return boolean
	 * @author zhangyong
	 * @date 2015年8月25日
	 */
	public boolean isUnique(HjsSysConfig entity, String uniquePropertyNames) {
		boolean ref = false;
		try {
			ref = super.isUnique(entity, uniquePropertyNames);
		} catch (Exception e) {
			throw new RpcException(RpcException.UNKNOWN_EXCEPTION,
					"查询配置唯一性错误", e.getCause());
		}
		return ref;
	}
	/**
	 * 获得配置信息数量
	 *  
	 * @param query
	 * @return Long
	 * @author zhangyong
	 * @date 2015年8月25日
	 */
	public Long findCount(HjsSysConfigQuery query) {
		Long count = 0L;
		try {
			count = (Long) super.findForObject(this.getIbatisMapperNamesapce()
					+ ".findCount", query);
		} catch (Exception e) {
			throw new RpcException(RpcException.UNKNOWN_EXCEPTION,
					"通过ID获取子配置总数错误", e.getCause());
		}
		return count;
	}
	/**
	 * 查询编码是否存在
	 *  
	 * @param query
	 * @return HjsSysConfig
	 * @author zhangyong
	 * @date 2015年8月25日
	 */
	public HjsSysConfig findBmCount(HjsSysConfigQuery query) {
		HjsSysConfig config = new HjsSysConfig();
		try {
			config = (HjsSysConfig) super.findForObject(
					this.getIbatisMapperNamesapce() + ".findBmCount", query);
		} catch (Exception e) {
			throw new RpcException(RpcException.UNKNOWN_EXCEPTION, "查询编码错误",
					e.getCause());
		}
		return config;
	}

	/**
	 * 添加配置信息
	 *  
	 * @param model
	 * @return HjsSysConfig
	 * @author zhangyong
	 * @date 2015年8月25日
	 */
	@Override
	public HjsSysConfig saveObj(HjsSysConfig model) {
		try {
			super.save(model);
		} catch (Exception e) {
			throw new RpcException(RpcException.UNKNOWN_EXCEPTION, "添加配置错误",
					e.getCause());
		}
		return null;
	}

	/**
	 * 通过父类ID获得配置信息
	 *  
	 * @param query
	 * @return Page<HjsSysConfig>
	 * @author zhangyong
	 * @date 2015年8月25日
	 */
	@Override
	public Page<HjsSysConfig> dictlistPage(HjsSysConfigQuery query) {
		
		return null;
	}

	@Override
	public List<HjsSysConfig> findConfigsByParentId(Integer parentId) {

		return (List<HjsSysConfig>) super.findForList(
				this.getIbatisMapperNamesapce() + ".findConfigsByParentId",
				parentId);
	}

}