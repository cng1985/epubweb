<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>id</td>
			<td>分类名</td>
			<td>操作</td>
		</tr>
		<s:iterator value="categorys">
			<tr>
				<td><s:property value="id" />
				</td>
				<td><s:property value="title" />
				</td>
				<td><a
					href="category_delete.ada?category.id=<s:property value="id"/>">删除</a><a
					href="category_preupdate.ada?category.id=<s:property value="id"/>">更新</a>
				</td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>

