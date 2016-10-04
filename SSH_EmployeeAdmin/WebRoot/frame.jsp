<%@ page language="java" import="java.util.*"
	contentType="text/html;charset=UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<title>员工管理系统</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>
<frameset rows="80,*" framespacing="0px" frameborder="no">
	<frame name="top" src="frame/top.jsp" scrolling="no">
	<frameset id="main" cols="170,9,*" framespacing="0px" frameborder="no" >
		<frameset framespacing="0px" frameborder="no">
			<frame src="frame/left.jsp" frameborder="no">
		</frameset>
		<frame src="frame/left.jsp"> 
		<frame name="right" src="frame/right.html">
	</frameset>
</frameset>
</html>
