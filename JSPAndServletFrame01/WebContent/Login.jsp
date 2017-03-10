<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

   <script type="text/javascript">
      function selflog_show(id)
      { 
         var num =  document.getElementById("number").value; 
         J.dialog.get({id: 'haoyue_creat',title: '购物成功',width: 600,height:400, link: '<%=path%>/servlet/UserServlet?username='+username+'&password='+password+'&action=Login', cover:true});
      }

     
    </script>

</head>

<body>
  <td width="70%" valign="top">
	<form action="<%=request.getContextPath()%>/servlet/UserServlet" method="post">
			<p class="user">
				<label>用户名: </label>
				<input name="username" value=""/> 
				<label>密码: </label>
				<input  name="password" value="">	
				<input  name="action" value="Login">	
			</p>
	 
			<p class="space">
				<input type="submit" value="登录" class="Login" style="cursor: pointer;"/>
			</p>
	</form>
    </td>
	
	
	<dt>
     	<a href="index.jsp" width="120" height="90" border="1"/>返回主页</a>
   	</dt>
	
</body>
</html>