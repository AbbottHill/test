var url = ctx + "getServer";
var ws = null;
(function startWebSocket(url) {
    queryTimes();
})(url);

function initWebSocket () {
    if ('WebSocket' in window) {
        ws = new WebSocket(url);
    } else if ('MozWebSocket' in window) {
        ws = new MozWebSocket(url);
    } else {
        console.error("not support WebSocket!");
    }

    ws.onmessage = function (evt) {
        document.getElementById("testSpan").innerHTML = document.getElementById("testSpan").innerHTML + "<br>" + evt.data;
        console.info(evt);
    };

    ws.onclose = function (evt) {
        console.info("close");
        console.info(evt);
    };

    ws.onopen = function (evt) {
        console.info("open");
        console.info(evt);
    };
}


function sendMsg() {
    ws.send(document.getElementById('writeMsg').value);
}

function queryTimes() {
    var params = {};
    params["service"] = "pollingService";
    params["method"] = "getTimes";
    $.ajax({
        url: "/servlet_01",
        type: "post",
        data: params,
        dataType: "json",
        timeout: 1000 * 10,             // async: false，temeout 属性无效
        beforeSend: function () {

        },
        success: function (data) {
            document.getElementById("testSpan").innerHTML = document.getElementById("testSpan").innerHTML + "<br>" + "times: " + data.times;
            initWebSocket();
        },
        error: function () {
            easyDialog.open({
                container: {
                    header: LANG["login_prompt"],
                    content: LANG["all_station_requesttimeout"]
                },
                fixed: false
            });
        }
    });

}