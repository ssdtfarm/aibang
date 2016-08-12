﻿<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
	<head>
	<base href="${project_name}/">
	<!-- jsp文件头和头部 -->
	<%@ include file="../../admin/top.jsp"%>
	<script language="javascript" type="text/javascript" src="${css_imagedomain}/plugins/jsCalendar/WdatePicker.js"></script> 
	</head> 
<body>
		
<div class="container-fluid" id="main-container">


<div id="page-content" class="clearfix">
						
  <div class="row-fluid">

	<div class="row-fluid">
			<div id="breadcrumbs" style="margin-bottom:10px;">
				<table class="center" style="width:50%;">
					<tr height="35">
						<td style="width:150px;" class="center" bgcolor="#E5E5E5">
							<a href="javascript:void(0);" onclick="goInfoTab('1');" style="text-decoration:none; display:block;"><font color="#666666">身份证认证</font></a>
						</td>
						<td width="5px;"></td>
						<td style="width:150px;" class="center" bgcolor="#E5E5E5">
							<a href="javascript:void(0);" onclick="goInfoTab('2');" style="text-decoration:none; display:block;"><font color="#666666">手机认证</font></a>
						</td>
						<td width="5px;"></td>
						<td style="width:150px;" class="center" bgcolor="#E5E5E5">
							<a href="javascript:void(0);" onclick="goInfoTab('3');" style="text-decoration:none; display:block;"><font color="#666666">邮箱认证</font></a>
						</td>
						<td width="5px;"></td>
						<td style="width:150px;" class="center" bgcolor="#438eb9">
							<a href="javascript:void(0);" onclick="goInfoTab('4');" style="text-decoration:none; display:block;"><font color="#fff">银行卡</font></a>
						</td>
					</tr>
				</table>
			</div>
			<!-- 检索  -->
			<form action="hjsaccountusersbank/list.do" method="post" name="userForm" id="userForm">
			<table>
				<tr>
					<td>
						<span class="input-icon">
							<input autocomplete="off" id="nav-search-input" type="text" name="username" value="${checkname }" placeholder="这里输入关键词" />
							<i id="nav-search-icon" class="icon-search"></i>
						</span>
					</td>
					<td><input  name="createTimeBegin" id="createTimeBegin" onclick="WdatePicker({el:'createTimeBegin',dateFmt:'yyyy-MM-dd',createTimeBegin: '%y-%M-%d'})"  value="<fmt:formatDate value='${checkTimeBegin}' pattern='yyyy-MM-dd' />" type="text" readonly="readonly" style="width:88px;" placeholder="开始日期"  title="开始日期"/></td>
					<td><input  name="createTimeEnd" id="createTimeEnd" onclick="WdatePicker({el:'createTimeEnd',dateFmt:'yyyy-MM-dd',createTimeEnd: '%y-%M-%d'  })"  value="<fmt:formatDate value='${checkTimeEnd}' pattern='yyyy-MM-dd' />" type="text" readonly="readonly" style="width:88px;" placeholder="结束日期"  title="结束日期"/></td>
					<c:if test="${QX.cha == 1 }">
					<td style="vertical-align:top;"><button class="btn btn-mini btn-light" onclick="search();" title="查询">查询</button></td>
					</c:if>
				</tr>
			</table>
			<!-- 检索  -->
		
		
			<table id="table_report" class="table table-striped table-bordered table-hover">				
				<thead>
					<tr>
						<th class='center'>ID</th>
						<th class='center'>用户名</th>
						<th class='center'>开户行名称</th>
						<th class='center'>银行账号</th>
						<th class='center'>状态</th>
						<th class='center'>通过时间</th>
						
					</tr>
				</thead>
										
				<tbody>
					
				<!-- 开始循环 -->	
				<c:choose>
					<c:when test="${not empty page.result}">
						<c:if test="${QX.cha == 1 }">
						<c:forEach items="${page.result}" var="BK" varStatus="vs">
									
							<tr>
								
								<td class='center' style="width: 30px;">${BK.ID}</td>
								<td class='center'>${BK.USERNAME}</td>
								<td class='center'>${BK.BANK_NAME }</td>
								<td class='center'>${BK.ACCOUNT } </td>
								<td class='center'>
								<c:if test="${BK.STATUS ==0 }">待审核
								</c:if>
								<c:if test="${BK.STATUS ==1 }">审核成功
								</c:if>
								<c:if test="${BK.STATUS ==-1 }">审核失败
								</c:if>
								</td>
								<td class='center'><fmt:formatDate value="${BK.CREATE_TIME }" pattern="yyyy-MM-dd"/></td>
								<%-- <td class='center' style="width: 60px;">
									<div class='hidden-phone visible-desktop btn-group'>	
										<c:if test="${QX.edit == 1 }">
											<a class='btn btn-mini btn-info' title="审核" >审核</a>
										</c:if>
									</div>
								</td> --%>
							</tr>
						
						</c:forEach>
						</c:if>
						
						<c:if test="${QX.cha == 0 }">
							<tr>
								<td colspan="10" class="center">您无权查看</td>
							</tr>
						</c:if>
					</c:when>
					<c:otherwise>
						<tr class="main_info">
							<td colspan="10" class="center">没有相关数据</td>
						</tr>
					</c:otherwise>
				</c:choose>
					
				
				</tbody>
			</table>
			
		<div class="page-header position-relative">
		<table style="width:100%;">
			<tr>
				<td style="vertical-align:top;"><div class="pagination" style="float: right;padding-top: 0px;margin-top: 0px;">${page.pageStr}</div></td>
			</tr>
		</table>
		</div>
		</form>
	</div>
 
 
 
 
	<!-- PAGE CONTENT ENDS HERE -->
  </div><!--/row-->
	
