<%--
  Created by IntelliJ IDEA.
  User: 十二书生
  Date: 2022/4/10
  Time: 22:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>首页</h1>
    <%--这里是jsp页面，所以动态获取路径不用tjymeleaf的th：--%>
    <a href="${pageContext.request.contextPath}/success">success.jsp</a>

</body>
</html>
