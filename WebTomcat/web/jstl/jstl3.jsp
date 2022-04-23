<%--
  Created by IntelliJ IDEA.
  User: 十二书生
  Date: 2022/3/16
  Time: 13:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>froeach标签</title>
</head>
<body>
<%--

foreach:相当于java代码的for语句
    1. 完成重复的操作
        for(int i = 0; i < 10; i ++){
        }
        * 属性：
            begin：开始值
            end：结束值
            var：临时变量
            step：步长
            varStatus:循环状态对象
                index:容器中元素的索引，从0开始
                count:循环次数，从1开始
    2. 遍历容器
        List<User> list;
        for(User user : list){
        }
        * 属性：
            items:容器对象
            var:容器中元素的临时变量
            varStatus:循环状态对象
                index:容器中元素的索引，从0开始
                count:循环次数，从1开始
--%>
<c:forEach begin="1" end="10" var="i" step="2" varStatus="s">
    <%--i是数字  s.index是下标   s.count是遍历了多少个数字--%>
    ${i} <h3>${ s.index}</h3> <h4> ${s.count}</h4> <br/>
</c:forEach>

<hr>

<%
    List list = new ArrayList();
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
//        设置list到域中去；下面就可以遍历list
    request.setAttribute("list", list);
%>

<c:forEach items="${list}" var="str" varStatus="s">
    <%--        str是元素的内容--%>
    ${ s.index }${s.count} ${str} <br/>
</c:forEach>
</body>
</html>
