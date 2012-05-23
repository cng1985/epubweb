<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传epub电子书</title>
<link rel="stylesheet" href="<%=basePath%>ui/kindeditor/themes/default/default.css" />
<link rel="stylesheet" href="<%=basePath%>ui/kindeditor/plugins/code/prettify.css" />
	
<script src="<%=basePath%>ui/kindeditor/kindeditor.js"></script>
<script src="<%=basePath%>ui/kindeditor/lang/zh_CN.js"></script>
	<script charset="utf-8" src="<%=basePath%>ui/kindeditor/plugins/code/prettify.js"></script>

<script>
	KindEditor.ready(function(K) {
		var editor = K.editor({
			allowFileManager : true,
			cssPath : '<%=basePath%>ui/kindeditor/plugins/code/prettify.css',
			uploadJson : '<%=basePath%>ui/kindeditor/jsp/upload_json.jsp?dir=image',
			fileManagerJson : '<%=basePath%>ui/kindeditor/jsp/file_manager_json.jsp?dir=image'
						});
				K('#insertfile').click(function() {
					editor.loadPlugin('insertfile', function() {
						editor.plugin.fileDialog({
							fileUrl : K('#picurl').val(),
							clickFn : function(url, title) {
								K('#picurl').val(url);
								K('#picurlimg').attr("src", url);
								editor.hideDialog();
							}
						});
					});
				});
				K('#insertfileurl').click(function() {
					editor.loadPlugin('insertfile', function() {
						editor.plugin.fileDialog({
							fileUrl : K('#fileurl').val(),
							clickFn : function(url, title) {
								K('#fileurl').val(url);
								editor.hideDialog();
							}
						});
					});
				});

				ada = K.create('textarea[name="epub.description"]', {
					allowFileManager : true,
					cssPath : '<%=basePath%>ui/kindeditor/plugins/code/prettify.css',
					uploadJson : '<%=basePath%>ui/kindeditor/jsp/upload_json.jsp?dir=image',
					fileManagerJson : '<%=basePath%>ui/kindeditor/jsp/file_manager_json.jsp?dir=image'
				});
				prettyPrint();
			});
</script>
</head>
<body>
	<form action="epub_add.ada" method="post">
		<input type="hidden" name="sourtnum" value="1">
		<table>
			<tr>
				<td>电子书名</td>
				<td><input name="epub.name" />
				</td>
			</tr>
			<tr>
				<td>分类名</td>
				<td><s:select list="categorys" listKey="id" listValue="title"
						name="epub.categoryid" headerKey="0" headerValue="无"></s:select></td>
			</tr>
			<tr>
				<td>上传图片</td>
				<td><input name="epub.picurl" id="picurl" /> <input
					type="button" id="insertfile" value="选择文件" />
				</td>
			</tr>
			<tr>
				<td>图片</td>
				<td><img alt="" src="" id="picurlimg">
				</td>
			</tr>
			<tr>
				<td>上传电子书</td>
				<td><input name="epub.fileurl" id="fileurl" /><input
					type="button" id="insertfileurl" value="选择文件" />
				</td>
			</tr>
			<tr>
				<td>描述</td>
				<td><textarea name="epub.description"
						style="width: 600px; height: 400px;">添加描述</textarea>
				</td>
			</tr>
			<tr>
				<td><input type="reset" /></td>
				<td><input type="submit" />
				</td>
			</tr>
		</table>

	</form>
</body>
</html>