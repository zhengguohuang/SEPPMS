<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Hello ECharts</title>
    <!-- 使用单文件引入的方式使用ECharts.JS -->
    <!-- 全局js -->
    <script src="../../js/jquery.min.js?v=2.1.4"></script>
    <script src="../../js/bootstrap.min.js?v=3.3.6"></script>

    <!-- ECharts -->
    <script src="../../js/plugins/echarts/echarts-all.js"></script>

    <!-- 自定义js -->
    <script src="../../js/content.js?v=1.0.0"></script>

    <!-- ECharts demo data -->
    <script src="../../js/demo/echarts-demo.js"></script>
</head>

<body onload="loadData()">
<div id="content" style="margin:40px auto;width:1300px;height:400px">
    <div id="myBarDiv" style="height: 300px; width: 430px;display:inline-block" ></div>
    <div id="myLineDiv" style="height: 300px; width: 430px;display:inline-block" ></div>
    <div id="myPieDiv" style="height: 300px; width: 430px;display:inline-block" ></div>

    <div id="myTest" style="width: 600px; height: 60px;margin:20px auto">
        <label for="name">商品名称:</label> <input type="text" id="myName">
        <label for="num">销量:</label> <input type="num" id="myNum">
        <button id="myButton" type="submit" onClick="sub()">数据更新</button>
    </div>
</div>






<script type="text/javascript">
    function sub(){
        var j = {"name":$("#myName").val(),"num":$("#myNum").val()};
        $.ajax({
            type: 'post',
            url: 'jso.do',
            dataType: 'json',
            data: {"name":$("#myName").val(),"num":$("#myNum").val()},
            contentType: "application/x-www-form-urlencoded" ,
            success: function (message) {
                alert("success");
            }

        });
        window.location.reload();
    }
</script>

<script type="text/javascript">

    function loadData(option) {
        $.ajax({
            type : 'post',	//传输类型
            async : false,	//同步执行
            url : 'bar.do',	//web.xml中注册的Servlet的url-pattern
            data : {},
            dataType : 'json', //返回数据形式为json
            success : function(result) {
                if (result) {
                    //初始化xAxis[0]的data
                    option.xAxis[0].data = [];
                    for (var i=0; i<result.length; i++) {
                        option.xAxis[0].data.push(result[i].name);
                    }
                    //初始化series[0]的data
                    option.series[0].data = [];
                    for (var i=0; i<result.length; i++) {
                        option.series[0].data.push(result[i].num);
                    }
                }
            },
            error : function(errorMsg) {
                alert("加载数据失败");
            }
        });//AJAX
    }//loadData()

    var myChart = echarts.init(document.getElementById('myBarDiv'));
    var option = {
        title: {
            text: 'ECharts技术(柱状图)'
        },

        tooltip : {
            show : true
        },
        legend : {
            data : [ '销量' ]
        },
        xAxis : [ {
            type : 'category'

        } ],
        yAxis : [ {
            type : 'value'
        } ],
        series : [ {
            name : '销量',
            type : 'bar'
        } ]
    };
    //加载数据到option
    loadData(option);
    //设置option
    myChart.setOption(option);
</script>

<script type="text/javascript">

    function loadData(option) {
        $.ajax({
            type : 'post',	//传输类型
            async : false,	//同步执行
            url : 'bar.do',	//web.xml中注册的Servlet的url-pattern
            data : {},
            dataType : 'json', //返回数据形式为json
            success : function(result) {
                if (result) {
                    //初始化xAxis[0]的data
                    option.xAxis[0].data = [];
                    for (var i=0; i<result.length; i++) {
                        option.xAxis[0].data.push(result[i].name);
                    }
                    //初始化series[0]的data
                    option.series[0].data = [];
                    for (var i=0; i<result.length; i++) {
                        option.series[0].data.push(result[i].num);
                    }
                }
            },
            error : function(errorMsg) {
                alert("加载数据失败");
            }
        });//AJAX
    }//loadData()

    var myChart = echarts.init(document.getElementById('myLineDiv'));
    var option = {
        title: {
            text: 'ECharts技术(折线图)'
        },

        tooltip : {
            show : true
        },
        legend : {
            data : [ '销量' ]
        },
        xAxis : [ {
            type : 'category'

        } ],
        yAxis : [ {
            type : 'value'
        } ],
        series : [ {
            name : '销量',
            type : 'line'
        } ]
    };
    //加载数据到option
    loadData(option);
    //设置option
    myChart.setOption(option);
</script>


<script type="text/javascript">
    function loadData() {

        $.ajax({
            type : 'post', //传输类型
            async : false, //同步执行
            url : 'bar.do', //web.xml中注册的Servlet的url-pattern
            data : {},
            dataType : 'json', //返回数据形式为json
            success : function(result) {

                if (result) {
                    var myChart = echarts.init(document
                        .getElementById('myPieDiv'));
                    var option = {
                        title: {
                            text: 'ECharts技术(饼图)'
                        },
                        series : [ {
                            name : '商品名称',
                            type : 'pie',
                            radius : '65%',
                            data : [ {
                                value : result[0].num,
                                name : 'pants'
                            }, {
                                value : result[1].num,
                                name : 'skirt'
                            }, {
                                value : result[2].num,
                                name : 'coat'
                            }, {
                                value : result[3].num,
                                name : 'shoes'
                            } ]
                        } ]
                    };

                    myChart.setOption(option);
                }
            },
            error : function(errorMsg) {
                alert("加载数据失败");
            }
        });//AJAX
    }//loadData()
</script>

</script>
</body>
</html>
