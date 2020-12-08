<%@ page import="com.bjpowernode.entity.Questions" %>
<%@ page import="java.util.List" %>
<%@ page import="com.bjpowernode.entity.Users" %><%--
  Created by IntelliJ IDEA.
  User: EdwardX
  Date: 2020/10/31
  Time: 8:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>question_find</title>
</head>
<body>
<%
        List<Questions> questionsList = (List)request.getAttribute("questionsList");
%>
            <center>
                <table border="2">
                    <tr>
                        <td>题目编号：</td>
                        <td>题目内容：</td>
                        <td>选项A：</td>
                        <td>选项B：</td>
                        <td>选项C：</td>
                        <td>选项D：</td>
                        <td>正确答案：</td>
                        <td colspan="2">操作 </td>
                    </tr>
                    <%
                        for (Questions questions : questionsList)
                        {

                        %>
                        <tr>
                            <td><%=questions.getQuestionId()%></td>
                            <td><%=questions.getTitle()%></td>
                            <td><%=questions.getOptionA()%></td>
                            <td><%=questions.getOptionB()%></td>
                            <td><%=questions.getOptionC()%></td>
                            <td><%=questions.getOptionD()%></td>
                            <td><%=questions.getAnswer()%></td>
                            <td><a href='/myWeb/Question/delete?questionId=<%=questions.getQuestionId()%>'>删除题目</a></td>
                            <td><a href='/myWeb/Question/oneInfo?questionId=<%=questions.getQuestionId()%>'>题目详情</a></td>
                        </tr>
                    <%
                        }
                    %>
                </table>
            </center>
</body>
</html>
