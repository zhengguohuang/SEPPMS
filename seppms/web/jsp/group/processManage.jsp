<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8" language="java" %>
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
    <link rel="shortcut icon" href="../../favicon.ico"> <link href="../../css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="../../css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <link href="../../css/plugins/iCheck/custom.css" rel="stylesheet">

    <link href="../../css/plugins/chosen/chosen.css" rel="stylesheet">

    <link href="../../css/plugins/colorpicker/css/bootstrap-colorpicker.min.css" rel="stylesheet">

    <link href="../../css/plugins/cropper/cropper.min.css" rel="stylesheet">

    <link href="../../css/plugins/switchery/switchery.css" rel="stylesheet">

    <link href="../../css/plugins/jasny/jasny-bootstrap.min.css" rel="stylesheet">

    <link href="../../css/plugins/nouslider/jquery.nouislider.css" rel="stylesheet">

    <link href="../../css/plugins/datapicker/datepicker3.css" rel="stylesheet">


    <link href="../../css/plugins/ionRangeSlider/ion.rangeSlider.css" rel="stylesheet">
    <link href="../../css/plugins/ionRangeSlider/ion.rangeSlider.skinFlat.css" rel="stylesheet">

    <link href="../../css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet">

    <link href="../../css/plugins/clockpicker/clockpicker.css" rel="stylesheet">

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
                                    <dt>创建时间：</dt>
                                    <dd>${group.createTime}</dd>
                                </dl>
                            </div>
                            <div class="col-sm-7" id="cluster_info">
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


                        <%------------------%>

                        <div class="row">
                            <div class="col-sm-12">
                                <dl class="dl-horizontal">
                                    <div class="form-group" id="data_5">
                                        <dt class="dl-horizontal">需求分析：</dt>
                                        <dd>
                                            <div class="input-daterange input-group" id="datepicker">
                                                <input type="text" class="input-sm form-control" name="start" value="2018-6-1" />
                                                <span class="input-group-addon">到</span>
                                                <input type="text" class="input-sm form-control" name="end" value="2018-6-3" />
                                            </div>
                                        </dd>
                                        <dt class="dl-horizontal">总体设计：</dt>
                                        <dd>
                                            <div class="input-daterange input-group" id="datepicker">
                                                <input type="text" class="input-sm form-control" name="start" value="2018-6-1" />
                                                <span class="input-group-addon">到</span>
                                                <input type="text" class="input-sm form-control" name="end" value="2018-6-3" />
                                            </div>
                                        </dd>
                                        <dt class="dl-horizontal">详细设计：</dt>
                                        <dd>
                                            <div class="input-daterange input-group" id="datepicker">
                                                <input type="text" class="input-sm form-control" name="start" value="2018-6-1" />
                                                <span class="input-group-addon">到</span>
                                                <input type="text" class="input-sm form-control" name="end" value="2018-6-3" />
                                            </div>
                                        </dd>
                                        <dt class="dl-horizontal">编码：</dt>
                                        <dd>
                                            <div class="input-daterange input-group" id="datepicker">
                                                <input type="text" class="input-sm form-control" name="start" value="2018-6-1" />
                                                <span class="input-group-addon">到</span>
                                                <input type="text" class="input-sm form-control" name="end" value="2018-6-3" />
                                            </div>
                                        </dd>
                                        <dt class="dl-horizontal">测试：</dt>
                                        <dd>
                                            <div class="input-daterange input-group" id="datepicker">
                                                <input type="text" class="input-sm form-control" name="start" value="2018-6-1" />
                                                <span class="input-group-addon">到</span>
                                                <input type="text" class="input-sm form-control" name="end" value="2018-6-3" />
                                            </div>
                                        </dd>
                                    </div>
                                </dl>

                            </div>
                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-3">
                                    <button class="btn btn-primary" type="submit">提交</button>
                                </div>
                            </div>
                            <div class="col-sm-5">

                            </div>
                        </div>
                        <%------------------%>
                    </div>
                </div>
            </div>
        </div>
    </div>



    <script>
        $(document).ready(function () {

            $('#loading-example-btn').click(function () {
                btn = $(this);
                simpleLoad(btn, true)
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

    <!-- 全局js -->
    <script src="../../js/jquery.min.js?v=2.1.4"></script>
    <script src="../../js/bootstrap.min.js?v=3.3.6"></script>

    <!-- 自定义js -->
    <script src="../../js/content.js?v=1.0.0"></script>

    <!-- Chosen -->
    <script src="../../js/plugins/chosen/chosen.jquery.js"></script>

    <!-- JSKnob -->
    <script src="../../js/plugins/jsKnob/jquery.knob.js"></script>

    <!-- Input Mask-->
    <script src="../../js/plugins/jasny/jasny-bootstrap.min.js"></script>

    <!-- Data picker -->
    <script  src="../../js/plugins/datapicker/bootstrap-datepicker.js"></script>

    <!-- Prettyfile -->
    <script src="../../js/plugins/prettyfile/bootstrap-prettyfile.js"></script>

    <!-- NouSlider -->
    <script src="../../js/plugins/nouslider/jquery.nouislider.min.js"></script>

    <!-- Switchery -->
    <script src="../../js/plugins/switchery/switchery.js"></script>

    <!-- IonRangeSlider -->
    <script src="../../js/plugins/ionRangeSlider/ion.rangeSlider.min.js"></script>
    <script src="../../js/plugins/ionRangeSlider/ion.rangeSlider.min.js"></script>

    <!-- iCheck -->
    <script src="../../js/plugins/iCheck/icheck.min.js"></script>

    <!-- MENU -->
    <script src="../../js/plugins/metisMenu/jquery.metisMenu.js"></script>

    <!-- Color picker -->
    <script src="../../js/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>

    <!-- Clock picker -->
    <script src="../../js/plugins/clockpicker/clockpicker.js"></script>

    <!-- Image cropper -->
    <script src="../../js/plugins/cropper/cropper.min.js"></script>

    <script src="../../js/demo/form-advanced-demo.js"></script>

    <script src="../../js/plugins/datapicker/bootstrap-datepicker.js"></script>
    <script src="../../js/plugins/datapicker/bootstrap-datepicker.zh-CN.js"></script>

    <script>
        $('.date-picker').datepicker({
            language: 'zh-CN',
            autoclose: true,
            todayHighlight: true
        })
    </script>


</body>

</html>
