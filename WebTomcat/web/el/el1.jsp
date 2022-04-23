<%--
  Created by IntelliJ IDEA.
  User: 十二书生
  Date: 2022/3/16
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${ 3 > 4}
\${ 3 > 4}
<hr>
<h3> 算术运算符</h3>
${ 3 + 4 }<br/>
${ 3 / 4 } <br/>
${ 3 mod 4} <br/>
${ 3 div 4} <br/>
<h3>逻辑运算符</h3>
${ 3 > 4 && 3 < 4 }<br/>
${ 3 > 4 and 3 < 4 }<br/>

<h4>empty运算符</h4>
<%
    String str = "";
    request.setAttribute("str", str);
    List list = new ArrayList();
    request.setAttribute("list", list);
%>

${ not empty str}
${ not empty list}
</body>
</html>
