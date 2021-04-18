<%--
  Created by IntelliJ IDEA.
  User: l1957
  Date: 2021/3/6
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>我的商城 | 登录</title>
    <!-- Font Awesome -->
    <link rel="stylesheet" href="../../static/assets/plugins/fontawesome-free/css/all.min.css">
    <!-- icheck bootstrap -->
    <link rel="stylesheet" href="../../static/assets/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="../../static/assets/css/adminlte.min.css">
</head>
<body class="hold-transition login-page">
<div class="login-box">
    <div class="login-logo">
        <b>我的商城</b>登录
    </div>
    <!-- /.login-logo -->
    <div class="card">
        <div class="card-body login-card-body">
            <p class="login-box-msg">欢迎管理员登录</p>
            <div class="alert alert-danger alert-dismissible" ${message==null ? "style='display:none';":""}>
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                <h5><i class="icon fas fa-ban"></i> ${message}</h5>
            </div>
            <form action="/login" method="post">
                <div class="input-group mb-3">
                    <input name="email" type="email" class="form-control" placeholder="电子邮件" value="${email}">
                    <div class="input-group-append">
                        <div class="input-group-text">
                            <span class="fas fa-envelope"></span>
                        </div>
                    </div>
                </div>
                <div class="input-group mb-3">
                    <input name="passwd" type="password" class="form-control" placeholder="密码" value="${passwd}">
                    <div class="input-group-append">
                        <div class="input-group-text">
                            <span class="fas fa-lock"></span>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-8">
                        <div class="icheck-primary">
                            <input type="checkbox" id="remember" name="isRemember" ${isRemember==true ? "checked":""}>
                            <label for="remember">
                                记住我
                            </label>
                        </div>
                    </div>
                    <!-- /.col -->
                    <div class="col-4">
                        <button type="submit" class="btn btn-primary btn-block">登录</button>
                    </div>
                    <!-- /.col -->
                </div>
            </form>
            <p class="mb-1">
                <a href="#">忘记密码</a>
            </p>
            <p class="mb-0">
                <a href="#" class="text-center">注册一个新账号</a>
            </p>
        </div>
    </div>
    <!-- /.login-card-body -->
</div>
<!-- /.login-box -->
<!-- jQuery -->
<script src="../../static/assets/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="../../static/assets/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="../../static/assets/js/adminlte.min.js"></script>
</body>
</html>