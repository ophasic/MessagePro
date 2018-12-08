<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>读短消息</title>
<link type="text/css" rel="stylesheet" href="css/sms.css" />

</head>
<body>
	<div id="main">
		<div class="mainbox">
			<div class="title readMessage png"></div>
			<%@include file="menu.jsp" %>
			<div class="content">
				<div class="message">
					<div class="tmenu">
						<ul class="clearfix">
							<li>题目:${msg.title }</li>
							<li>来自:${msg.sendid }</li>
							<li>时间:${msg.msg_create_date }</li>
						</ul>
					</div>
					<div class="view">
						<p>${msg.msgcontent }</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
