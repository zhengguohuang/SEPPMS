<%--
  Created by IntelliJ IDEA.
  User: zhengguohuang
  Date: 2018/5/13
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>selectOne.jsp</title>
    <link rel="stylesheet" type="text/css" href="../css/userList.css">
</head>
<body>
hello
    <table border="1px">
        <tr>
            <td>ID</td>
            <td>头像</td>
            <td>编号</td>
            <td>密码</td>
            <td>姓名</td>
            <td>性别</td>
            <td>班级</td>
            <td>电邮</td>
            <td>专长</td>
            <td>爱好</td>
            <td>角色id</td>
            <td>状态</td>
            <td>创建时间</td>


            <td>删除</td>
            <td>修改</td>
        </tr>
            <tr>
                <td>${user.id}</td>
                <td>${user.avatar}</td>
                <td>${user.number}</td>
                <td>${user.password}</td>
                <td>${user.name}</td>
                <td>${user.sex}</td>
                <td>${user.className}</td>
                <td>${user.email}</td>
                <td>${user.specialty}</td>
                <td>${user.hobby}</td>
                <td>${user.roleId}</td>
                <td>${user.status}</td>
                <td>${user.createTime}</td>

                <td><a href='<c:url value="/user/deleteUser?uid=${user.id}"/> '>删除</a> </td>
                <td><a href='<c:url value="/user/editUser?uid=${user.id}"/> '>修改</a> </td>
            </tr>
    </table>
</body>
</html>

