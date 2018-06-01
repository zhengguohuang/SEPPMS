<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>Topic 详情</title>

    <link rel="shortcut icon" href="../../favicon.ico"> <link href="../../css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="../../css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <link href="../../css/animate.css" rel="stylesheet">
    <link href="../../css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content  animated fadeInRight article">
        <div class="row">
            <div class="col-lg-10 col-lg-offset-1">
                <div class="ibox">
                    <div class="ibox-content">
                        <div class="text-center article-title">
                            <h1>
                                    ${topic.title}
                            </h1>
                        </div>
                        <p>${topic.content}</p>
                        <hr>

                        <div class="row">
                            <div class="col-lg-12">

                                <h2>评论：</h2>

                                <%-------------------%>
                                <c:forEach items="${replies}" var="r">
                                    <div class="social-feed-box">
                                        <div class="social-avatar">
                                            <a href="" class="pull-left">
                                                <img alt="image" src="${r.user.avatar}">
                                            </a>
                                            <div class="media-body">
                                                <a href="#">
                                                    ${r.user.name}
                                                </a>
                                                <small class="text-muted">${r.createTime}</small>
                                            </div>
                                        </div>
                                        <div class="social-body">
                                            <p>
                                                ${r.content}
                                            </p>
                                        </div>
                                    </div>
                                </c:forEach>
                                <%-------------------%>

                            </div>
                            <div class="col-lg-12">   </div>
                            <div class="chat-form col-lg-12">
                                <form role="form" action="/topic/reply">
                                    <input name="tid" type="hidden" value="${topic.id}"/>
                                    <div class="form-group">
                                        <textarea class="form-control" name="content" placeholder="发表评论…"></textarea>
                                    </div>
                                    <div class="text-right">
                                        <button type="submit" class="btn btn-sm btn-primary m-t-n-xs"><strong>评论</strong>
                                        </button>
                                    </div>
                                </form>
                            </div>
                        </div>
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

</body>

</html>
