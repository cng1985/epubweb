<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传epub电子书</title>
</head>
<body>
	<form action="add.ada" method="post">
		<table>
			<tr>
				<td>电子书名</td>
				<td><input name="name" />
				</td>
			</tr>
			<tr>
				<td>上传图片</td>
				<td><input name="picurl" />
				</td>
			</tr>
			<tr>
				<td>上传电子书</td>
				<td><input name="picurl" />
				</td>
			</tr>
			<tr>
				<td><input type="reset"/></td>
				<td><input type="submit"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>