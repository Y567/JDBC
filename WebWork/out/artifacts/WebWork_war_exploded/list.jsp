<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/4
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>玩家信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
    <script>
        function deleteUser(id){
            //防止用户误删，进行确认
            if(confirm("您确定要删除吗？")){
                //确定要删除
                location.href = "${pageContext.request.contextPath}/deleteUserServlet?id="+id;
            }
        }
    </script>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">玩家信息列表</h3>
    <div style="float: left;margin: 6px;">
        <form class="form-inline">
            <div class="form-group">
                <label for="exampleInputName2">玩家</label>
                <input type="text" class="form-control" id="exampleInputName2">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail2">性别</label>
                <input type="text" class="form-control" id="exampleInputEmail2">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail3">生日</label>
                <input type="date" class="form-control" id="exampleInputEmail3">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>
    </div>
    <div style="float:right;margin: 6px">
        <td colspan="8" align="center"><a class="btn btn-primary" href="add.jsp">添加玩家</a></td>
        <td colspan="8" align="center"><a class="btn btn-primary" href="add.jsp">删除</a></td>
    </div>
    <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th><input type="checkbox"></th>
            <th>编号</th>
            <th>玩家</th>
            <th>性别</th>
            <th>邮箱</th>
            <th>生日</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${user}" var="users" varStatus="s">
            <tr>
                <td><input type="checkbox"></td>
                <td>${s.count}</td>
                <td>${users.username}</td>
                <td>${users.gender}</td>
                <td>${users.username}</td>
                <td>${users.birthday}</td>
                <td><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/findUserServlet?id=${users.id}">修改</a>&nbsp;<a class="btn btn-default btn-sm" onclick="deleteUser(${users.id})" href="">删除</a></td>
            </tr>
        </c:forEach>
    </table>
    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li>
                    <a href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <li><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li>
                    <a href="#" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </ul>
        </nav>
    </div>
    <span style="margin: 5px;font-size: 15px">
                    阿狗sfwefhewif
    </span>
</div>

</body>
</html>
