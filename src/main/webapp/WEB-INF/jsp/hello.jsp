<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/10
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8">
    <title>SpringMVCHelloWorld</title>
</head>
<body>
<h2>emp:${emp}</h2>
<h2>JSESSIONID:${JSESSIONID}</h2>
<h2>date:${date}</h2>
<h2>emp1:${sessionScope.emp1.emp_name}</h2>
<table cellpadding="10" cellspacing="0" border="1">
    <tr>
        <th>员工ID</th>
        <th>员工姓名</th>
        <th>员工性别</th>
        <th>家庭住址</th>

    </tr>
    <c:forEach var="emp1" items="${ok}">
        <tr>
            <th>${emp1.emp_id}</th>
            <th>${emp1.emp_name}</th>
            <th>${emp1.sex}</th>
            <th>${emp1.address}</th>
        </tr>
    </c:forEach>

</table>


</body>
</html>
