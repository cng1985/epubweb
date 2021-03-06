﻿<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<% String path1=request.getServletContext().getContextPath(); 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title><%=basePath %></title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/common.js"></script>
</head>
<body>

<script type="text/javascript">
var menu = 
{"dashboard":{"text":"分类管理","subtext":"常用操作","default":"welcome","children":{
	"categorypreadd":{"text":"添加分类","url":"<%=basePath%>category/category_preadd.ada"},
	"welcome":{"text":"分类管理","url":"<%=basePath%>category/category_list.ada"}}},



"company":{"text":"书籍管理","subtext":"可选操作项","default":"introduce","children":{
	"introduce":{"text":"添加书籍","url":"<%=basePath%>epub/epub_preadd.ada"},
	"auth":{"text":"书籍列表","url":"<%=basePath%>epub/epub_list.ada"},
	"register":{"text":"组织架构","url":"setting.php?do=register"},
	"honor":{"text":"公司荣誉","url":"company/honor_list.html"},
	"rule":{"text":"公司制度","url":"company/rule_list.html"},
	"pic":{"text":"企业业绩图展示","url":"company/pic_list.html"},	
	"table":{"text":"企业业绩表展示","url":"company/table_list.html"}}},
	
"infomation":{"text":"信息通报","subtext":"可选操作项","default":"ad","children":{
"ad":{"text":"最新通知","url":"info/notice/list.html"},
"adzone1":{"text":"活动信息","url":"info/activity/list.html"},
"ad_add":{"text":"日常督办事项","url":"info/chief/list.html"},	
"adzone":{"text":"专题督办事项","url":"info/theme_chief/list.html"},
"goods":{"text":"日常会议纪要","url":"info/minutes/list.html"},
"order":{"text":"专题会议纪要","url":"info/theme_minutes/list.html"},
"friendlink":{"text":"乐捐箱","url":"friendlink.php"},
"friendlink111":{"text":"奖励箱","url":"friendlink.php"}}},


"office":{"text":"个人办公","subtext":"可选操作项","default":"mail","children":{
	"mail":{"text":"收件箱","url":"office/mail/receive.html"},
	"weekplan":{"text":"周工作计划","url":"office/weekplan/list.html"},
	"monthplan":{"text":"月工作计划","url":"office/monthplan/list.html"},
	"news666":{"text":"外出登记","url":"office/goregister/list.html"},
	"worklog":{"text":"工作日志","url":"office/worklog/list.html"},
	"diary":{"text":"个人日记","url":"office/diary/list.html"},
	"news":{"text":"备忘提醒","url":"office/remind/list.html"},	
	"advice":{"text":"意见箱","url":"office/advice/receive.html"},
	"taxi":{"text":"出租车报票登记","url":"office/taxi/list.html"},
	"personalbook":{"text":"个人通讯录","url":"office/personalbook/list.html"},
	"companybook":{"text":"公司通讯录","url":"office/companybook/list.html"},
	"publicbook":{"text":"公共通讯录","url":"office/publicbook/list.html"}}},
	
	
"approval":{"text":"业务审批","subtext":"可选操作项","default":"wait","children":{
	"wait":{"text":"待审批业务","url":"approval/option/wait.html"},
	"pmoneyplan":{"text":"工程资金计划","url":"approval/project_money/wait.html"},
	"amoneyplan":{"text":"行政资金计划","url":"approval/admin_money/wait.html"},
	"member_add":{"text":"工程款申请","url":"approval/money_apply/wait.html"},
	"adminer":{"text":"合同审批","url":"approval/contract/wait.html"},	
	"adminer333":{"text":"请假申请","url":"approval/leave/wait.html"},
	"adminer000":{"text":"证件使用申请","url":"approval/document/wait.html"},
	"adminer222":{"text":"预审资料申请","url":"approval/presource/wait.html"},
	"adminer1100":{"text":"设计报销清单","url":"approval/design/wait.html"},
	"adminer4":{"text":"印章使用申请","url":"approval/stamp/wait.html"},
	"adminer5":{"text":"材料采购计划","url":"approval/material_plan/wait.html"},
	"adminer7":{"text":"费用报销单","url":"approval/baoxiao/wait.html"},
	"adminer8":{"text":"运费、垃圾清理单","url":"approval/freight/wait.html"},
	"adminer9":{"text":"零星用工单","url":"approval/workeruse/wait.html"},
	"adminer10":{"text":"人工费申请单","url":"approval/labor_costs/wait.html"},
	"adminer11":{"text":"现场签证申请","url":"approval/visa/wait.html"}}},
	
	
"project":{"text":"项目管理","default":"printplan","children":{
	"printplan":{"text":"认领打印采购计划","url":"approval/material_plan/print_list.html"},	
	"store":{"text":"库存材料管理","url":"project/store/in/list.html"},
	"news3":{"text":"项目分析","url":"project/budget/project.html"},
	"news4":{"text":"人工定额库","url":"project/fixed/main.html"},
	"news5":{"text":"工队信息库","url":"project/team/main.html"},	
	"news88":{"text":"材料资源库","url":"project/material/main.html"},
	"news7":{"text":"施工日志","url":"project/projectlog/list.html"},
	"news8":{"text":"机械租赁","url":"project/machine/list.html"}}},
	
	
	
"BBS":{"text":"公司论坛","default":"tproject","children":{
	"tproject":{"text":"投标项目","url":"bbs/border_list.html"},
	"skin1":{"text":"在建项目","url":"templet.html"},
	"skin2":{"text":"竣工项目","url":"templet.php?type=user"},
	"skin3":{"text":"员工论坛","url":"templet.php?type=user"}	}},
	
	
	
"collection":{"text":"数据统计","default":"workplan","children":{
	"workplan":{"text":"工作计划上交情况汇总","url":"collection/workplan/weekplan.html"},
	"leave":{"text":"请假信息汇总","url":"collection/leave/month.html"},
	"applymoney":{"text":"工程请款信息汇总","url":"collection/applymoney/month.html"},
	"project":{"text":"项目开销汇总","url":"templet.php?type=user"},
	"material":{"text":"项目材料信息汇总","url":"collection/matrail/list.html"},
	"skin3":{"text":"项目人工信息汇总","url":"collection/team/list.html"},
	"skin333":{"text":"机械租赁费汇总","url":"templet.php?type=user"},
	"skin4":{"text":"项目合同汇总","url":"collection/contract/list.html"}}},
	
	


"usermanager":{
	"text":"财务系统","default":"userinfo","children":{
	"department":{"text":"支出管理","url":"listRecord.action"},
	"role":{"text":"角色管理","url":"admin/role/manage.html"},
	"userinfo":{"text":"用户信息管理","url":"admin/userinfo/list.html"},		
	"function":{"text":"功能管理","url":"admin/function/manage.html"},
	"project":{"text":"项目管理","url":"admin/project/list.html"},
	"var":{"text":"系统参数设置","url":"admin/project/list.html"}}}
};
;
/* 当前所在选项卡 */
var currTab = 'dashboard';
var firstOpen = [];
</script>
<script type="text/javascript" src="js/index.js"></script>

<div id="head">
    <div id="logo"><a href="#" target="_blank"><img src="images/logo1.gif" border="0" /></a></div>
    <div id="menu"><span>您好，<strong>张三</strong> [<a href="#" target="_self" title="用其他帐号重新登录">注销</a>，<a href="userinfo/edit.html" title="设置个人信息" target="workspace">账户设置</a>，<a href="#">退出</a>]</span>
    
    <a href="javascript:;" class="menu_btn1" id="iframe_refresh" title="刷新工作区页面">刷新页面</a>
  </div>
    <ul id="nav"></ul>
    <div id="headBg"></div>
</div>
<div id="content">
    <div id="left">
        <div id="leftMenus">
            <dl id="submenu">
                <dt><a class="ico1" id="submenuTitle" href="javascript:;"></a></dt>
            </dl>
         </div>
		<div class="copyright">
			<p>Powered by </p>
			<p>&copy; 2007-2010 GETE Inc.</p>
		</div>
    </div>
    <div id="right">
        <iframe frameborder="0" style="display:none;" width="100%" id="workspace" name="workspace"></iframe>
    </div>
</div>
</body>
</html>
