<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/12
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8">
    <title>修改信息</title>

</head>
<body>
<form:form action="${pageContext.request.contextPath}/HelloWorld/updateEmp" method="post" id="form1"
           modelAttribute="emp">

    <input type="hidden" name="emp_id" value="${emp.emp_id}">
    姓名:<form:input path="emp_name"></form:input><form:errors path="emp_name"/><br>
    <c:choose>
        <c:when test="${emp.emp_id == null}">
            性别:<form:radiobutton path="sex" value="男"/>男&nbsp<form:radiobutton path="sex" value="女"/>女<br>
        </c:when>
        <c:otherwise>
            <input type="hidden" name="_method" value="put" id="medium">
        </c:otherwise>
    </c:choose>
    年龄:<form:input path="age"></form:input><form:errors path="age"/><br>
    工资:<form:input path="salary"></form:input><form:errors path="salary"/><br>
    地址:<form:input path="address"></form:input><br>
    部门:<form:select path="dept.dept_id" items="${requestScope.depts}" itemLabel="dept_name"
                    itemValue="dept_id"></form:select>
    <input type="submit" id="sub"/>
</form:form>

</body>
</html>
