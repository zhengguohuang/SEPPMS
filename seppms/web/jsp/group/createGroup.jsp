<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>创建小组</title>

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
                        <h5>创建小组</h5>
                    </div>
                    <div class="ibox-content">
                        <form class="form-horizontal m-t" id="commentForm" action="/group/doCreateGroup">
                            <div class="form-group">
                                <label class="col-sm-3 control-label">小组名：</label>
                                <div class="col-sm-8">
                                    <input id="cname" name="name" minlength="2" type="text" class="form-control" required="" aria-required="true" value="${user.name}">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">指导老师：</label>
                                <div class="col-sm-8">
                                    <select name="teacherid" data-placeholder="选择指导..." class="chosen-select" style="width:350px;" tabindex="2">
                                        <option value="">请选择指导老师</option>
                                        <c:forEach items="${teachers}" var="t">
                                            <option value="${t.user.id}" hassubinfo="true">${t.user.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>


                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-3">
                                    <button class="btn btn-primary" type="submit">提交</button>
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
