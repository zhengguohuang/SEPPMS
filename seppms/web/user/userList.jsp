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
    <title>selectList.jsp</title>
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
            <td>查看详情</td>
        </tr>
        <c:forEach items="${users}" var="u">
            <tr>
                <td>${u.id}</td>
                <td>${u.avatar}</td>
                <td>${u.number}</td>
                <td>${u.password}</td>
                <td>${u.name}</td>
                <td>${u.sex}</td>
                <td>${u.className}</td>
                <td>${u.email}</td>
                <td>${u.specialty}</td>
                <td>${u.hobby}</td>
                <td>${u.roleId}</td>
                <td>${u.status}</td>
                <td>${u.createTime}</td>

                <td><a href='<c:url value="/user/deleteUser?uid=${u.id}"/> '>删除</a> </td>
                <td><a href='<c:url value="/user/editUser?uid=${u.id}"/> '>修改</a> </td>
                <td><a href='<c:url value="/user/findone?uid=${u.id}"/> '>查看详情</a> </td>
            </tr>
        </c:forEach>
            <tr>
                <td colspan="5" style="text-align: right">
                    <c:forEach begin="1" end="${pages}" step="1" var="i">
                        <%--<a href='<c:url value="/user/findPage?pn=${i}" />'><c:out value="${i}"/></a>&nbsp;&nbsp;--%>
                        <c:if test="${i == param.pn}">
                            [<c:out value="${i}" />]&nbsp;&nbsp;
                        </c:if>
                        <c:if test="${i != param.pn}">
                            <a href='<c:url value="/user/findPage?pn=${i}" />'><c:out value="${i}"/></a>&nbsp;&nbsp;
                        </c:if>
                    </c:forEach>
                </td>
            </tr>
    </table>
</body>
</html>

