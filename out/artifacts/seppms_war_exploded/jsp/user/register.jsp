<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>软件工程实践过程管理系统 - 注册</title>
    <meta name="keywords" content="软件工程,管理系统,软件工程过程实践,软件工程过程实践管理系统,SEPPMS,Software engineering process practice management system">
    <meta name="description" content="软件工程实践过程管理系统, 软件工程实践课程设计">

    <link rel="shortcut icon" href="../../favicon.ico"> <link href="../../css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="../../css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="../../css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="../../css/animate.css" rel="stylesheet">
    <link href="../../css/style.css?v=4.1.0" rel="stylesheet">
    <script>if(window.top !== window.self){ window.top.location = window.location;}</script>

</head>

<body class="gray-bg">

    <div class="middle-box text-center loginscreen   animated fadeInDown">
        <div>
            <div>

                <h1 class="logo-name">SEPPMS</h1>

            </div>
            <h3>欢迎注册 SEPPMS</h3>
            <p>创建一个新账户</p>
            <form class="m-t" role="form" action="/doReg" method="post">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="请输入学号" name="number" required="">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="请输入姓名" name="name" required="">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="请输入邮箱" name="email" required="">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" placeholder="请输入密码" name="password" required="">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" placeholder="请再次输入密码" required="">
                </div>
                <!--学号、姓名、性别、班级、专业特长、爱好等基本信息。-->
                
                
                <div class="form-group text-left">
                    <div class="checkbox i-checks">
                        <label class="no-padding">
                            <input type="checkbox"><i></i> 我同意注册协议</label>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary block full-width m-b">注 册</button>

                <p class="text-muted text-center"><small>已经有账户了？</small><a href='<c:url value="/" />'>点此登录</a>
                </p>

            </form>
        </div>
    </div>

    <!-- 全局js -->
    <script src="../../js/jquery.min.js?v=2.1.4"></script>
    <script src="../../js/bootstrap.min.js?v=3.3.6"></script>
    <!-- iCheck -->
    <script src="../../js/plugins/iCheck/icheck.min.js"></script>
    <script>
        $(document).ready(function () {
            $('.i-checks').iCheck({
                checkboxClass: 'icheckbox_square-green',
                radioClass: 'iradio_square-green',
            });
        });
    </script>


</body>

</html>
