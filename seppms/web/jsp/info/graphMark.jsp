<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>软件工程实践过程管理系统 - 我的成绩</title>
    <meta name="keywords" content="软件工程,管理系统,软件工程过程实践,软件工程过程实践管理系统,SEPPMS,Software engineering process practice management system">
    <meta name="description" content="软件工程实践过程管理系统, 软件工程实践课程设计">

    <link rel="shortcut icon" href="../../favicon.ico"> <link href="../../css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="../../css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <link href="../../css/animate.css" rel="stylesheet">
    <link href="../../css/style.css?v=4.1.0" rel="stylesheet">





</head>

<body class="gray-bg">
    <div class="row  border-bottom white-bg dashboard-header">
        <div class="col-sm-12">
            <p>ECharts开源来自百度商业前端数据可视化团队，基于html5 Canvas，是一个纯Javascript图表库，提供直观，生动，可交互，可个性化定制的数据可视化图表。创新的拖拽重计算、数据视图、值域漫游等特性大大增强了用户体验，赋予了用户对数据进行挖掘、整合的能力。 <a href="http://echarts.baidu.com/doc/about.html" target="_blank">了解更多</a>
            </p>
            <p>ECharts官网：<a href="http://echarts.baidu.com/" target="_blank">http://echarts.baidu.com/</a>
            </p>
        </div>
    </div>
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            
            <div class="col-sm-6">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>成绩</h5>
                        <div class="ibox-tools">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                            <a class="close-link">
                                <i class="fa fa-times"></i>
                            </a>
                        </div>
                    </div>
                    <div class="ibox-content">

                        <div class="echarts" id="echarts-bar-chart"></div>
                    </div>
                </div>
            </div>
        
        <div class="col-sm-6">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>成绩组成</h5>
                        <div class="ibox-tools">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                            <a class="close-link">
                                <i class="fa fa-times"></i>
                            </a>
                        </div>
                    </div>
                    <div class="ibox-content">
                        <div class="echarts" id="echarts-pie-chart"></div>
                    </div>
                </div>
            </div>
            </div>
    </div>
    <!-- 全局js -->
    <script src="../../js/jquery.min.js?v=2.1.4"></script>
    <script src="../../js/bootstrap.min.js?v=3.3.6"></script>

    <!-- ECharts -->
    <script src="../../js/plugins/echarts/echarts-all.js"></script>

    <!-- 自定义js -->
    <script src="../../js/content.js?v=1.0.0"></script>

    <script>
        $(function () {

            var barChart = echarts.init(document.getElementById("echarts-bar-chart"));
            var baroption = {
                title : {
                    text: '我的成绩与班级平均'
                },
                tooltip : {
                    trigger: 'axis'
                },
                legend: {
                    data:['我的成绩','班级平均成绩']
                },
                grid:{
                    x:30,
                    x2:40,
                    y2:24
                },
                calculable : true,
                xAxis : [
                    {
                        type : 'category',
                        data : ['平时成绩','文档成绩','答辩成绩']
                    }
                ],
                yAxis : [
                    {
                        type : 'value'
                    }
                ],
                series : [
                    {
                        name:'我的成绩',
                        type:'bar',
                        data:[<c:out value="${myMark.daily}" />, <c:out value="${myMark.reply}" />, <c:out value="${myMark.document}" />],
                        markPoint : {
                            data : [
                                {type : 'max', name: '最大值'},
                                {type : 'min', name: '最小值'}
                            ]
                        },
                        markLine : {
                            data : [
                                {type : 'average', name: '平均值'}
                            ]
                        }
                    },
                    {
                        name:'班级平均',
                        type:'bar',
                        data:[<c:out value="${classDaily}" />, <c:out value="${classReply}" />, <c:out value="${clssDocument}" />],
                        markPoint : {
                            data : [
                                {type : 'max', name: '最大值'},
                                {type : 'min', name: '最小值'}
                            ]
                        },
                        markLine : {
                            data : [
                                {type : 'average', name : '平均值'}
                            ]
                        }
                    }
                ]
            };
            barChart.setOption(baroption);
            $(window).resize(barChart.resize);

            var pieChart = echarts.init(document.getElementById("echarts-pie-chart"));
            var pieoption = {
                title : {
                    text: '实践成绩组成',
                    subtext: '',
                    x:'center'
                },
                tooltip : {
                    trigger: 'item',
                    formatter: "{a} <br/>{b} : {c} ({d}%)"
                },
                legend: {
                    orient : 'vertical',
                    x : 'left',
                    data:['平时成绩','答辩成绩','文档成绩']
                },
                calculable : true,
                series : [
                    {
                        name:'成绩组成',
                        type:'pie',
                        radius : '55%',
                        center: ['50%', '60%'],
                        data:[
                            {value:10, name:'平时成绩'},
                            {value:60, name:'答辩成绩'},
                            {value:30, name:'文档成绩'}
                        ]
                    }
                ]
            };
            pieChart.setOption(pieoption);
            $(window).resize(pieChart.resize);

        });

    </script>

</body>

</html>
