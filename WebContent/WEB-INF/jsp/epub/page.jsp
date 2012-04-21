<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>分页信息</title>
</head>
<body> 
      <%
      String param=request.getParameter("actionparam");
      
       %>
      <table border="0" cellPadding="2" align="center" cellSpacing="0" width="70%" bgcolor="#FFFFFF">           
             <tr>
					 <td align="center"  class="tou"  colspan="5">											
							  <font  style=" font-size:12px;"> 	
							  
							  <s:if test="pageResult!=null&&pageResult.resultList!=null">
							  					        
						                  第<FONT color="red">
						                  <s:property value="pageResult.pageBean.currentPage"/></FONT>页/
						                  共<FONT color="red"><s:property value="pageResult.pageBean.getTotalPages()"/></FONT>页&nbsp;						                  
						                 记录总数:<FONT color="red"><s:property value="pageResult.pageBean.totalRows"/></FONT> 条&nbsp;
					           (每页<s:property value="pageResult.pageBean.pageSize"/>条)&nbsp;&nbsp;
					                <s:if test="pageResult.pageBean.currentPage==1">
					                                                 首页 &nbsp;上一页


					                </s:if> 
					                <s:else>
					                  <a href="<s:url value="<%=param %>">
					                    <s:param name="currentPage" value="pageResult.pageBean.currentPage"/>
						    			<s:param name="pagerMethod" value="'first'"/>
						    		   </s:url>">首页</a>
						    		   <a href="<s:url value="<%=param %>">									    			
						    			<s:param name="currentPage" value="pageResult.pageBean.currentPage"/>
						    			<s:param name="pagerMethod" value="'previous'"/>
					    			    </s:url>">上一页</a>
					                </s:else>			    			
					    			<s:if test="pageResult.pageBean.currentPage==pageResult.pageBean.totalPages">
					               		   下一页 &nbsp;尾页
					                </s:if> 
					                <s:else>
					                   <a href="<s:url value="<%=param %>">
						    			<s:param name="currentPage" value="pageResult.pageBean.currentPage"/>
						    			<s:param name="pagerMethod" value="'next'"/>
							    		</s:url>">下一页</a>
						    			<a href="<s:url value="<%=param %>">
							    			<s:param name="currentPage" value="pageResult.pageBean.currentPage"/>
							    			<s:param name="pagerMethod" value="'last'"/>
							    		</s:url>">尾页</a>			                   
					                </s:else>			    			
					            
							  </s:if>
							  <s:else>
							        共0行&nbsp;  第0页|&nbsp;共0页&nbsp; 首页 &nbsp;上一页 &nbsp; 下一页 &nbsp;尾页							  
							  </s:else>	
					   </font>	
		       </td>
		</tr>
               
</table>  
          

</body>
</html>