<%--
  Created by IntelliJ IDEA.
  User: zhengguohuang
  Date: 2018/6/2
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script type="text/javascript">
    onload=function(){
        setInterval(go, 1000);
    };
    var x=6; //利用了全局变量来执行
    function go(){
        x--;
        if(x>0){
            document.getElementById("sp").innerHTML=x;  //每次设置的x的值都不一样了。
        }else{
            location.href='/group/findAll';
        }
    }
</script>
<body>
    操作成功,<span id="sp" ></span>秒后返回
</body>
</html>
