<%--
  Created by IntelliJ IDEA.
  User: EdwardX
  Date: 2020/10/30
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

        <%
        String info = (String)request.getAttribute("info");
        %>
        <center>
            <font color="red" size="45"><%=info%></font>
        </center>
</body>
</html>
