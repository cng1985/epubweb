<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${title}</title>
</head>
<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="1"
		bgcolor="#999999">
		<tr>
			<td height="27" align="center"
				background="<%=path%>/project/img/cat_bg.gif">序号</td>
			<td align="center" background="<%=path%>/project/img/cat_bg.gif">书籍名字</td>
			<td align="center" background="<%=path%>/project/img/cat_bg.gif">封面图</td>
			<td align="center" background="<%=path%>/project/img/cat_bg.gif">操作</td>
		</tr>
		<s:if test="pageResult!=null">
			<s:if test="pageResult.resultList!=null">
				<s:set name="alllist" value="pageResult.resultList" />
				<s:iterator value="#alllist" status="st">
					<tr onmouseover="this.style.backgroundColor='#BDDFFF'"
						onmouseout="this.style.backgroundColor='#FFFFFF'">
						<td height="20" align="center" bgcolor="#FFFFFF"><s:property
								value="#st.index+1" /></td>
						<td align="center" bgcolor="#FFFFFF"><s:property value="name" /></a>
						</td>
						<td align="center" bgcolor="#FFFFFF"><img alt="" width="40"
							height="40" src="<s:property value="picurl"/>"></td>
						<td align="center" bgcolor="#FFFFFF"><a
							href="epub_delete.action?epub.id=<s:property value="id"/>">删除</a><a
							href="epub_preupdate.action?epub.id=<s:property value="id"/>">更新</a>
						</td>
					</tr>
				</s:iterator>
			</s:if>
		</s:if>
	</table>
	<table border="0" cellPadding="2" align="center" cellSpacing="0"
		width="70%" bgcolor="#FFFFFF">
		<tr>
			<td align="center" class="tou" colspan="5"><font
				style="font-size: 12px;"> <s:if
						test="pageResult!=null&&pageResult.resultList!=null">
							  					        
						                  第<FONT color="red"> <s:property
								value="pageResult.pageBean.currentPage" />
						</FONT>页/
						                  共<FONT color="red"><s:property
								value="pageResult.pageBean.getTotalPages()" />
						</FONT>页&nbsp;						                  
						                 记录总数:<FONT color="red"><s:property
								value="pageResult.pageBean.totalRows" />
						</FONT> 条&nbsp;
					           (每页<s:property value="pageResult.pageBean.pageSize" />条)&nbsp;&nbsp;
					                <s:if test="pageResult.pageBean.currentPage==1">
					                                                 首页 &nbsp;上一页


					                </s:if>
						<s:else>
							<a
								href="<s:url value="epub_list.ada">
					                    <s:param name="currentPage" value="pageResult.pageBean.currentPage"/>
						    			<s:param name="pagerMethod" value="'first'"/>
						    		   </s:url>">首页</a>
							<a
								href="<s:url value="epub_list.ada">									    			
						    			<s:param name="currentPage" value="pageResult.pageBean.currentPage"/>
						    			<s:param name="pagerMethod" value="'previous'"/>
					    			    </s:url>">上一页</a>
						</s:else>
						<s:if
							test="pageResult.pageBean.currentPage==pageResult.pageBean.totalPages">
					               		   下一页 &nbsp;尾页
					                </s:if>
						<s:else>
							<a
								href="<s:url value="epub_list.ada">
						    			<s:param name="currentPage" value="pageResult.pageBean.currentPage"/>
						    			<s:param name="pagerMethod" value="'next'"/>
							    		</s:url>">下一页</a>
							<a
								href="<s:url value="epub_list.ada">
							    			<s:param name="currentPage" value="pageResult.pageBean.currentPage"/>
							    			<s:param name="pagerMethod" value="'last'"/>
							    		</s:url>">尾页</a>
						</s:else>

					</s:if> <s:else>
							        共0行&nbsp;  第0页|&nbsp;共0页&nbsp; 首页 &nbsp;上一页 &nbsp; 下一页 &nbsp;尾页							  
							  </s:else> </font></td>
		</tr>

	</table>

</body>
</html>