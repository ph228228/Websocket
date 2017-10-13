<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/13
  Time: 18:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>人物添加</title>
</head>
<body>
<form:form action="${pageContext.request.contextPath}/HelloWorld/updateEmp" method="post" id="form1"
           modelAttribute="person">

    <input type="hidden" name="emp_id" value="${emp.emp_id}">
    姓名:<form:input path="emp_name"></form:input><br>
    <c:choose>
        <c:when test="${emp.emp_id == null}">
            性别:<form:radiobutton path="sex" value="男"/>男&nbsp<form:radiobutton path="sex" value="女"/>女<br>
        </c:when>
        <c:otherwise>
            <input type="hidden" name="_method" value="put" id="medium">
        </c:otherwise>
    </c:choose>
    地址:<form:input path="address"></form:input><br>
    部门:<form:select path="dept.dept_id" items="${requestScope.depts}" itemLabel="dept_name"
                    itemValue="dept_id"></form:select>
    <input type="submit" id="sub"/>
</form:form>
</body>
</html>
