<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<title>海文在线短信平台</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/sms.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/alertify.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/alertify.js"></script>
<script type="text/javascript">
/* ${pageContext.request.contextPath}/msg.do?param=delete  */
   function del(id){
     alertify.confirm('删除信息', '是否确定删除?', 
        function(){ 
             window.location="${pageContext.request.contextPath}/msg.do?param=delete&id="+id;
        }
     , function(){ 
         alertify.error('取消操作')
       }).set('modal', false);
     
   }
</script>
</head>
<body>
	<div id="main">
		<div class="mainbox">
			<div class="title myMessage png"></div>
			 <%@include file="menu.jsp" %>
			<!--错误信息  -->
			<div id="error"></div>
			<!--短消息列表  -->
			<div class="content messageList">
			  <ul>
			  <c:forEach items="${requestScope.msgList}" var="msg">
			  
			    <li class="${msg.state==1?'unReaded':''}">
			       <em>${msg.msg_create_date }</em>
			       <em><a href="">回信</a></em>
			       <em><a href="javascript:del(${msg.id})">删除</a></em>
			       
			       <p>
			          <strong>${msg.title }</strong>
			          <a href="msg.do?param=showmsgbyid&id=${msg.id}">
						  <c:choose>
							<c:when test="${fn:length(msg.msgcontent)>8}">
							  ${fn:substring(msg.msgcontent,0,8) }...
							</c:when>
							<c:otherwise>
							  ${msg.msgcontent}
							</c:otherwise>
						  </c:choose>
					  </a>
			       </p>
			       
			    </li>
			    </c:forEach>
			  </ul>
			</div>
			<!--分页栏 -->
			<div align="center" style="margin-top:10px">
				 <a href="#">首页</a>&nbsp;&nbsp;&nbsp;
			     <a href="#">上一页</a>&nbsp;&nbsp;
			     <a href="#">下一页</a>&nbsp;&nbsp;
				 3/10&nbsp;&nbsp;
				 <a href="#">最后一页</a>
			</div>
		</div>
	</div>
</body>
</html>
