<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>小组详情</title>

    <link rel="shortcut icon" href="../../favicon.ico"> <link href="../../css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="../../css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <link href="../../css/animate.css" rel="stylesheet">
    <link href="../../css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
    <div class="row">
        <div class="">
            <div class="wrapper wrapper-content animated fadeInUp">
                <div class="ibox">
                    <div class="ibox-content">
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="m-b-md">
                                    <h2>${group.name}</h2>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-5">
                                <dl class="dl-horizontal">

                                    <dt>组长：</dt>
                                    <dd>${group.leader.name}</dd>
                                    <dt>指导老师：</dt>
                                    <dd>${group.teacher.name}</dd>
                                    <dt>创建时间：</dt>
                                    <dd>${group.createTime}</dd>
                                </dl>
                            </div>
                            <div class="col-sm-7" id="cluster_info">
                                <dl class="dl-horizontal">
                                    <dt>状态：</dt>
                                    <dd>
                                    <c:if test="${'1' == group.status}">
                                        <span class="label label-primary">已确认</span>
                                    </c:if>
                                    <c:if test="${'1' != group.status}">
                                        <span class="label label-primary">未确认</span>
                                    </c:if>
                                </dd>
                                </dl>
                                <dl class="dl-horizontal">

                                    <dt>团队成员：</dt>
                                    <dd class="project-people">
                                        <%--------------%>
                                            <c:forEach items="${group.members}" var="m">
                                                <a href='<c:url value="/group/groupMemberDetail?mnumber=${m.number}"/> '>
                                                    <img alt="image" class="img-circle" src="${m.avatar}">
                                                </a>
                                            </c:forEach>
                                        <%--------------%>
                                    </dd>
                                </dl>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12">
                                <dl class="dl-horizontal">
                                    <dt>当前进度</dt>
                                    <dd>
                                        <div class="progress progress-striped active m-b-sm">
                                            <div style="width: 60%;" class="progress-bar"></div>
                                        </div>
                                        <small>当前已完成项目总进度的 <strong>60%</strong></small>
                                    </dd>
                                </dl>
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


    <script>
        $(document).ready(function () {

            $('#loading-example-btn').click(function () {
                btn = $(this);
                simpleLoad(btn, true)

                // Ajax example
                //                $.ajax().always(function () {
                //                    simpleLoad($(this), false)
                //                });

                simpleLoad(btn, false)
            });
        });

        function simpleLoad(btn, state) {
            if (state) {
                btn.children().addClass('fa-spin');
                btn.contents().last().replaceWith(" Loading");
            } else {
                setTimeout(function () {
                    btn.children().removeClass('fa-spin');
                    btn.contents().last().replaceWith(" Refresh");
                }, 2000);
            }
        }
    </script>


</body>

</html>
