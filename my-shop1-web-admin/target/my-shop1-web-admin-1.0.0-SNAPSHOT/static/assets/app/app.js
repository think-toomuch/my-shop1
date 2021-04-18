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
    const handleerDeleteMulti=function (url) {
        idArray=new Array();
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
        //展示模态框
        $("#modal-default").modal("show");
        //给确定按钮绑定事件
        $("#btnModalOk").bind("click",function () {
            del();
        });

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
                            if(data.status===200){
                                window.location.reload();
                            }
                            else
                            {
         // 请求成功后，无论是成功或是失败都需要弹出模态框进行提示，所以这里需要先解绑原来的 click 事件！！！！！
                                $("#btnModalOk").unbind("click");
                                //确定按钮事件绑定为隐藏模态框
                                $("#btnModalOk").bind("click",function () {
                                $("#modal-default").modal("hide");
                                });

                                $("#modal-message").html(data.message);
                                $("#modal-default").modal("show");

                            }
                        }
                    });
                },500)

            }
        }
    };

    return{
        init:function () {
            handlerInitCheckbox();
            handlerCheckboxAll();
        },
        getCheckbox:function () {
            return allcheck;
        },
        deleteMulti:function (url) {
            handleerDeleteMulti(url);
        }
    }
}();
$(document).ready(function () {
    App.init();
});
