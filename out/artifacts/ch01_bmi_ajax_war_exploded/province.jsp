<%--
  Created by IntelliJ IDEA.
  User: EdwardX
  Date: 2020/11/3
  Time: 22:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>省份查询</title>
    <script type="text/javascript">
        function doAjax() {
            var xmlHttp = new XMLHttpRequest();
            xmlHttp.onreadystatechange = function () {
                if(xmlHttp.readyState==4 && xmlHttp.status==200)
                {
                    var name = xmlHttp.responseText;
                    if (xmlHttp.responseText.trim().length ==8)
                    {
                        alert("无此编号省份！");
                        document.getElementById("proName").value = "";
                    }
                    else
                    {
                        alert(name.length);
                        alert(name);
                        document.getElementById("proName").value=xmlHttp.responseText;
                    }

                }
            }

            var id =document.getElementById("proId").value;
            xmlHttp.open("get", "findProvince?id=" +id ,true);
            //发送 ajax 异步请求
            xmlHttp.send();

        }

    </script>
</head>
<body>
<center>
    <div  >
        <table border="1">
            <tr>
                <td>省份编号：</td>
                <td><input type="text" id="proId" ></td>
                <td><input type="button" value="搜索" onclick="doAjax()"></td>
            </tr>
            <tr>
                <td>省份名字：</td>
                <td><input type="text" id="proName" ></td>
            </tr>
            <tr>
                <td>省份简称：</td>
                <td><input type="text" id="proJiancheng"></td>
            </tr>
        </table>
    </div>
</center>
</body>
</html>
