<%--
  Created by IntelliJ IDEA.
  User: 十二书生
  Date: 2022/3/16
  Time: 12:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el获取域中的数据</title>
</head>
<body>
    <% 
    session.setAttribute( "name" , "李四" );
    request.setAttribute( "name" , "张三" );
    session.setAttribute( "age" , "23" );
    
    request.setAttribute( "str" , "" );
    %>
    
    <h3>el获取值</h3>

    ${requestScope.name}
    ${sessionScope.age}
    ${sessionScope.haha}
    ${name}
    ${sessionScope.name}
</body>
</html>
