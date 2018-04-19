
var MainObj = {
    userLogin: function () {
        if (CanDoUtils.isEmptyStr($("#user_account").val())) {
            $("#user_account").focus();
            return false;
        }
        var options = {
            type: 'post',
            beforeSend: function (xhr) {//请求之前

            },
            success: function (data) {
                $("#user_account").val("");
                $("#user_pwd").val("");
                if (data.login_status == 1) {
                    $("#nav_user_name").html(data.user_name)
                }
            },
            complete: function (xhr) {//请求完成

            },
            error: function (xhr, status, msg) {

            }
        };
        $("#login_form").ajaxSubmit(options);
        return false;
    }


}
