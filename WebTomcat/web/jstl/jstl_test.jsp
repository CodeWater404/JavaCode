<%--
  Created by IntelliJ IDEA.
  User: 十二书生
  Date: 2022/3/16
  Time: 13:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="el.domain.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>test</title>
</head>
<body>
    <%
        List list = new ArrayList();
        list.add( new User( "zhangsan" , 23 , new Date() ) );
        list.add( new User( "lisi" , 24 , new Date() ) );
        list.add( new User( "wangwu" , 25  , new Date() ) );
        
        request.setAttribute( "list" , list );
    %>

<%--    表格--%>
    <table border="1" width="500" align="center">
<%--        第一行--%>
        <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>生日</th>
        </tr>
<%--        数据行，s相当于变量了，user是遍历的对象--%>
        <c:forEach items="${list}" var="user" varStatus="s" >
<%--            交替显示红绿--%>
            <c:if test="${s.count % 2 != 0 }">
                <tr bgcolor="red">
                    <%--第几个，实际就是遍历了多少个--%>
                    <td>${s.count}</td>
                    <td>${user.name}</td>
                    <td>${user.age}</td>
                    <td>${user.birStr}</td>
                </tr>
            </c:if>
            <c:if test="${s.count % 2 == 0}">
                <tr bgcolor="green">
                    <td>${s.count}</td>
                    <td>${user.name}}</td>
                    <td>${user.age}</td>
                    <td>${user.birStr}</td>
                </tr>
            </c:if>
        </c:forEach>
    </table>
</body>
</html>
