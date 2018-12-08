<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>海文 在线短信平台</title>
<link type="text/css" rel="stylesheet" href="css/sms.css" />
</head>

<body>
	<div id="regTitle" class="png"></div>
	<div id="regForm" class="userForm png">

		<form action="${pageContext.request.contextPath}/user.do?param=doRegister" method="post">
			<dl>
				<div id="error">错误信息</div>
				<dt>用 户 名：</dt>
				<dd>
					<input type="text" name="name" />
				</dd>
				<dt>密 码：</dt>
				<dd>
					<input type="password" name="pwd" />
				</dd>
				<dt>确认密码：</dt>
				<dd>
					<input type="password" name="affirm" />
				</dd>
				<dt>邮 箱：</dt>
				<dd>
					<input type="text" name="email" />
				</dd>
			</dl>
			<div class="buttons">
				<input class="btn-reg png" type="submit" name="register" value=" " /><input
					class="btn-reset png" type="reset" name="reset" value=" " />
			</div>
			<div class="goback">
				<a href="index.jsp" class="png">返回登录页</a>
			</div>
		</form>
	</div>
</body>
</html>
