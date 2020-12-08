<%--
  Created by IntelliJ IDEA.
  User: EdwardX
  Date: 2020/10/29
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!--
http://localhost:8080/myWeb/request.jsp?userId=aaaaaa&password=123
-->
<%
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
%>

userId = <%=userId%>
password = <%=password%>
