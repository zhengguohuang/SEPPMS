<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>SEPPMS -修改密码</title>

    <meta name="keywords" content="软件工程,管理系统,软件工程过程实践,软件工程过程实践管理系统,SEPPMS,Software engineering process practice management system">
    <meta name="description" content="软件工程实践过程管理系统, 软件工程实践课程设计">

    <link rel="shortcut icon" href="../../favicon.ico"> <link href="../../css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="../../css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="../../css/animate.css" rel="stylesheet">
    <link href="../../css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <%--<div class="col-sm-6">--%>
        <div class="">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>第三步</h5>
                </div>
                <div class="ibox-content">
                    <form class="form-horizontal m-t" id="commentForm" action="/user/doForgetPassword">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">请输入新密码：</label>
                            <div class="col-sm-8">
                                <input  name="password" minlength="2" type="password" class="form-control"  aria-required="true" >
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">再次输入新密码：</label>
                            <div class="col-sm-8">
                                <input  name="password2" minlength="2" type="password" class="form-control"  aria-required="true" >

                            </div>
                        </div>
                        <input  name="number" value="${user.number}" minlength="2" type="hidden" class="form-control"  aria-required="true" >
                        <div class="form-group">
                            <div class="col-sm-4 col-sm-offset-3">
                                <button class="btn btn-primary" type="submit">确定</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>


<!-- 全局js -->
<script src="../../js/jquery.min.js?v=2.1.4"></script>
<script src="../../js/bootstrap.min.js?v=3.3.6"></script>

<!-- 自定义js -->
<script src="../../js/content.js?v=1.0.0"></script>

<!-- jQuery Validation plugin javascript-->
<script src="../../js/plugins/validate/jquery.validate.min.js"></script>
<script src="../../js/plugins/validate/messages_zh.min.js"></script>

<script src="../../js/demo/form-validate-demo.js"></script>

</body>

</html>
