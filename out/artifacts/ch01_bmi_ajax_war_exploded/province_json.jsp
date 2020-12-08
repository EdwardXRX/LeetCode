<%--
  Created by IntelliJ IDEA.
  User: EdwardX
  Date: 2020/11/4
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>使用JSON传值</title>
    <script type="text/javascript">
        function doAjax() {
            var xmlHttp = new XMLHttpRequest();
            xmlHttp.onreadystatechange = function () {
                alert("readystates:"+xmlHttp.readyState+"status"+xmlHttp.status);

                if(xmlHttp.readyState==4 && xmlHttp.status==200)
                {
                   var respText = xmlHttp.responseText;
                   var json = eval("("+respText+")");
                   callback(json);
                }

            }

            var id =document.getElementById("proId").value;
            xmlHttp.open("get", "findProvinceByJson?id=" +id ,false);
            //发送 ajax 异步请求
            xmlHttp.send();

        }

        function callback(json)
        {
            document.getElementById("proId").value = json.id;
            document.getElementById("name").value = json.name;
            document.getElementById("jiancheng").value = json.jiancheng;
            document.getElementById("shenghui").value = json.shenghui;
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
                <td><input type="text" id="name" ></td>
            </tr>
            <tr>
                <td>省份简称：</td>
                <td><input type="text" id="jiancheng"></td>
            </tr>
            <tr>
                <td>省份城市：</td>
                <td><input type="text" id="shenghui"></td>
            </tr>
        </table>
    </div>
</center>

</body>
</html>
