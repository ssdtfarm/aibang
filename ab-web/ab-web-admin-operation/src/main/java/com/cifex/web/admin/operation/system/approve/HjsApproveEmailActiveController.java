
package com.cifex.web.admin.operation.system.approve;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.rpc.RpcException;
import com.cifex.business.api.system.approve.HjsApproveEmailActiveService;
import com.cifex.framework.exception.BaseException;
import com.cifex.framework.utils.page.Page;
import com.cifex.framework.utils.validate.ValidateUtils;
import com.cifex.transfer.model.dto.HjsApproveEmailActive;
import com.cifex.transfer.model.vo.HjsApproveEmailActiveQuery;
import com.cifex.web.admin.operation.base.AdminController;

/**
 * 邮箱认证
 * @author zhangyong    
 * @date 2015年9月2日
 */
@Controller
@RequestMapping(value="/hjsapproveemailactive")
public class HjsApproveEmailActiveController extends AdminController {
	
	@Resource(name="hjsApproveEmailActiveService")
	private HjsApproveEmailActiveService hjsApproveEmailActiveService;
	
	private String display(String pageName)
	{
		return  "system/approve/email/"+pageName;
	}
	/**
	 * 后台用户邮箱认证管理列表
	 * @param model
	 * @param query
	 * @return String
	 * @author zhangyong
	 * @date 2015年9月2日
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/list")
	public String listRealName(ModelMap model,HjsApproveEmailActiveQuery query){
		query.setSortColumns("tb.CREATE_TIME DESC");
		Page rnPage = hjsApproveEmailActiveService.findPage(query);
		model.addAttribute("checkname",query.getUsername());
		model.addAttribute("checkTimeBegin",query.getVerifyTimeBegin());
		model.addAttribute("checkTimeEnd",query.getVerifyTimeEnd());
		model.addAttribute("page",rnPage);
		return display("email_list");
	}
	/**
	 * 加载用户实名认证审核页
	 * @param model
	 * @param id
	 * @return String
	 * @author zhangyong
	 * @date 2015年9月8日
	 */
	@RequestMapping(value="/toaudit")
	public String goAudit(ModelMap model,String id){
		HjsApproveEmailActive hjsApproveEmailActive = hjsApproveEmailActiveService.getById(Integer.parseInt(id));
		model.addAttribute("info",hjsApproveEmailActive);
		return display("email_audit");
	}
	/**
	 * 用户实名认证审核
	 * @param model
	 * @param realName void
	 * @author zhangyong
	 * @date 2015年9月8日
	 */
	@RequestMapping(value="/audit")
	@ResponseBody
	public String audit(ModelMap model,HjsApproveEmailActive email,HttpServletRequest request){
		//判断选择审核状态
		if (ValidateUtils.isStringEmpty(email.getStatus()+"")){
			return "请选择审核操作";
		}
		email.setVerifyTime(new Date());
		email.setVerifyUserid(getLoginUser().getId());
		String msg="success";
		try {
			hjsApproveEmailActiveService.auditEmail(email);//审核
		} 
		catch(RpcException e){
			msg=e.getMessage();
		}
		catch(BaseException e){
			msg=e.getMessage();
		}
		catch(Exception e){
			msg=e.getMessage();
		}
		model.addAttribute("message",msg);
		return "200";
	}
	 
	@InitBinder
	public void initBinder(WebDataBinder binder){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format,true));
	}
}
