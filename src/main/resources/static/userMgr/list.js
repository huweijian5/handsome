/**
 * Created by hwj on 2017/5/31.
 */
$(document).ready(function () {
    loadList()
});

function loadList() {
    $.ajax({
        url: "/api/user/getUserList",
        type: "post",
        data: {"page": 0, "size": 10},
        async: false,//是否异步
        success: function (data) {
            if (data.code == 1) {
                alert("success:" + data.data.content[0].userName)
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