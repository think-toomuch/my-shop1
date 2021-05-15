<%--
  Created by IntelliJ IDEA.
  User: l1957
  Date: 2021/4/6
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
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

                </div><!-- /.row -->
            </div><!-- /.container-fluid -->
        </div>
        <!-- /.content-header -->

<%--        搜索--%>
        <!-- Horizontal Form -->
        <div class="content content-search" style="display:none;">
            <div class="container-fluid">
                <div class="card card-info">
                    <div class="card-header">
                        <h3 class="card-title">高级搜索</h3>
                    </div>
                    <!-- /.card-header -->
                        <div class="card-body">
                            <div class="row form-horizontal">
                                <div class="col-xs-12 col-sm-3">
                                    <div class="form-group row">
                                        <label for="email" class="col-sm-2 col-form-label">邮箱</label>
                                        <div class="col-sm-10">
                                            <input id="email" class="form-control" placeholder="请输入邮箱">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xs-12 col-sm-3">
                                    <div class="form-group row">
                                        <label for="username" class="col-sm-2 col-form-label">姓名</label>
                                        <div class="col-sm-10">
                                            <input id="username" type="text" class="form-control" placeholder="请输入用户的姓名">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xs-12 col-sm-3">
                                    <div class="form-group row">
                                        <label for="phone" class="col-sm-2 col-form-label">手机</label>
                                        <div class="col-sm-10">
                                            <input id="phone" class="form-control" placeholder="请输入用户的手机号">
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                        <!-- /.card-body -->
                        <div class="card-footer">
                            <button type="button" onclick="search();" class="btn btn-info float-right">搜索</button>
                        </div>
                        <!-- /.card-footer -->
                </div>
                <!-- /.card -->
            </div>
        </div>


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
                                <button onclick="App.deleteMulti('/user/delete',null)" type="button" class="btn btn-default btn-sm"><i class="fa fa-trash"></i>删除</button>&nbsp;&nbsp;&nbsp;
                                <a href="#" type="button" class="btn btn-default btn-sm"><i class="fa fa-download"></i>导入</a>&nbsp;&nbsp;&nbsp;
                                <a href="#" type="button" class="btn btn-default btn-sm"><i class="fa fa-upload"></i>导出</a>&nbsp;&nbsp;&nbsp;
                                <button type="button" onclick="$('.content-search').css('display')=='none'?$('.content-search').show('fast'):$('.content-search').hide('fast')" class="btn btn-primary btn-sm"><i class="fa fa-search"></i>搜索</button>
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
    let dataTable;
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
                    const id=row.id;
                    return '<button type="button" onclick="App.showDetail(\''+detailUrl+'\')" class="btn btn-default btn-sm"><i class="fa fa-search"></i>查看</button>\n' +
                        '<a href="/user/form?id=' + row.id + '" type="button" class="btn btn-primary btn-sm"><i class="fa fa-edit"></i>修改</a>\n' +
                        '<button onclick="App.deleteMulti(\'/user/delete\',\''+id+'\')" type="button" class="btn btn-danger btn-sm"><i class="fa fa-trash"></i>删除</button>';
                }
            }
        ];
        dataTable=App.initDataTables("/user/page",_columns);
    });
    function search() {
        const username = $("#username").val();
        const email = $("#email").val();
        const phone = $("#phone").val();
        const param = {
            "username": username,
            "email": email,
            "phone":phone
        };
        dataTable.settings()[0].ajax.data = param;
        dataTable.ajax.reload();
    }
</script>
</body>
</html>
