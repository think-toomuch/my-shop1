<%--
  Created by IntelliJ IDEA.
  User: l1957
  Date: 2021/4/6
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>我的商城 | 用户列表</title>
    <jsp:include page="../includes/header.jsp" />
</head>

<body class="hold-transition sidebar-mini">
<div class="wrapper">
    <!-- navbar -->
    <jsp:include page="../includes/nav.jsp" />
    <!-- /.navbar -->

    <!-- Main Sidebar Container -->
    <jsp:include page="../includes/menu.jsp" />
    <!-- ./Main Sidebar Container -->

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">

        <!-- Content Header (Page header) -->
        <div class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1 class="m-0">用户管理</h1>
                    </div><!-- /.col -->
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">首页</a></li>
                            <li class="breadcrumb-item active">控制面板</li>
                        </ol>
                    </div><!-- /.col -->


                    <!--搜索-->
                    <div class="row">
                        <form:form id="inputForm" cssClass="form-horizontal" action="/user/search" method="post" modelAttribute="tbUser">
                            <div class="card-body row">
                                <div class="col-xs-3" style="padding-left: 10px">
                                    <div class="form-group">
                                        <label for="email" class="control-label">邮箱</label>
                                        <form:input path="email"  cssClass="form-control" placeholder="请输入邮箱" />
                                    </div>
                                </div>
                                <div class="col-xs-3" style="padding-left: 10px">
                                    <div class="form-group">
                                        <label for="username" class="control-label">姓名</label>
                                        <form:input path="username" type="text" cssClass="form-control" placeholder="请输入用户的姓名" />
                                    </div>
                                </div>
                                <div class="col-xs-3" style="padding-left: 10px">
                                    <div class="form-group">
                                        <label for="phone" class="control-label">手机</label>
                                        <form:input path="phone" type="phone" cssClass="form-control mobile" placeholder="请输入用户的手机号" />
                                    </div>

                                </div>
                            </div>
                            <div class="form-group" style="padding-left: 10px">
                                <button type="submit" class="btn btn-info">搜索</button>
                            </div>
                        </form:form>
                    </div>


                </div><!-- /.row -->
            </div><!-- /.container-fluid -->
        </div>
        <!-- /.content-header -->

        <!-- Main content -->
        <div class="content">
            <div class="container-fluid">
                <!--表格-->
                <div class="row">
                    <div class="col-12">
                        <%--判断添加成功--%>
                        <c:if test="${baseResult!=null}">
                            <div class="alert alert-${baseResult.status==200? "success":"danger"} alert-dismissible">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                    ${baseResult.message}
                            </div>
                        </c:if>

                        <div class="card">
                            <div class="card-header">
                                <h3 class="card-title">用户列表</h3>
                            </div>
                            <div class="card-body" style="padding-left: 12px;padding-top: 10px;padding-bottom: 0px">
                                <a href="/user/form" type="button" class="btn btn-default btn-sm"><i class="fa fa-plus"></i>新增</a>&nbsp;&nbsp;&nbsp;
                                <button onclick="App.deleteMulti('/user/delete')" type="button" class="btn btn-default btn-sm"><i class="fa fa-trash"></i>删除</button>&nbsp;&nbsp;&nbsp;
                                <a href="#" type="button" class="btn btn-default btn-sm"><i class="fa fa-download"></i>导入</a>&nbsp;&nbsp;&nbsp;
                                <a href="#" type="button" class="btn btn-default btn-sm"><i class="fa fa-upload"></i>导出</a>
                            </div>



                            <!-- /.card-header -->
                            <div class="card-body table-responsive">
                                <table id="dataTable" class="table table-hover text-nowrap">
                                    <thead>
                                    <tr>
                                        <th>
                                            <div class="icheck-primary d-inline">
                                                <input type="checkbox"  id="checkboxMaster">
                                                <label for="checkboxMaster">
                                                </label>
                                            </div>
                                        </th>
                                        <th>ID</th>
                                        <th>用户名</th>
                                        <th>手机号</th>
                                        <th>邮箱</th>
                                        <th>更新时间</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
<%--                                    <c:forEach items="${tbUsers}" var="tbuser">--%>
<%--                                        <tr>--%>
<%--                                            <td>--%>
<%--                                                <div class="icheck-primary d-inline">--%>
<%--                                                    <input type="checkbox" class="check-box" id="${tbuser.id}">--%>
<%--                                                    <label for="${tbuser.id}">--%>
<%--                                                    </label>--%>
<%--                                                </div>--%>
<%--                                            </td>--%>
<%--                                            <td>${tbuser.id}</td>--%>
<%--                                            <td>${tbuser.username}</td>--%>
<%--                                            <td>${tbuser.phone}</td>--%>
<%--                                            <td>${tbuser.email}</td>--%>
<%--                                            <td>--%>
<%--                                                <fmt:formatDate value="${tbuser.updated}" pattern="yyyy-MM-dd HH:mm:ss" />--%>
<%--                                            </td>--%>
<%--                                            <td>--%>
<%--                                                <a href="#" type="button" class="btn btn-default btn-sm"><i class="fa fa-search"></i>查看</a>--%>
<%--                                                <a href="#" type="button" class="btn btn-primary btn-sm"><i class="fa fa-edit"></i>修改</a>--%>
<%--                                                <a href="#" type="button" class="btn btn-danger btn-sm"><i class="fa fa-trash"></i>删除</a>--%>
<%--                                            </td>--%>
<%--                                        </tr>--%>
<%--                                    </c:forEach>--%>


                                    </tbody>
                                </table>
                            </div>
                            <!-- /.card-body -->
                        </div>
                        <!-- /.card -->
                    </div>
                </div>
                <!-- /.row -->


            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /.content -->

    </div>
    <!-- /.content-wrapper -->

    <!-- Main Footer -->
    <jsp:include page="../includes/copyright.jsp" />


   

</div>
<!-- ./wrapper -->
<!--自定义模态框 -->
<jsp:include page="../includes/footer.jsp" />
<sys:modal/>
<script>
    $(function () {
        const _columns = [
            {
                "data": function (row, type, val, meta) {
                    return '<div class="icheck-primary d-inline">\n' +
                        '\t<input type="checkbox" class="check-box" id="' + row.id + '">\n' +
                        '\t<label for="' + row.id + '"></label>\n' +
                        '</div>';
                }
            },
            {"data": "id"},
            {"data": "username"},
            {"data": "phone"},
            {"data": "email"},
            {"data": "updated"},
            {
                "data": function (row, type, val, meta) {
                    const detailUrl = "/user/detail?id=" + row.id;
                    return '<button type="button" onclick="App.showDetail(\''+detailUrl+'\')" class="btn btn-default btn-sm"><i class="fa fa-search"></i>查看</button>\n' +
                        '<a href="/user/form?id=' + row.id + '" type="button" class="btn btn-primary btn-sm"><i class="fa fa-edit"></i>修改</a>\n' +
                        '<a href="#" type="button" class="btn btn-danger btn-sm"><i class="fa fa-trash"></i>删除</a>';
                }
            }
        ];
        App.initDataTables("/user/page",_columns);
    });
</script>
</body>
</html>
