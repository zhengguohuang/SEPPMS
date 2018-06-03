<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>SEPPMS - 空白页</title>
    <meta name="keywords" content="软件工程,管理系统,软件工程过程实践,软件工程过程实践管理系统,SEPPMS,Software engineering process practice management system">
    <meta name="description" content="软件工程实践过程管理系统, 软件工程实践课程设计">

    <link rel="shortcut icon" href="../favicon.ico"> <link href="../css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="../css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <link href="../css/animate.css" rel="stylesheet">
    <link href="../css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
    <div class="row wrapper border-bottom white-bg page-heading">
        <div class="col-sm-4">
            <h2>主页</h2>
            <ol class="breadcrumb">
                <li>
                    <a href='<c:url value="/empty"/> '>主页</a>
                </li>
                <%--<li>--%>
                    <%--<strong>包屑导航</strong>--%>
                <%--</li>--%>
            </ol>
        </div>
        <div class="col-sm-8">
            <div class="title-action">
                <a href="empty_page.jsp" class="btn btn-primary">活动区域</a>
            </div>
        </div>
    </div>

    <div class="wrapper wrapper-content">
        <div class="row">
            <div class="col-sm-12">
                <div class="middle-box text-center animated fadeInRightBig">
                    <h3 class="font-bold">欢迎使用软件工程过程管理系统</h3>

                    <div class="error-desc">
                        首次进入您可以加入小组或创建新的小组，在此之前您可以完善个人信息
                        <br/><a href='<c:url value="/user/profile"/> ' class="btn btn-primary m-t">完善信息</a>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- 全局js -->
    <script src="../js/jquery.min.js?v=2.1.4"></script>
    <script src="../js/bootstrap.min.js?v=3.3.6"></script>

    <!-- 自定义js -->
    <script src="../js/content.js?v=1.0.0"></script>


</body>

</html>
