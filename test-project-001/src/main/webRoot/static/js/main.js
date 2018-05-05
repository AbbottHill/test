
var MainObj = {

    /**
     * login
     * @returns {boolean}
     */
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
                $("#user_pwd").val("")
                CanDoUtils.refreshPage(); //refresh
            },
            complete: function (xhr) {//请求完成

            },
            error: function (xhr, status, msg) {

            }
        };
        $("#login_form").ajaxSubmit(options);
        return false;
    },

    /**
     * logout
     * @returns {boolean}
     */
    userLogout: function () {
        var ajaxObj = {
            url: contextPath + "/user/logout",
            params: {},
            successFunc: CanDoUtils.refreshPage
        };
        CanDoUtils.jqueryAjax(ajaxObj);
    },

    /**
     * init
     */
    init: function () {
        if (!CanDoUtils.isEmptyStr(userName)) {
            $("#nav_user_name").show();
            $("#nav_user").hide();
            $(".chart_room_link").show();
        } else {
            $("#nav_user_name").hide();
            $(".chart_room_link").hide();
            $("#nav_user").show();
        }
    }
};

$(function () {
    MainObj.init();
})