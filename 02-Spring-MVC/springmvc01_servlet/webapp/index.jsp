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
<form action="${pageContext.request.contextPath}/hello" method="post" >
    方法类型：<input name="method" type="text" ><br>
    <input type="submit">
</form>
</body>
</html>
