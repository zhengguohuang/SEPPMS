<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>软件工程实践过程管理系统 - 小组</title>
    <meta name="keywords" content="软件工程,管理系统,软件工程过程实践,软件工程过程实践管理系统,SEPPMS,Software engineering process practice management system">
    <meta name="description" content="软件工程实践过程管理系统, 软件工程实践课程设计">

    <link rel="shortcut icon" href="../../favicon.ico"> <link href="../../css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="../../css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <link href="../../css/animate.css" rel="stylesheet">
    <link href="../../css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">

    <div class="wrapper wrapper-content animated fadeInUp">
        <div class="row">
            <div class="col-sm-12">

                <div class="ibox">
                    <div class="ibox-title">
                        <h5>所有小组</h5>
                        <div class="ibox-tools">
                            <a href="showGroups.html" class="btn btn-primary btn-xs">创建新组</a>
                        </div>
                    </div>
                    <div class="ibox-content">
                        <div class="row m-b-sm m-t-sm">
                            <div class="col-md-1">
                                <button type="button" id="loading-example-btn" class="btn btn-white btn-sm"><i class="fa fa-refresh"></i> 刷新</button>
                            </div>
                            <div class="col-md-11">
                                <div class="input-group">
                                    <input type="text" placeholder="请输入小组名称" class="input-sm form-control"> <span class="input-group-btn">
                                        <button type="button" class="btn btn-sm btn-primary"> 搜索</button> </span>
                                </div>
                            </div>
                        </div>

                        <div class="project-list">

                            <table class="table table-hover">
                                <tbody>

                                    <c:forEach items="${groups}" var="g">
                                        <tr>
                                            <td class="project-status">
                                                <c:if test="${'1' == g.status}">
                                                    <span class="label label-primary">已确认</span>
                                                </c:if>
                                                <c:if test="${'1' != g.status}">
                                                    <span class="label label-primary">未确认</span>
                                                </c:if>
                                            </td>
                                            <td class="project-title">
                                                <a href="groupDetail.jsp"><c:out value="${g.name}"/></a>
                                                <br/>
                                                <small>创建于 ${g.createTime}</small>
                                            </td>
                                            <td class="project-completion">
                                                <%--<small>截止时间： 2018.05.22</small>--%>
                                                <div class="progress progress-mini">
                                                    <div style="width: 50%;" class="progress-bar"></div>
                                                </div>
                                            </td>
                                            <td class="project-people">
                                                <c:forEach items="${g.members}" var="m">
                                                    <a href="showGroups.html"><img alt="image" class="img-circle" src="${m.avatar}"></a>
                                                </c:forEach>
                                            </td>
                                            <td class="project-actions">
                                                <a href='<c:url value="/group/groupDetail?gid=${g.id}"/> ' class="btn btn-white btn-sm"><i class="fa fa-search"></i> 查看详情 </a>
                                                <a href="showGroups.html#" class="btn btn-white btn-sm"><i class="fa fa-pencil"></i> 申请加入 </a>
                                            </td>
                                        </tr>
                                    </c:forEach>


                                    </tbody>
                                </table>
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
        $(document).ready(function(){

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
