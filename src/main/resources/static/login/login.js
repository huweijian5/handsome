/**
 * Created by hwj on 2017/5/25.
 */
function login() {

    var account = $("input[name=account]").val()
    var password = $("input[name=password]").val()
    $.ajax({
        url: "/api/user/login",
        type: "post",
        data: {"account": account, "password": password},
        async: false,//是否异步
        success: function (data) {
            if (data.code == 1) {
                alert("success:" + data.data.userId)
                //跳转到首页
                location.href="/index"
            } else {
                alert("failed:" + data.message)
            }

        },
        error: function (error) {
            alert("error")
        }
    });
}


function onKeyDown(e) {

    if (e.keyCode == 13) {
        alert("enter")
    }
}

