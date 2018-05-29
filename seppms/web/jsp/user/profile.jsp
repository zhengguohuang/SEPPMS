<%--
  Created by IntelliJ IDEA.
  User: zhengguohuang
  Date: 2018/5/29
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="utf-8">
    <title>个人资料</title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="../../css/base.css" rel="stylesheet">
    <link href="../../css/index.css" rel="stylesheet">
    <link href="../../css/m.css" rel="stylesheet">
    <link rel="shortcut icon" href="../../favicon.ico"> <link href="../../css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="../../css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <link href="../../css/animate.css" rel="stylesheet">
    <link href="../../css/style.css?v=4.1.0" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="../../js/modernizr.js"></script>
    <![endif]-->
    <script>
        window.onload = function ()
        {
            var oH2 = document.getElementsByTagName("h2")[0];
            var oUl = document.getElementsByTagName("ul")[0];
            oH2.onclick = function ()
            {
                var style = oUl.style;
                style.display = style.display == "block" ? "none" : "block";
                oH2.className = style.display == "block" ? "open" : ""
            }
        }
    </script>
</head>
<body>
    <div class="">
        <div class="aboutme">
            <h2 class="hometitle">关于我</h2>
            <div class="avatar"> <img src="${user.avatar}"> </div>
            <div class="ab_con">
                <p>学号：${user.number}</p>
                <p>姓名：${user.name}</p>
                <p>班级：${user.className}</p>
                <p>email：${user.email}</p>
                <p>专长：${user.specialty}</p>
                <p>hobby：${user.hobby}</p>
                <p type="date">创建时间：${user.createTime}</p>
                <button class="btn btn-info " type="button"><i class="fa fa-paste"></i> 编辑</button>
            </div>
        </div>
    </div>
</body>
</html>
