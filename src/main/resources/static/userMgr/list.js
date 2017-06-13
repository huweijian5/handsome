/**
 * Created by hwj on 2017/5/31.
 */
$(document).ready(function () {
    loadList()
});

var userList;

function loadList() {
    $.ajax({
        url: "/api/user/getUserList",
        type: "get",
        data: {"page": 0, "size": 10},
        async: false,//是否异步
        success: function (data) {
            if (data.code == 1) {
                userList=data.data.content;
                //alert("success:" + data.data.content[0].userName)
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

function addUser(){

    var username=$("#username").val()
    var nickname=$("#nickname").val()
    var mobilePhone=$("#mobilePhone").val()
    $.ajax({
        url: "/api/user/add",
        type: "post",
        data: {"userName": username,"nickName":nickname,"mobilePhone":mobilePhone},
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