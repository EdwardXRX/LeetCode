<%@ page import="com.bjpowernode.controller.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: EdwardX
  Date: 2020/10/29
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%List<Student> list = (List)request.getAttribute("key");%>

<%
    for (Student stu:list) {
        %>

    ID:<%=stu.getId()%>
    name:<%=stu.getName()%>

<%
    }
%>