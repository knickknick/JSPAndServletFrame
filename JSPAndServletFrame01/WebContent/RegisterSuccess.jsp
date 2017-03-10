<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册成功界面</title>
</head>
<body>
	<t1>恭喜您，注册成功！您的用户名是：<%=request.getParameter("username") %></t1>
	<dt>
    	<a href="<%=request.getContextPath()%>/index.jsp" width="120" height="90" border="1"/>返回主页</a>
   	</dt>
</body>
</html>