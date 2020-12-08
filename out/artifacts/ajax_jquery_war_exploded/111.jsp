<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>省市级联查询</title>
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
        function loadDataAjax() {
            //做ajax请求，使用jquery的$.ajax()
            $.ajax({
                url:"findProvince",
                dataType:"json",
                success:function( resp ){
                    //删除旧的数据，把已经存在的数据清空
                    $("#province").empty();
                    //[{"id":1,"name":"河北","jiancheng":"冀","shenghui":"石家庄"},{}]
                    $.each( resp, function (i,n) {
                        //获取select这个dom对象
                        $("#province").append("<option value='"+n.id+ "'>" +  n.name + "</option>");
                    })
                }
            })
        }


        $(function(){
            //  $(function()）在页面的dom的对象加载成功后执行的函数， 在此发起ajax。
            loadDataAjax();

            //绑定事件
            $("#btnLoad").click(function(){
                loadDataAjax();
            })


            $("#province").on("change",function () {
                    var proId=$("#province>option:selected").val();
                    if (proId == "0")
                    {
                        alert("请输入一个有效省份")
                    }
                    else
                    {
                        $.post("findCity",{proId:proId},callback,"json");
                    }
            })


        })


        //定义一个处理返回数据的函数
        function callback(resp){
            //清空select列表
            $("#city").empty();
            $("#city").append("<option value='0'>请选择。。。</option> ");
            $.each( resp, function(i,n){
                $("#city").append("<option value='"+n.id+"'>"+n.name+"</option>")
            })
        }

    </script>
</head>
<body>
<p>省市级联查询,使用ajax</p>
<div>
    <table border="1" cellpadding="0" cellspacing="0">
        <tr>
            <td>
                省份：
            </td>
            <td>
                <select id="province">
                    <option value="0">请选择.....</option>
                </select>
                <!--<input type="button" value="load数据" id="btnLoad" />-->
            </td>

        </tr>
        <tr>
            <td>城市：</td>
            <td>
                <select id="city">
                    <option value="0">请选择.....</option>
                </select>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
