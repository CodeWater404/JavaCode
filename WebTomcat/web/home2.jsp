<%--
  Created by IntelliJ IDEA.
  User: 十二书生
  Date: 2022/3/16
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="top.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <% System.out.println( "hi~~~~~~" );
    %>

    <% pageContext.setAttribute( "msg" , "hello" );
    %>

    <%= pageContext.getAttribute( "msg" ) %>
</body>
</html>
