<%--
  Created by IntelliJ IDEA.
  User: java
  Date: 2018/1/2
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8">
    <title>Title</title>
</head>
<body>

        <form:form action="${pageContext.request.contextPath}/danmu/login" method="post" modelAttribute="user">
            <form:input path="username"></form:input>
            <form:input path="password"></form:input>
            <input type="text" name="roomNum">
            <button id="login">登陆</button>
        </form:form>

</body>
</html>
