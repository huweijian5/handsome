/**
 * Created by hwj on 2017/5/31.
 */
$(document).ready(function () {

});


function addAccess(){

    var accessName=$("#accessname").val()
    var accessUrl=$("#accessurl").val()
    $.ajax({
        url: "/api/access/add",
        type: "post",
        data: {"accessName": accessName,"urls":accessUrl},
        async: false,//是否异步
        success: function (data) {
            if (data.code == 1) {

                alert("add success")
                //跳转到首页
                //location.href = "/index"
            } else {
                alert("failed:" + data.message)
            }

        },
        error: function (error) {
            alert("error")
        }

    })
}