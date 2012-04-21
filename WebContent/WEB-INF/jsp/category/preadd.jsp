<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加分类</title>
</head>
<body>
	<form action="add.ada" method="post">
		<input type="hidden" name="sourtnum" value="1">
		<table>
			<tr>
				<td>分类名</td>
				<td><input name="title" /></td>
			</tr>
			<tr>
				<td>父分类</td>
				<td><select name="pid">
						<option value="0">无</option>
						<c:forEach items="${categorys}" var="item">
							<c:out value="${item.id}">${item.title}</c:out>
						</c:forEach>
				</select></td>
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