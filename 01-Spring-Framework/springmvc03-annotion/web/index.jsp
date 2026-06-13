<%--
  Created by IntelliJ IDEA.
  User: 夜林蓝
  Date: 2022/11/8
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>INDEX</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/hello">
    转发【welcome】
</a><br>
<a href="${pageContext.request.contextPath}/forward">
    显示转发【forward:/forward.jsp】
</a><br>
<a href="${pageContext.request.contextPath}/redirect">
    显示重定向【redirect:/redirect.jsp】
</a>
<hr>
<a href="${pageContext.request.contextPath}/user/name?username=张三">
    获取名字
</a><br>
<a href="${pageContext.request.contextPath}/user/add?name=张三&id=1&pwd=123">
    添加用户
</a><br>
<form method="post" action="${pageContext.request.contextPath}/encoding/str">
    输入中文：<input type="text" name="str"><br>
    <input type="submit">
</form><br>
<hr/>
<a href="${pageContext.request.contextPath}/json/getUserJson">
    返回JSON串
</a><br>
</body>
</html>
