<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1px">
    <tr>
        <td>ID</td>
        <td>name</td>
        <td>leader number</td>
        <td>teacheri number</td>
        <td>status</td>
        <td>createtime</td>
        <td>membernumber</td>




        <td>删除</td>
        <td>修改</td>
        <td>查看详情</td>
    </tr>
    <c:forEach items="${groups}" var="g">
        <tr>
            <td>${g.id}</td>
            <td>${g.name}</td>
            <td>${g.leader.number}</td>
            <td>${g.teacher.number}</td>
            <td>${g.status}</td>
            <td type="date">${g.createTime}</td>
            <c:forEach items="${g.members}" var="m">
                <c:out value="${m.number} "/>
            </c:forEach>


            <td><a href='<c:url value="/user/deleteUser?uid=${g.id}"/> '>删除</a> </td>
            <td><a href='<c:url value="/user/editUser?uid=${g.id}"/> '>修改</a> </td>
            <td><a href='<c:url value="/user/findone?uid=${g.id}"/> '>查看详情</a> </td>
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