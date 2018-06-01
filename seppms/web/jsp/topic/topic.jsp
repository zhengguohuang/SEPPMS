<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>交流讨论</title>

    <link rel="shortcut icon" href="../../favicon.ico"> <link href="../../css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="../../css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <link href="../../css/animate.css" rel="stylesheet">
    <link href="../../css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content  animated fadeInRight blog">
        <div class="row">
            <%----------------------------------%>
                <c:forEach items="${list}" var="t">
                    <div class="ibox">
                        <div class="ibox-content">
                            <a href='<c:url value="/topic/topicDetail?tid=${t.id}"/> ' class="btn-link">
                                <h2>
                                    ${t.title}
                                </h2>
                            </a>
                            <div class="small m-b-xs">
                                <strong>${t.user.name}</strong> <span class="text-muted"><i class="fa fa-clock-o"></i> ${t.createTime}</span>
                            </div>
                            <p>
                                ${t.content}
                            </p>
                            <div class="row">
                                <div class="col-md-6">
                                    <h5>标签：</h5>
                                    <button class="btn btn-primary btn-xs" type="button">javaweb</button>
                                    <button class="btn btn-white btn-xs" type="button">java</button>
                                </div>
                                <div class="col-md-6">
                                    <div class="small text-right">
                                        <h5>状态：</h5>
                                        <div> <i class="fa fa-comments-o"> </i> ${t.replyCount} 评论 </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>

            <%--------------------------%>
                <a class="btn btn-primary btn-rounded btn-block" href=""><i class="fa fa-plus"></i> new一个Topic</a>
            </div>
        </div>

    <!-- 全局js -->
    <script src="../../js/jquery.min.js?v=2.1.4"></script>
    <script src="../../js/bootstrap.min.js?v=3.3.6"></script>

    <!-- 自定义js -->
    <script src="../../js/content.js?v=1.0.0"></script>


    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
    <!--统计代码，可删除-->

</body>

</html>
