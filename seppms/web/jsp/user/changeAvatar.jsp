<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>软件工程实践过程管理系统 - 主页</title>

    <meta name="keywords" content="软件工程,管理系统,软件工程过程实践,软件工程过程实践管理系统,SEPPMS,Software engineering process practice management system">
    <meta name="description" content="软件工程实践过程管理系统, 软件工程实践课程设计">

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
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">

                <div class="ibox float-e-margins">
                    <div class="ibox-title  back-change">
                        <h5>修改头像</h5>
                    </div>
                    <div class="ibox-content">
                        <div class="row">
                            <div class="col-md-6">
                                <div class="image-crop">
                                    <img src="../../img/a3.jpg">
                                </div>
                            </div>
                            <div class="col-md-6">
                                <h4>图片预览：</h4>
                                <div class="img-preview img-preview-sm"></div>
                                <h4>说明：</h4>
                                <p>
                                    你可以选择新图片上传，然后修改头像为裁剪后的图片
                                </p>
                                <div class="btn-group">
                                    <label title="上传图片" for="inputImage" class="btn btn-primary">
                                        <input type="file" accept="image/*" name="file" id="inputImage" class="hide"> 上传新图片
                                    </label>
                                    <label title="修改头像" id="download" class="btn btn-primary">修改头像</label>
                                </div>
                                <br>
                                <div class="btn-group">
                                    <button class="btn btn-white" id="zoomIn" type="button">放大</button>
                                    <button class="btn btn-white" id="zoomOut" type="button">缩小</button>
                                    <button class="btn btn-white" id="rotateLeft" type="button">左旋转</button>
                                    <button class="btn btn-white" id="rotateRight" type="button">右旋转</button>
                                    <button class="btn btn-warning" id="setDrag" type="button">裁剪</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">颜色选择</h4>
                </div>
                <div class="modal-body">
                    <div class="input-group colorpicker-component demo demo-auto">
                        <input type="text" value="" class="form-control" />
                        <span class="input-group-addon"><i></i></span>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>

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
    <script src="../../js/plugins/datapicker/bootstrap-datepicker.js"></script>

    <!-- Prettyfile -->
    <script src="../../js/plugins/prettyfile/bootstrap-prettyfile.js"></script>

    <!-- NouSlider -->
    <script src="../../js/plugins/nouslider/jquery.nouislider.min.js"></script>

    <!-- Switchery -->
    <script src="../../js/plugins/switchery/switchery.js"></script>

    <!-- IonRangeSlider -->
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


</body>

</html>
