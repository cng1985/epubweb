<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加分类</title>
</head>
<body>
	<form action="category_add.ada" method="post">
		<input type="hidden" name="sourtnum" value="1">
		<table>
			<tr>
				<td>分类名</td>
				<td><input name="category.title" /></td>
			</tr>
			<tr>
				<td>父分类</td>
				<td>
				<s:select list="categorys" listKey="id" listValue="title" name="category.pid" headerKey="0" headerValue="无"></s:select>
				</td>
			</tr>
			<tr>
				<td><input type="reset" />
				</td>
				<td><input type="submit" /></td>
			</tr>
		</table>

	</form>
</body>
</html>