<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>文件上传下载</title>
</head>
<body>
<form action='<c:url value="/file/upload?leaderTaskId=${leaderTaskId}"/> ' method="post" enctype="multipart/form-data">
    选择文件:<input type="file" name="file" width="120px">
    <input type="submit" value="上传">
</form>
<hr>
<form action='<c:url value="/file/down"/> ' method="get">
    <input type="submit" value="下载">
</form>
</body>
</html>