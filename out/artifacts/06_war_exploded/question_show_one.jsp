<%@ page import="com.bjpowernode.entity.Questions" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: EdwardX
  Date: 2020/10/31
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>findById</title>
</head>
<body>
<%
    List list = (List) request.getAttribute("list");
    Questions oneQuestion = null;
    if(list.isEmpty())
    {
        oneQuestion = null;
    }
    else
    {
        oneQuestion = (Questions) list.get(0);
    }


%>
<center>
    <form action="update" method="get">
        <table border="2">
            <tr>
                <td>题目编号：</td>
                <td><input type="text" name="questionId" value="<%=(oneQuestion.getQuestionId())%>"></td>
            </tr>
            <tr>
                <td>题目内容：</td>
                <td><input type="text" name="title" value="<%=oneQuestion.getTitle()%>"></td>
            </tr>
            <tr>
                <td>选项A：</td>
                <td><input type="text" name="optionA" value="<%=oneQuestion.getOptionA()%>"></td>
            </tr>
            <tr>
                <td>选项B：</td>
                <td><input type="text" name="optionB" value="<%=oneQuestion.getOptionB()%>"></td>
            </tr>
            <tr>
                <td>选项C：</td>
                <td><input type="text" name="optionC" value="<%=oneQuestion.getOptionC()%>"></td>
            </tr>
            <tr>
                <td>选项D：</td>
                <td><input type="text" name="optionD" value="<%=oneQuestion.getOptionD()%>"></td>
            </tr>
            <tr>
                <td>答案：</td>
                <td><input type="text" name="answer" value="<%=oneQuestion.getAnswer()%>"></td>
            </tr>

            <tr>
                <td><input type="submit" value="提交"> </td>
                <td><input type="reset" value="重置"></td>
            </tr>
        </table>
    </form>

</center>

</body>
</html>
