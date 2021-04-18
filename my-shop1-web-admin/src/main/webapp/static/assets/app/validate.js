// /**
//  * 函数对象
//  */
// const Validate = function () {
//     /**
//      * jquery validation
//      */
//     const handlerInitValidate = function () {
//         $.validator.addMethod("mobile", function (value, element) {
//             var length = value.length;
//             var mobile = /^((13[0-9])|(19[^4,\D])|(19[0,5-9]))\d{8}$/;
//             return this.optional(element) || (length == 11 && mobile.test(value));
//         }, "手机号码格式错误");
//
//         $("#inputForm").validate({
//             errorElement: 'span',
//             errorClass: 'help-block',
//
//             errorPlacement: function (error, element) {
//                 element.parent().parent().attr("class", "is-invalid");
//                 error.insertBefore(element);
//             }
//         });
//     };
//
//
//
//
//
//     return {
//         init: function () {
//             handlerInitValidate();
//         }
//     }
// }();
// $(document).ready(function () {
//     Validate.init();
// });