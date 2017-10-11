<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8">
</head>
<body>
<h2>Hello World!</h2>

    <a href="${pageContext.request.contextPath}/HelloWorld/123/234/hello/235?id=111&name=jack">点这儿</a><br>
    <a href="${pageContext.request.contextPath}/HelloWorld/scopeTest">scopeTest点这儿</a><br>
    <a href="${pageContext.request.contextPath}/HelloWorld/forward">有不懂的点我</a><br>
    <a href="${pageContext.request.contextPath}/HelloWorld/add">点我新增员工</a><br>


</body>
</html>
