<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head></head>
<body>
<table border="0" width="600px">
<tr>
<td align="center" style="font-size:24px; color:#666"> 部门添加</td>
</tr>
<tr>
<td align="right" > 
<a href="javascript:document.getElementById('saveForm').submit()">保存</a> &nbsp;&nbsp;
<a href="javascript:history.go(-1)">退回 </a>
</td>
</tr>
</table>
<br/>
 <br>
 <s:form id="saveForm" action="department_save.action" method="post" namespace="/">
<table style="font-size::16px">
<tr>
  <td>部门名称：</td>
  <td><input type="text" name="dname"/></td>
</tr>
<tr>
  <td>部门介绍：</td>
  <td></td>
</tr>
<tr>
  <td width="10%"></td>
  <td>
     <textarea cols="50" rows="5" name="ddesc">ckeditor</textarea>
  </td>
</tr>
</table>
</s:form>
</body>
</html> 