</div><!--/#page-content-->
</div><!--/.fluid-container#main-container-->
		
		<!-- 返回顶部  -->
		<a href="#" id="btn-scroll-up" class="btn btn-small btn-inverse">
			<i class="icon-double-angle-up icon-only"></i>
		</a>
		
		<!-- 引入 -->
		<script type="text/javascript">window.jQuery || document.write("<script src='static/js/jquery-1.9.1.min.js'>\x3C/script>");</script>
		<script src="${css_imagedomain}/js/bootstrap.min.js"></script>
		<script src="${css_imagedomain}/js/ace-elements.min.js"></script>
		<script src="${css_imagedomain}/js/ace.min.js"></script>
		
		<script type="text/javascript" src="${css_imagedomain}/js/chosen.jquery.min.js"></script><!-- 下拉框 -->
		<script type="text/javascript" src="${css_imagedomain}/js/bootstrap-datepicker.min.js"></script><!-- 日期框 -->
		<script type="text/javascript" src="${css_imagedomain}/js/bootbox.min.js"></script><!-- 确认窗口 -->
		<!-- 引入 -->
		
		
		<script type="text/javascript" src="${css_imagedomain}/js/jquery.tips.js"></script><!--提示框-->
		<script type="text/javascript">
		
		$(top.hangge());
		
		//检索
		function search(){
			top.jzts();
			$("#userForm").submit();
		}
		//修改
		function editUser(user_id){
			top.mainFrame.showTabPage("用户修改",'${project_name}/usersInfo/toEdit.do?id='+user_id);
		}
		//详细
		function detailUser(user_id){
			top.mainFrame.showTabPage("会员详细",'${project_name}/usersInfo/detail.do?id='+user_id);
		}
		</script>
		
		<script type="text/javascript">		
		$(function() {			
			//日期框
			$('.date-picker').datepicker();
			
			//下拉框
			$(".chzn-select").chosen(); 
			$(".chzn-select-deselect").chosen({allow_single_deselect:true}); 
			
			//复选框
			$('table th input:checkbox').on('click' , function(){
				var that = this;
				$(this).closest('table').find('tr > td:first-child input:checkbox')
				.each(function(){
					this.checked = that.checked;
					$(this).closest('tr').toggleClass('selected');
				});
					
			});
			
		});
		function goInfoTab(v){
			if(v=="1"){
				document.location.href="hjsapproverealname/list.do";
			}else if(v=="2"){
				document.location.href="hjsapprovesms/list.do";
			}else if(v=="3"){
				document.location.href="hjsapproveemailactive/list.do";
			}else if(v=="4"){
				document.location.href="hjsaccountusersbank/list.do";
			}
		}
		</script>
		
	</body>
	<jsp:include page="../../../common/alert_message.jsp"  ></jsp:include>
</html>

