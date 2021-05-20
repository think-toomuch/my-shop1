<%--
  Created by IntelliJ IDEA.
  User: l1957
  Date: 2021/5/17
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>我的商城 | 内容管理</title>
    <jsp:include page="../includes/header.jsp"/>
    <link rel="stylesheet" href="../../static/assets/plugins/jquery-ztree/zTreeStyle/zTreeStyle.css"/>
</head>
<!--
`body` tag options:
  Apply one or more of the following classes to to the body tag
  to get the desired effect

  * sidebar-collapse
  * sidebar-mini
-->
<body class="hold-transition sidebar-mini">
<div class="wrapper">
    <!-- navbar -->
    <jsp:include page="../includes/nav.jsp"/>
    <!-- /.navbar -->

    <!-- Main Sidebar Container -->
    <jsp:include page="../includes/menu.jsp"/>
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

                <!-- Horizontal Form -->
                <div class="card card-info">

                    <div class="card-header">
                        <h3 class="card-title">${tbContent.id==null?"新增":"编辑"}内容</h3>
                    </div>

                    <c:if test="${baseResult!=null}">
                        <div class="alert alert-${baseResult.status==200? "success":"danger"} alert-dismissible">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                ${baseResult.message}
                        </div>
                    </c:if>

                    <!-- /.card-header -->
                    <form:form id="inputForm" cssClass="form-horizontal" action="/content/save" method="post"
                               modelAttribute="tbContent">
                        <form:hidden path="id"/>
                        <div class="card-body">
                            <div class="form-group row">
                                <label for="categoryId" class="col-sm-2 col-form-label">父级类目</label>
                                <div class="col-sm-10">
                                    <form:hidden path="categoryId"/>
                                    <input id="categoryName" class="form-control" placeholder="请选择" readonly="true"
                                           data-toggle="modal" data-target="#modal-default"/>
                                </div>
                            </div>

                        </div>
                        <!-- /.card-body -->
                        <div class="card-footer">
                            <button type="submit" class="btn btn-info">提交</button>
                            <button type="button" class="btn btn-default float-right" onclick="history.go(-1)">返回
                            </button>
                        </div>
                        <!-- /.card-footer -->
                    </form:form>
                    <!-- form end -->
                </div>
                <!-- /.card -->

            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /.content -->

    </div>
    <!-- /.content-wrapper -->

    <!-- Main Footer -->
    <jsp:include page="../includes/copyright.jsp"/>

</div>
<!-- ./wrapper -->
<jsp:include page="../includes/footer.jsp"/>
<sys:modal title="请选择" msg="<ul id='myTree' class='ztree' style='width:260px; overflow:auto;'></ul>"/>
</body>
<script src="../../static/assets/plugins/jquery-ztree/js/jquery.ztree.core.js"></script>
<script>
    $(function () {
        App.initZTree("/content/category/tree/data",["id"],function (nodes) {
            const node = nodes[0];
            $('#categoryId').val(node.id);
            $('#categoryName').val(node.name);
            $('#modal-default').modal("hide");
        });
    })

    // $(function () {
    //     const setting = {
    //         view: {
    //             selectedMulti: false
    //         },
    //         async: {
    //             enable: true,
    //             url: "/content/category/tree/data",
    //             //自动把id传数据
    //             autoParam: ["id"]
    //         }
    //     };
    //
    //     $(document).ready(function () {
    //         $.fn.zTree.init($("#myTree"), setting);
    //     });
    //
    //     $('#btnModalOk').bind("click", function (e) {
    //         const zTree = $.fn.zTree.getZTreeObj("myTree"),
    //             nodes = zTree.getSelectedNodes();
    //         if (nodes.length == 0) {
    //             alert("请先选择一个节点");
    //         }
    //         //已选择
    //         else {
    //             const node = nodes[0];
    //             $('#categoryId').val(node.id);
    //             $('#categoryName').val(node.name);
    //             $('#modal-default').modal("hide");
    //         }
    //     });
    // })
</script>
</html>


