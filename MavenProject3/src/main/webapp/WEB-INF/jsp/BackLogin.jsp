<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title></title>
  <style type="text/css">
  *{margin:0;padding:0;}
  input{margin:18px;}
.content{
       width:500px;
       margin:100px auto;
       
       }
    hr{color:#ccc;}
    p{text-align:center;color:#ccc;}

</style>
</head>
<body>
  <div class="content">
	    <h2>------------- 后台管理系统  -------------</h2>
	
		<form action="${pageContext.request.contextPath }/doBackLogin" method="post">
		<input type="text" name="userCode" id="Username" placeholder="Username"  required="" style="width:400px;height:30px;"><br />
		<input type="password" name="userPassword" id="Password" placeholder="Password" required="" style="width:400px;height:30px;"><br />
			<input type="submit" value="登录" style="margin-left:140px;width:50px;height:30px;background:#ccc;">
			<input type="submit" value="重填" style="margin-left:20px;width:50px;height:30px;"><br/><hr/><br/>

		</form>
		<p>&copy2016 All Rights Reserved</p>
		
  </div>
  
</body>
</html>
