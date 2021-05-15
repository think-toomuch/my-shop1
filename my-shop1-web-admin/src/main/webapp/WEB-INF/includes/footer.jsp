<%--
  Created by IntelliJ IDEA.
  User: l1957
  Date: 2021/4/6
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="modal fade" id="modal-detail">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">查看详情</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p id="modal-detail-body"></p>
            </div>
            <div class="modal-footer justify-content-between">
                <button type="button" class="btn btn-default" data-dismiss="modal">确定</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<!-- /.modal -->


<!-- REQUIRED SCRIPTS -->

<!-- jQuery -->
<script src="../../static/assets/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="../../static/assets/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="../../static/assets/plugins/bootstrap/js/bootstrap.min.js"></script>
<!-- AdminLTE -->
<script src="../../static/assets/js/adminlte.js"></script>
<!-- DataTables  & Plugins -->
<script src="../../static/assets/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="../../static/assets/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
<script src="../../static/assets/plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
<script src="../../static/assets/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
<script src="../../static/assets/plugins/datatables-buttons/js/dataTables.buttons.min.js"></script>
<script src="../../static/assets/plugins/datatables-buttons/js/buttons.bootstrap4.min.js"></script>
<script src="../../static/assets/plugins/jszip/jszip.min.js"></script>
<script src="../../static/assets/plugins/pdfmake/pdfmake.min.js"></script>
<script src="../../static/assets/plugins/pdfmake/vfs_fonts.js"></script>
<script src="../../static/assets/plugins/datatables-buttons/js/buttons.html5.min.js"></script>
<script src="../../static/assets/plugins/datatables-buttons/js/buttons.print.min.js"></script>
<script src="../../static/assets/plugins/datatables-buttons/js/buttons.colVis.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../../static/assets/js/demo.js"></script>
<script src="../../static/assets/app/app.js"></script>
