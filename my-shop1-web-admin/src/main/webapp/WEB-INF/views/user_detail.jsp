<%--
  Created by IntelliJ IDEA.
  User: l1957
  Date: 2021/5/5
  Time: 23:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>我的 | 用户详情</title>
    <jsp:include page="../includes/header.jsp"/>
</head>

<div class="card-body">
    <table id="dataTable" class="table table-hover">
        <tbody>
        <tr>
            <td>邮箱:</td>
            <td>${tbUser.email}</td>
        </tr>
        <tr>
            <td>姓名:</td>
            <td>${tbUser.username}</td>
        </tr>
        <tr>
            <td>phone:</td>
            <td>${tbUser.phone}</td>
        </tr>
        <tr>
            <td>创建时间:</td>
            <td><fmt:formatDate value="${tbUser.created}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
        </tr>
        <tr>
            <td>更新时间:</td>
            <td><fmt:formatDate value="${tbUser.updated}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
        </tr>
        </tbody>
    </table>
</div>

</html>

