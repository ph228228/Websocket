<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/11
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8">
    <title>添加</title>
</head>
<body>
<form:form action="${pageContext.request.contextPath}/HelloWorld/insertEmp" method="post" modelAttribute="emp">
    姓名:<form:input path="emp_name"></form:input><br>
    性别:<form:radiobutton path="sex" value="男" />男&nbsp<form:radiobutton path="sex" value="女" />女<br>

    地址:<form:input path="address"></form:input><br>
    部门号:<form:input path="dept.dept_id"></form:input><br>
    <input type="submit" />
</form:form>
</body>
</html>
