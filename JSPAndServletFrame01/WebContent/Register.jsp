<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册界面</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/servlet/UserServlet" method="post">
			<p class="user">
				<label>用户名: </label>
				<input name="username" value=""/> 
				<label>密码: </label>
				<input  name="password" value="">	
				<label>邮箱: </label>
				<input  name="email" value="">	
				<label>电话号码: </label>
				<input  name="phonenumber" value="">
				<label></label>
				<input  name="action" value="Register">	
			</p>
	 
			<p class="space">
				<input type="submit" value="注册" class="Register" style="cursor: pointer;"/>
			</p>
	</form>
	
	<dt>
     	<a href="index.jsp" width="120" height="90" border="1"/>返回主页</a>
   	</dt>
	
</body>
</html>