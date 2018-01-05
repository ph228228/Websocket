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
    <script type="text/javascript" src="/js/jquery-3.1.0.min.js"></script>
    <script type="text/javascript">
        $(function () {

            $(".del").click(function () {
                medium("delete",this.href);
                return false;
            });
            $(".edit").click(function () {
                medium("put",this.href);
                return false;
            });
        });
        function medium(param,url) {
            $("#for").attr("action",url);
            $("#medium").val(param);
            $("#for").submit();
            return false;
        }
    </script>

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
        <th>年龄</th>
        <th>工资</th>
        <th>部门</th>
        <th>DELETE</th>
        <th>EDIT</th>
    </tr>

    <c:forEach var="emp1" items="${ok}">
        <tr>
            <th>${emp1.emp_id}</th>
            <th>${emp1.emp_name}</th>
            <th>${emp1.sex}</th>
            <th>${emp1.address}</th>
            <th>${emp1.age}</th>
            <th>${emp1.salary}</th>
            <th>${emp1.dept.dept_name}</th>
            <th><a href="/HelloWorld/delEmp/${emp1.emp_id}" class="del">DELETE</a></th>
            <th><a href="/HelloWorld/editPrepare/${emp1.emp_id}" class="edit">EDIT</a></th>
        </tr>
    </c:forEach>
    <form method="post" action="" id="for">
        <input type="hidden" name="_method" value="" id="medium">
    </form>
</table>


</body>
</html>
