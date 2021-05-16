<%--
  Created by IntelliJ IDEA.
  User: l1957
  Date: 2021/5/15
  Time: 19:46
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
    <title>我的商城 | 内容管理</title>
    <link rel="stylesheet" href="/static/assets/plugins/jquery-treetable-3.2.0-0/css/jquery.treetable.css">
    <link rel="stylesheet" href="/static/assets/plugins/jquery-treetable-3.2.0-0/css/jquery.treetable.theme.default.css">
    <link rel="stylesheet" href="/static/assets/plugins/jquery-treetable-3.2.0-0/css/screen.css">
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
                        <h1 class="m-0">内容管理</h1>
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

        <!-- Main content -->
        <div class="content">
            <div class="container-fluid">
                <!--表格-->
                <div class="row">
                    <div class="col-12">
                        <%--判断添加成功--%>
                        <c:if test="${baseResult!=null}">
                            <div class="alert alert-${baseResult.status==200? " success":"danger"} alert-dismissible">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                    ${baseResult.message}
                            </div>
                        </c:if>

                        <div class="card">
                            <div class="card-header">
                                <h3 class="card-title">分类列表</h3>
                            </div>
                            <div class="card-body" style="padding-left: 12px;padding-top: 10px;padding-bottom: 0px">
                                <a href="#" type="button" class="btn btn-default btn-sm"><i class="fa fa-plus"></i>新增</a>&nbsp;&nbsp;&nbsp;
                                <a href="#" type="button" class="btn btn-default btn-sm"><i class="fa fa-download"></i>导入</a>&nbsp;&nbsp;&nbsp;
                                <a href="#" type="button" class="btn btn-default btn-sm"><i class="fa fa-upload"></i>导出</a>&nbsp;&nbsp;&nbsp;
                            </div>



                            <!-- /.card-header -->
                            <div class="card-body table-responsive">
                                <table id="treeTable" class="table table-hover text-nowrap treeTable">
                                    <thead>
                                    <tr>
                                        <td>ID</td>
                                        <td>名称</td>
                                        <td>排序</td>
                                        <td>操作</td>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${tbContentCategories}" var="tbContentCategory">
                                        <tr data-tt-id="${tbContentCategory.id}" data-tt-parent-id="${tbContentCategory.parentId}">
                                            <td>${tbContentCategory.id}</td>
                                            <td>${tbContentCategory.name}</td>
                                            <td>${tbContentCategory.sortOrder}</td>
                                            <td>
                                                <a href="#" type="button" class="btn btn-primary btn-sm"><i class="fa fa-edit"></i>修改</a>
                                                <a href="#" type="button" class="btn btn-default btn-sm"><i class="fa fa-plus"></i>新增下级菜单</a>
                                                <button  type="button" class="btn btn-danger btn-sm"><i class="fa fa-trash"></i>删除</button>
                                            </td>
                                        </tr>
                                    </c:forEach>
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
<script src="/static/assets/plugins/jquery-treetable-3.2.0-0/jquery.treetable.js"></script>
<sys:modal />
<script>

    $(function() {
        $('#treeTable').treetable({
            "expandable": true,
            "column":1
        });
        console.log("test");
        console.log($('#treeTable'));
    });
</script>
</body>
</html>
