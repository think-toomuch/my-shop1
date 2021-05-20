const App = function () {
    //控制全选checkbox
    let master;
    //所有checkbox，不包括master
    let allcheck;
    //存放选中checkbox的id值
    let idArray;
    /**
     * 初始化绑定dom
     */
    const handlerInitCheckbox = function () {
        //获取控制全选按钮
        master = $('input[type="checkbox"]#checkboxMaster');
        //分页时刷新更改为初始化状态
        master.prop("checked",false);
        //获取全部checkbox集合
        allcheck = $('input[type="checkbox"].check-box');
    };
    /**
     * checkbox全选功能
     */
    const handlerCheckboxAll = function () {
        master.click(function (e) {
            if (e.target.checked) {
                allcheck.prop("checked", true);
            } else {
                allcheck.prop("checked", false);
            }
        });
    };
    /**
     * 批量删除
     */
    const handleerDeleteMulti=function (url,id) {
        idArray=new Array();
        if(id!=null&&id!=""){
            $("#modal-message").html("您确定删除吗？");
            $("#modal-default").modal("show");
            idArray.push(id);
            //给确定按钮绑定事件
            $("#btnModalOk").bind("click",function () {
                del();
            });
        }
        else
        {
            allcheck.each(function () {
                //得到当前checkbox的id属性的值
                var _id=$(this).attr("id");
                //将选中的id的值放进数组
                if(_id!=null&&_id!="undefine"&&$(this).is(":checked")){
                    idArray.push(_id);
                }
            });
            //根据是否有选中值展示不同消息
            if(idArray.length===0){
                $("#modal-message").html("您还没有选择任何数据项，请至少选择一项");
            }
            else
            {
                $("#modal-message").html("您确定删除吗？");
            }
            //点击删除按钮时展示模态框
            $("#modal-default").modal("show");
            //给确定按钮绑定事件
            $("#btnModalOk").bind("click",function () {
                del();
            });
        }

        /**
         * 当前私有函数的私有函数，删除数据
         */
        function del() {
            //点确定按钮隐藏模态框
            $("#modal-default").modal("hide");
            //如果没有选择数据项就删除模态框
            if(idArray.length===0){
                //..不做处理
            }
            //删除操作
            else {
                setTimeout(function () {
                    $.ajax({
                        "url":url,
                        "type":"POST",
                        "data":{"ids":idArray.toString()},
                        "dataType":"JSON",
                        "success":function (data) {
                            // 请求成功后，无论是成功或是失败都需要弹出模态框进行提示，所以这里需要先解绑原来的 click 事件！！！！！
                            $("#btnModalOk").unbind("click");

                            if(data.status===200){
                                //确定按钮事件绑定为重新刷新
                               $("#btnModalOk").bind("click",function () {
                                    window.location.reload();
                                });
                            }
                            else
                            {
                                //确定按钮事件绑定为隐藏模态框
                                $("#btnModalOk").bind("click",function () {
                                    $("#modal-default").modal("hide");
                            });
                            }
                            //无论如何都需要提示信息，所以模态框是必须调用的
                            $("#modal-message").html(data.message);
                            $("#modal-default").modal("show");
                        }
                    });
                },500)

            }
        }
    };
    /**
     * 初始化DataTables
     */
    const handlerInitDataTables = function (url,columns) {
        const dataTable = $('#dataTable').DataTable({
            "paging": true,
            "lengthChange": false,
            "searching": false,
            "ordering": false,
            "processing": true,
            "info": true,
            "autoWidth": false,
            "responsive": true,
            "serverSide": true,
            "deferRender": true,
            "ajax": {
                "url": url,
                "draw": 20,
                "data":{

                }
            },
            "columns": columns,
            "language": {
                "processing": "处理中...",
                "lengthMenu": "显示 _MENU_ 项结果",
                "zeroRecords": "没有匹配结果",
                "info": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                "infoEmpty": "显示第 0 至 0 项结果，共 0 项",
                "infoFiltered": "(由 _MAX_ 项结果过滤)",
                "infoPostFix": "",
                "search": "搜索:",
                "searchPlaceholder": "搜索...",
                "url": "",
                "emptyTable": "表中数据为空",
                "loadingRecords": "载入中...",
                "infoThousands": ",",
                "paginate": {
                    "first": "首页",
                    "previous": "上页",
                    "next": "下页",
                    "last": "末页"
                },
                "aria": {
                    "paginate": {
                        "first": "首页",
                        "previous": "上页",
                        "next": "下页",
                        "last": "末页"
                    },
                    "sortAscending": "以升序排列此列",
                    "sortDescending": "以降序排列此列"
                },
                "thousands": "."
            },
            "drawCallback": function (settings) {
                handlerInitCheckbox();
                handlerCheckboxAll();
            }
        });
        return dataTable;
    };
    /**
     * 查看详情
     * @param url
     */
    const handlerShowHandler = function (url) {
        //通过ajax请求html的方式将jsp装载进模态框
        $.ajax({
            url: url,
            type: "get",
            datatype: "html",
            success: function (data) {
                $("#modal-detail-body").html(data);
                $("#modal-detail").modal("show");
            }
        });
    };
    /**
     * 初始化zTree
     * @param url
     * @param autoParam
     * @param callback
     */
    const handlerInitZTree=function (url,autoParam,callback) {
        const setting = {
            view: {
                //不可多选
                selectedMulti: false
            },
            async: {
                enable: true,
                url: url,
                //自动把数据传到后台
                autoParam: autoParam
            }
        };

        $(document).ready(function () {
            $.fn.zTree.init($("#myTree"), setting);
        });

        $('#btnModalOk').bind("click", function (e) {
            const zTree = $.fn.zTree.getZTreeObj("myTree"),
                //获取选中节点
                nodes = zTree.getSelectedNodes();
            if (nodes.length == 0) {
                alert("请先选择一个节点");
            }
            //已选择
            else {
                //回调函数，带回nodes
                callback(nodes);
            }
        });
    }
    return{
        /**
         * 初始化
         */
        init:function () {
            handlerInitCheckbox();
            handlerCheckboxAll();
        },
        /**
         * 批量删除
         * @param url
         */
        deleteMulti:function (url,id) {
            handleerDeleteMulti(url,id);
        },
        /**初始化datatables
         *
         * @param url
         * @param columns
         * @returns {jQuery}
         */
        initDataTables:function (url,columns) {
            return handlerInitDataTables(url,columns);
        },
        /**
         * 显示详情
         * @param url
         */
        showDetail:function (url) {
            handlerShowHandler(url);
        },
        /**
         * 初始化zTree
         * @param url
         * @param autoParam
         * @param callback
         */
        initZTree:function (url,autoParam,callback) {
            handlerInitZTree(url,autoParam,callback);
        }
    }
}();
$(document).ready(function () {
    App.init();
});
