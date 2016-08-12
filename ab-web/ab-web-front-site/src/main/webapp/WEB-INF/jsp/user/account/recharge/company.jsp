<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="description" content="overview & stats" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	 <%@ include file="/WEB-INF/jsp/common/head.jsp" %>
	 <%@ include file="/WEB-INF/jsp/common/top.jsp"%>
	 <link href="${css_imagedomain}/front/css/trading.css" rel="stylesheet" type="text/css" />
<link href="${css_imagedomain}/front/css/mask.css" rel="stylesheet" type="text/css" />
<title>企业充值</title>
<script type="text/javascript">

$(document).ready(function(){
	$("#subBtn").click(function (){
		var isNum = /^\d+(\.\d{0,9})?$/;
	  	var isNum1= /^\d+(\.\d{0,2})?$/;
	  	var isNum2=/^([1-9][\d]{0,7}|0)(\.[\d]{0,2})?$/;;
        var money = $("input[name='money']").val();
        
        if(money<1){
        	$("#validate1").html("最低充值金额应大于等于 1 元");
        	//alert("请充值金额大于1");
        	return;
        }
        if(!isNum.test(money)){
        	$("#validate1").html("请输入正确的金额");
            //alert("请输入正确的金额");
            return;
        } 
        if(!isNum1.test(money)){
        	$("#validate1").html("请只保留两位小数");
        	 //alert("请只保留两位小数");
	            return;
        }
        if(!isNum2.test(money)){
        	$("#validate1").html("请输入金额小于9位");
            //alert("请输入正确的金额");
            return;
        }  
    
       var userbaseId=$("#userBaseId").val();
       if(userbaseId=="" ||userbaseId==null ){
    	   alert("请选择企业");
       	return false;
       }
       
	    $("#companyRecharge").submit();
	});
	
	
});

</script> 
</head>
<body>
<form id="companyRecharge" action="${project_name}/enterPriseRecharge/companyRecharge" method="post" >
借款企业：<select name="userBaseId" id="userBaseId">
<option value="">==请选择企业==</option>
<c:forEach items="${enterprice }" var="item" varStatus="status" >
<option value="${item.ID }">${item.ENT_NAME }</option>
</c:forEach>
</select><br>
充值金额：<input type="text" name="money" value=""  >
	
<div id="validate1" style="color:red" value=""></div>
<input type="button" id="subBtn" value="提交" >
</form>

</body>

</html>