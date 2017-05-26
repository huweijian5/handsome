/**
 * Created by hwj on 2017/5/25.
 */
function login() {


    alert("ddd")
    $.ajax({
        url: "/user/login",
        type: "post",
        data: {"account": "admin", "password": "admin"},
        async: false,//是否异步
        success: function (data) {
            if (data.code == 1) {
                alert("success:" + data.data.userId)
            } else {
                alert("failed:" + data.message)
            }

        },
        error: function (error) {
            alert("error")
        }
    });
}

$("#loginBtn").onClick = function () {
    alert("dddsss")
    login()

}

function onKeyDown(e) {

    if(e.keyCode==13){
        alert("enter")
    }
}

