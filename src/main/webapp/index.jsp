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
    <a href="${pageContext.request.contextPath}/upup/download">点我下载你懂得</a><br>
    <form action="${pageContext.request.contextPath}/upup/upload" method="POST" enctype="multipart/form-data">
        file:<input type="file" name="upload"/><br>
        msg:<input type="text" name="desc">
        <input type="submit">
    </form>
    <a href="${pageContext.request.contextPath}/danmu/socket">socket测试</a><br>

    <a href="${pageContext.request.contextPath}/danmu/loginPrepare">登陆</a>
</body>
</html>
